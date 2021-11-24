package me.rustjerk.itmo.lab3.item;

public class AerialCamera extends Item {
    @Override
    public String getName() {
        return "Аэрокамера";
    }

    @Override
    public String getDescription() {
        return "Профессиональная цифровая аэрокамера с разрешением 48 мегапикселей.";
    }

    @Override
    public float getWeight() {
        return 2.31f;
    }
}
