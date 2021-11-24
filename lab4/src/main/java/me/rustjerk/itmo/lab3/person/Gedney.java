package me.rustjerk.itmo.lab3.person;

import me.rustjerk.itmo.lab3.person.trait.Traits;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

public class Gedney extends Person {
    public Gedney() {
        traits = Collections.singletonList(Traits.INSANE);
    }

    @Override
    public String getName() {
        return "Гедни";
    }

    @Override
    public LocalDate getBirthday() {
        return LocalDate.of(1878, Month.DECEMBER, 18);
    }
}
