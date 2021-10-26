package me.rustjerk.itmo.lab3.person.trait;

public class Insane extends Trait {
    @Override
    public String getDescription() {
        return "Сумасшедший.";
    }

    @Override
    public int getRequiredAge() {
        return 30;
    }
}
