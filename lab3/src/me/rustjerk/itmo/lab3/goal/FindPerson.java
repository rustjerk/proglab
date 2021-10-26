package me.rustjerk.itmo.lab3.goal;

import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.item.Items;
import me.rustjerk.itmo.lab3.person.Person;
import me.rustjerk.itmo.lab3.person.trait.Trait;
import me.rustjerk.itmo.lab3.person.trait.Traits;

import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FindPerson extends Goal {
    private final Person person;

    public FindPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String getDescription() {
        return String.format("Необходимо найти человека по имени %s. Надеемся он еще не отбросил копыта.",
                person.getName());
    }

    @Override
    public float getChanceOfSuccess() {
        return 0.5f;
    }

    @Override
    public Duration getRequiredTime() {
        return Duration.ofHours(1);
    }

    @Override
    public List<Item> getRequiredItems() {
        return Collections.singletonList(Items.AERIAL_CAMERA);
    }

    @Override
    public List<Trait> getRequiredTraits() {
        return Collections.singletonList(Traits.SHARP_EYED);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FindPerson that = (FindPerson) o;
        return Objects.equals(person, that.person);
    }

    @Override
    public int hashCode() {
        return person.hashCode();
    }
}
