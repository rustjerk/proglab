package me.rustjerk.itmo.lab3.goal;

import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.item.Items;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

public class SendReport extends Goal {
    @Override
    public float getChanceOfSuccess() {
        return 0.95f;
    }

    @Override
    public List<Item> getRequiredItems() {
        return Collections.singletonList(Items.RADIO);
    }

    @Override
    public Duration getRequiredTime() {
        return Duration.ofMinutes(15);
    }

    @Override
    public String getDescription() {
        return "Необходио сообщить о результатах полета по радио.";
    }
}
