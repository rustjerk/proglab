package me.rustjerk.itmo.lab3.person.trait;

public class WellRead extends Trait {
    @Override
    public String getDescription() {
        return "Начитанный.";
    }

    @Override
    public int getRequiredAge() {
        return 14;
    }
}
