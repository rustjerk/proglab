package me.rustjerk.itmo.lab3.item;

import me.rustjerk.itmo.lab3.report.HasDescription;
import me.rustjerk.itmo.lab3.report.HasName;

public abstract class Item implements HasName, HasDescription {
    public abstract float getWeight();

    @Override
    public String toString() {
        return String.format("%s [%.1f kg]", getName(), getWeight());
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
