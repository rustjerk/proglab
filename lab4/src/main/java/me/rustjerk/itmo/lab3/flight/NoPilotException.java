package me.rustjerk.itmo.lab3.flight;

public class NoPilotException extends RuntimeException {
    public NoPilotException() {
        super("Нет пилота!");
    }
}
