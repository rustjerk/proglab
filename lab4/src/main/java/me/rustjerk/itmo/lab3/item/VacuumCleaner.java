package me.rustjerk.itmo.lab3.item;

public class VacuumCleaner extends Item {
    @Override
    public float getWeight() {
        return 5.0f;
    }

    @Override
    public String getDescription() {
        return "Классный, мощный, современный пылесос.";
    }

    @Override
    public String getName() {
        return "Пылесос";
    }
}
