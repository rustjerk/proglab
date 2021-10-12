package me.rustjerk.itmo.lab2.pokemons;

import me.rustjerk.itmo.lab2.moves.Confide;
import me.rustjerk.itmo.lab2.moves.Rest;
import me.rustjerk.itmo.lab2.moves.WorkUp;
import ru.ifmo.se.pokemon.Type;

public class Solgaleo extends Cosmoem {
    public Solgaleo(String name, int level) {
        super(name, level);

        setType(Type.PSYCHIC, Type.STEEL);
        setStats(137, 137, 107, 113, 89, 97);
        setMove(new Rest(), new Confide(), new WorkUp());
    }
}
