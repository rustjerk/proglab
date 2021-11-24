package me.rustjerk.itmo.lab3.performance;

import me.rustjerk.itmo.lab3.item.Item;

public class NoSuchItemException extends PerformanceException {
    public NoSuchItemException(Item item) {
        super("Нет такого предмета: " + item.getName());
    }
}
