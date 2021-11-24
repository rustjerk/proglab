package me.rustjerk.itmo.lab3.person.trait;

public class Curious extends Trait {
    @Override
    public String getDescription() {
        return "Любознательный.";
    }

    @Override
    public int getRequiredAge() {
        return 2;
    }
}
