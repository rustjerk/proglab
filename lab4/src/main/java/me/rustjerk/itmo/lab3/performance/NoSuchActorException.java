package me.rustjerk.itmo.lab3.performance;

public class NoSuchActorException extends PerformanceException {
    public NoSuchActorException(Actor actor) {
        super("Нет такого актера: " + actor.getName());
    }
}
