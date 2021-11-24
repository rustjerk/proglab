package me.rustjerk.itmo.lab3.item;

import me.rustjerk.itmo.lab3.performance.Act;

import java.util.List;

public class Book extends Item {
    private final List<Act> acts;

    public Book(List<Act> acts) {
        this.acts = acts;
    }

    @Override
    public float getWeight() {
        return 1.0f;
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < acts.size(); i++) {
            Act act = acts.get(i);
            List<String> script = act.getScript();

            sb.append("Акт ").append(i + 1).append(".");
            for (String line : script) {
                sb.append("\n");
                sb.append(line);
            }
        }

        return sb.toString();
    }

    @Override
    public String getName() {
        return "Книга";
    }
}
