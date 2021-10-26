package me.rustjerk.itmo.lab3.person.trait;

public class SharpEyed extends Trait {
    @Override
    public String getDescription() {
        return "Зоркий и внимательный.";
    }

    @Override
    public int getRequiredAge() {
        return 37;
    }
}
