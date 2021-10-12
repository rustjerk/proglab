package me.rustjerk.itmo.lab2.pokemons;

import me.rustjerk.itmo.lab2.moves.Confide;
import me.rustjerk.itmo.lab2.moves.DoubleTeam;
import me.rustjerk.itmo.lab2.moves.Rest;
import me.rustjerk.itmo.lab2.moves.Swagger;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Cosmoem extends Pokemon {
    public Cosmoem(String name, int level) {
        super(name, level);

        setType(Type.PSYCHIC);
        setStats(43, 29, 131, 29, 131, 37);
        setMove(new Rest(), new Confide());
    }
}
