package me.rustjerk.itmo.lab2.moves;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Stat;
import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Type;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected String describe() {
        return "сбивает с толку и увеличивает атаку противника";
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        pokemon.confuse();
        pokemon.setMod(Stat.ATTACK, 2);
    }
}
