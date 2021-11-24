package me.rustjerk.itmo.lab3.goal;

import java.time.Duration;

public class EnjoyScenery extends Goal {
    @Override
    public String getDescription() {
        return "Необходимо насладиться видами гор.";
    }

    @Override
    public float getChanceOfSuccess() {
        return 1f;
    }

    @Override
    public Duration getRequiredTime() {
        return Duration.ofMinutes(15);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 42; // because instances are always equal
    }
}
