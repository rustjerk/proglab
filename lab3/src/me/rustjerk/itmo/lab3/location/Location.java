package me.rustjerk.itmo.lab3.location;

import me.rustjerk.itmo.lab3.report.HasDescription;
import me.rustjerk.itmo.lab3.report.HasName;

public abstract class Location implements HasName, HasDescription {
    public abstract LocationSize getSize();

    @Override
    public String toString() {
        return "Локация: " + getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 42;
    }
}
