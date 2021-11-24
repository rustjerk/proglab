package me.rustjerk.itmo.lab3.person;

import me.rustjerk.itmo.lab3.performance.Actor;

import java.time.LocalDate;
import java.time.Month;

public class Karlsson extends Actor {
    @Override
    public LocalDate getBirthday() {
        return LocalDate.of(2007, Month.SEPTEMBER, 30);
    }

    @Override
    public String getName() {
        return "Карлсон";
    }
}
