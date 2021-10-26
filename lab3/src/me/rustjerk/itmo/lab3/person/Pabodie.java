package me.rustjerk.itmo.lab3.person;

import me.rustjerk.itmo.lab3.person.trait.Traits;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

public class Pabodie extends Person {
    public Pabodie() {
        traits = Arrays.asList(Traits.SHARP_EYED, Traits.CURIOUS);
    }

    @Override
    public LocalDate getBirthday() {
        return LocalDate.of(1337, Month.FEBRUARY, 1);
    }

    @Override
    public String getName() {
        return "Пэбоди";
    }
}
