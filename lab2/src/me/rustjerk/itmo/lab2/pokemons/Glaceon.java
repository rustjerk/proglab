package me.rustjerk.itmo.lab2.pokemons;

import me.rustjerk.itmo.lab2.moves.Confide;
import me.rustjerk.itmo.lab2.moves.DoubleTeam;
import me.rustjerk.itmo.lab2.moves.Swagger;
import me.rustjerk.itmo.lab2.moves.ThunderWave;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Glaceon extends Eevee {
    public Glaceon(String name, int level) {
        super(name, level);

        setType(Type.ICE);
        setStats(65, 60, 110, 130, 95, 65);
        setMove(new Confide(), new DoubleTeam(), new Swagger(), new ThunderWave());
    }
}
