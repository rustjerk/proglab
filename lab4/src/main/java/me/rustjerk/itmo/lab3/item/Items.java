package me.rustjerk.itmo.lab3.item;

import me.rustjerk.itmo.lab3.performance.KarlssonOnTheRoofAct1;

import java.util.Collections;

public final class Items {
    public static final Item AERIAL_CAMERA = new AerialCamera();
    public static final Item GEOLOGIST_EQUIPMENT = new GeologistEquipment();
    public static final Item RADIO = new Radio();
    public static final Item VACUUM_CLEANER = new VacuumCleaner();

    public static final Book KARLSSON_ON_THE_ROOF = new Book(Collections.singletonList(new KarlssonOnTheRoofAct1()));
}
