package me.rustjerk.itmo.lab3.person;

import me.rustjerk.itmo.lab3.person.trait.Traits;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

public class McTighe extends Person {
    public McTighe() {
        traits = Collections.singletonList(Traits.PILOT);
    }

    @Override
    public LocalDate getBirthday() {
        return LocalDate.of(1965, Month.FEBRUARY, 1);
    }

    @Override
    public String getName() {
        return "Мактай";
    }
}
