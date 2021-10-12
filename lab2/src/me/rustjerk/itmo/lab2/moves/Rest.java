package me.rustjerk.itmo.lab2.moves;


import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove {
    public Rest() {
        super(Type.PSYCHIC, 0, 0);
    }

    @Override
    protected String describe() {
        return "тупо адыхает";
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        pokemon.restore();
        pokemon.addEffect(new Effect().condition(Status.SLEEP).turns(2));
    }
}
