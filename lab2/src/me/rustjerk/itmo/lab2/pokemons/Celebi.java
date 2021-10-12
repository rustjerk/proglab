package me.rustjerk.itmo.lab2.pokemons;

import me.rustjerk.itmo.lab2.moves.BubbleBeam;
import me.rustjerk.itmo.lab2.moves.FocusBlast;
import me.rustjerk.itmo.lab2.moves.Rest;
import me.rustjerk.itmo.lab2.moves.Submission;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Celebi extends Pokemon {
    public Celebi(String name, int level) {
        super(name, level);

        setType(Type.PSYCHIC, Type.GRASS);
        setStats(100, 100, 100, 100, 100, 100);
        setMove(new Rest(), new FocusBlast(), new BubbleBeam(), new Submission());
    }
}
