package me.rustjerk.itmo.lab3.flight;

public class NoCrewException extends RuntimeException {
    public NoCrewException() {
        super("Нет экипажа!");
    }
}
