package me.rustjerk.itmo.lab2.moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class BubbleBeam extends SpecialMove {
    public BubbleBeam() {
        super(Type.WATER, 65, 100);
    }

    @Override
    protected String describe() {
        return "бьет и замедляет";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.1)
            pokemon.setMod(Stat.SPEED, -1);
    }
}