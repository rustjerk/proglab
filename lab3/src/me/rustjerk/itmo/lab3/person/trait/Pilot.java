package me.rustjerk.itmo.lab3.person.trait;

public class Pilot extends Trait {
    @Override
    public String getDescription() {
        return "Умеет пилотировать летательные аппараты.";
    }

    @Override
    public int getRequiredAge() {
        return 18;
    }
}
