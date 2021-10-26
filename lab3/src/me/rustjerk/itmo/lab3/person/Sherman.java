package me.rustjerk.itmo.lab3.person;

import me.rustjerk.itmo.lab3.person.trait.Traits;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;

public class Sherman extends Person {
    public Sherman() {
        traits = Collections.singletonList(Traits.CURIOUS);
    }

    @Override
    public String getName() {
        return "Шерман";
    }

    @Override
    public LocalDate getBirthday() {
        return LocalDate.of(1889, Month.APRIL, 20);
    }
}
