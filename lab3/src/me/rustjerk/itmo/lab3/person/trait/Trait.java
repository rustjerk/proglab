package me.rustjerk.itmo.lab3.person.trait;

import me.rustjerk.itmo.lab3.report.HasDescription;

public abstract class Trait implements HasDescription {
    public int getRequiredAge() {
        return 0;
    }

    @Override
    public String toString() {
        return "Черта: " + getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 42; // instances are always equal
    }
}
