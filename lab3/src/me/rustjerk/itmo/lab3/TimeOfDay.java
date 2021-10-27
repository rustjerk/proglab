package me.rustjerk.itmo.lab3;

public enum TimeOfDay {
    MIDNIGHT("полночь"),
    MORNING("утро"),
    MIDDAY("полдень"),
    EVENING("вечер");

    private final String name;

    TimeOfDay(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
