package me.rustjerk.itmo.lab2;

import me.rustjerk.itmo.lab2.pokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class Lab2 {
    public static void main(String[] args) {
        Battle b = new Battle();

        b.addAlly(new Celebi("A", 1));
        b.addAlly(new Eevee("B", 2));
        b.addAlly(new Glaceon("C", 3));

        b.addFoe(new Cosmoem("X", 1));
        b.addFoe(new Solgaleo("Y", 2));
        b.addFoe(new Nihilego("Z", 3));

        b.go();
    }
}
