package me.rustjerk.itmo.lab3.person;

import me.rustjerk.itmo.lab3.person.trait.Trait;
import me.rustjerk.itmo.lab3.person.trait.Traits;
import me.rustjerk.itmo.lab3.report.HasName;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public abstract class Person implements HasName {
    protected List<Trait> traits;

    public abstract LocalDate getBirthday();

    public final int getAge() {
        return getBirthday().until(LocalDate.now()).getYears();
    }

    public final List<Trait> getTraits() {
        return Collections.unmodifiableList(traits);
    }

    public final boolean hasTrait(Trait trait) {
        return traits.contains(trait);
    }

    public final boolean hasActiveTrait(Trait trait) {
        return hasTrait(trait) && trait.getRequiredAge() <= getAge();
    }

    public final boolean isPilot() {
        return hasActiveTrait(Traits.PILOT);
    }

    @Override
    public String toString() {
        return "Персона <" + getName() + ">";
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Person && getName().equals(((Person) object).getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
