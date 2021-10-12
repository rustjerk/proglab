package me.rustjerk.itmo.lab2.moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.Type;

public class FocusBlast extends SpecialMove {
    public FocusBlast() {
        super(Type.FIGHTING, 120, 70);
    }

    @Override
    protected String describe() {
        return "бьет и уменьшает спец.защиту противника";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random() <= 0.1)
            pokemon.setMod(Stat.SPECIAL_DEFENSE, -1);
    }
}
