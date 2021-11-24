package me.rustjerk.itmo.lab3.flight;

import me.rustjerk.itmo.lab3.goal.*;
import me.rustjerk.itmo.lab3.item.Book;
import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.item.Items;
import me.rustjerk.itmo.lab3.location.GiantMountains;
import me.rustjerk.itmo.lab3.location.Location;
import me.rustjerk.itmo.lab3.person.Person;
import me.rustjerk.itmo.lab3.util.TimeOfDay;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.InputStream;
import java.time.Duration;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("SameParameterValue")
public class FlightPlanXMLParser {
    private final Document xml;
    private final XPath xPath;

    public FlightPlanXMLParser(InputStream stream) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            xml = db.parse(stream);
            xPath = XPathFactory.newInstance().newXPath();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public FlightPlan.Builder parse() {
        return new FlightPlan.Builder(readFlightKind(xml, "/config/kind"))
                .setDuration(readDuration(xml, "/config/duration"))
                .setLocation(readLocation(xml, "/config/location"))
                .setTime(readTimeOfDay(xml, "/config/time"))
                .addCrewMembers(readPersonList(xml, "/config/crew"))
                .addCargoItems(readItemList(xml, "/config/cargo"))
                .addGoals(readGoals(xml, "/config/goals"));
    }

    private Goal[] readGoals(Node root, String query) {
        List<Goal> goals = new ArrayList<>();

        Node node;
        try {
            node = (Node) xPath.compile(query).evaluate(root, XPathConstants.NODE);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            goals.add(readGoal(child));
        }

        return goals.toArray(new Goal[0]);
    }

    private Goal readGoal(Node node) {
        String kind = readString(node, "kind");
        switch (kind) {
            case "ENJOY_SCENERY":
                return new EnjoyScenery();
            case "SEND_REPORT":
                return new SendReport();
            case "FIND_PERSON":
                Person person = materializePerson(readString(node, "person"));
                return new FindPerson(person);
            case "READ_BOOK":
                Item item = materializeItem(readString(node, "book"));
                if (!(item instanceof Book)) {
                    throw new RuntimeException("Предмет " + item.getName() + " не является книгой");
                }
                return new ReadBook((Book) item);
            default:
                throw new RuntimeException("Нет такой цели: " + kind);
        }
    }

    private FlightKind readFlightKind(Node node, String query) {
        String s = readString(node, query);
        try {
            return FlightKind.valueOf(s);
        } catch (IllegalArgumentException ignored) {
            throw new RuntimeException("Неправильное значение (ожидался тип полета) " + query + ": " + s);
        }
    }

    private Person[] readPersonList(Node node, String query) {
        String[] list = readStringList(node, query);
        if (list == null)
            throw new RuntimeException("Не указано поле " + query + " (ожидался массив людей)");
        return Arrays.stream(list).map(this::materializePerson).toArray(Person[]::new);
    }

    private Item[] readItemList(Node node, String query) {
        String[] list = readStringList(node, query);
        if (list == null)
            throw new RuntimeException("Не указано поле " + query + " (ожидался массив предметов)");
        return Arrays.stream(list).map(this::materializeItem).toArray(Item[]::new);
    }

    private Person materializePerson(String name) {
        Class<?> clazz;
        try {
            clazz = Class.forName("me.rustjerk.itmo.lab3.person." + name);
        } catch (ClassNotFoundException ignored) {
            throw new RuntimeException("Я не знаю человека по имени " + name);
        }

        try {
            return (Person) clazz.getConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Человек " + name + " не хочет рождаться");
        }
    }

    private Item materializeItem(String name) {
        try {
            return (Item) Items.class.getDeclaredField(name).get(null);
        } catch (ClassCastException | NoSuchFieldException | IllegalAccessException ignored) {
            throw new RuntimeException("Я не знаю предмета под названием " + name);
        }
    }

    private TimeOfDay readTimeOfDay(Node node, String query) {
        String s = readString(node, query);
        try {
            return TimeOfDay.valueOf(s);
        } catch (IllegalArgumentException ignored) {
            throw new RuntimeException("Неправильное значение (ожидалось время суток) " + query + ": " + s);
        }
    }

    private Duration readDuration(Node node, String query) {
        String s = readString(node, query);
        try {
            return s == null ? Duration.ZERO : Duration.parse(s);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Неправильное значение (ожидалась продолжительность) " + query + ": " + s, e);
        }
    }

    private Location readLocation(Node node, String query) {
        String s = readString(node, query);
        if (s.equals("GIANT_MOUNTAINS")) {
            return new GiantMountains();
        } else {
            throw new RuntimeException("Неправильное значение (ожидалась локация) " + query + ": " + s);
        }
    }

    private String[] readStringList(Node node, String query) {
        try {
            Node cont = (Node) xPath.compile(query).evaluate(node, XPathConstants.NODE);
            if (cont == null) {
                return null;
            }
            NodeList children = cont.getChildNodes();
            List<String> res = new ArrayList<>();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getFirstChild() != null) {
                    res.add(child.getFirstChild().getNodeValue());
                }
            }
            return res.toArray(new String[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String readString(Node node, String query) {
        try {
            return (String) xPath.compile(query).evaluate(node, XPathConstants.STRING);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
