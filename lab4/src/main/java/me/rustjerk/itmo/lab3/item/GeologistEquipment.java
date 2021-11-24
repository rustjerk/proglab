package me.rustjerk.itmo.lab3.item;

public class GeologistEquipment extends Item {
    @Override
    public String getName() {
        return "Геологические инструменты";
    }

    @Override
    public String getDescription() {
        return "Молотки, кувалды, зубила, лотки для промывки золота, комплектующие для бурового оборудования, в общем всё что нужно настоящему геологу.";
    }

    @Override
    public float getWeight() {
        return 42.3f;
    }
}
