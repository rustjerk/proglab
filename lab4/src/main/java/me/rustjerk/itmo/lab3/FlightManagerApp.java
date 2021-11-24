package me.rustjerk.itmo.lab3;

import me.rustjerk.itmo.lab3.flight.FlightPlan;
import me.rustjerk.itmo.lab3.flight.FlightPlanXMLParser;
import me.rustjerk.itmo.lab3.flight.FlightSimulator;
import me.rustjerk.itmo.lab3.flight.NoPilotException;

import java.io.InputStream;
import java.util.function.BinaryOperator;

public class FlightManagerApp {
    public static void main(String[] args) {
        FlightPlan flightPlan;
        try {
            flightPlan = new FlightPlanXMLParser(getDefaultConfigStream()).parse().build();
        } catch (NoPilotException e) {
            System.out.println("Ты забыл добавить пилота!!!!!!!!!!!!!!!!");
            return;
        }

        System.out.println(flightPlan);
        FlightSimulator simulator = new FlightSimulator(flightPlan);
        simulator.simulate();
    }

    private static InputStream getDefaultConfigStream() {
        return FlightManagerApp.class.getResourceAsStream("/config.xml");
    }
}