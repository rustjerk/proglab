package me.rustjerk.itmo.lab2.moves;

import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class Submission extends PhysicalMove {
    public Submission() {
        super(Type.NORMAL, 80, 80);
    }

    @Override
    protected String describe() {
        return "сильно бьет но теряет хп";
    }

    @Override
    protected void applySelfDamage(Pokemon pokemon, double damage) {
        pokemon.setMod(Stat.HP, (int) Math.round(damage / 4.0));
    }
}
