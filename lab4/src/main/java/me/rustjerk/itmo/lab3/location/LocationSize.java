package me.rustjerk.itmo.lab3.location;

public enum LocationSize {
    SMALL("маленький"),
    MEDIUM("средний"),
    HUGE("огромный"),
    INFINITE("бесконечный");

    private final String name;

    LocationSize(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
