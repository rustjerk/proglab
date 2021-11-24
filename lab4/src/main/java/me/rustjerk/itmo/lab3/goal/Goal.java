package me.rustjerk.itmo.lab3.goal;

import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.person.trait.Trait;
import me.rustjerk.itmo.lab3.report.HasDescription;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public abstract class Goal implements HasDescription {
    public abstract float getChanceOfSuccess();

    public abstract Duration getRequiredTime();

    public List<Item> getRequiredItems() {
        return Collections.emptyList();
    }

    public List<Trait> getRequiredTraits() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "Цель: " + getDescription();
    }
}
