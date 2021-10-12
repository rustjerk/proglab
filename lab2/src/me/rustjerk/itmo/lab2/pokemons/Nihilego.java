package me.rustjerk.itmo.lab2.pokemons;

import me.rustjerk.itmo.lab2.moves.Confide;
import me.rustjerk.itmo.lab2.moves.Rest;
import me.rustjerk.itmo.lab2.moves.WorkUp;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Nihilego extends Pokemon {
    public Nihilego(String name, int level) {
        super(name, level);

        setType(Type.ROCK, Type.POISON);
        setStats(109, 53, 47, 127, 131, 103);
        setMove(new Rest(), new Confide(), new WorkUp(), new Rest());
    }
}
