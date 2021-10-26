package me.rustjerk.itmo.lab3.flight;

public enum FlightKind {
    TRANSPORTATION("Транспортный полет"),
    FIGHTING("Боевой полет"),
    BOMBING("Бомбардировка"),
    SCOUTING("Разведка и поиск");

    private final String name;

    FlightKind(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
