package me.rustjerk.itmo.lab3.item;

public class Radio extends Item {
    @Override
    public float getWeight() {
        return 3.0f;
    }

    @Override
    public String getDescription() {
        return "Старое советское радио.";
    }

    @Override
    public String getName() {
        return "Радио";
    }
}
