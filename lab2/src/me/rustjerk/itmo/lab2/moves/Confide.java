package me.rustjerk.itmo.lab2.moves;

import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove {
    public Confide() {
        super(Type.NORMAL, 0, 0);
    }

    @Override
    protected String describe() {
        return "уменьшает спец.атаку противника";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.setMod(Stat.SPECIAL_ATTACK, -1);
    }
}
