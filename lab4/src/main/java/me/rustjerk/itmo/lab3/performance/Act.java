package me.rustjerk.itmo.lab3.performance;

import me.rustjerk.itmo.lab3.item.Item;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Act {
    protected final Stage stage = new Stage();

    public abstract List<String> getScript();

    public Stage getStage() {
        return stage;
    }

    public class Stage {
        private final Set<Actor> actors = new HashSet<>();
        private final Set<Item> items = new HashSet<>();

        public boolean hasActor(Actor actor) {
            return actors.contains(actor);
        }

        public boolean hasItem(Item item) {
            return items.contains(item);
        }

        protected void addActor(Actor actor) {
            actors.add(actor);
        }

        protected void addItem(Item item) {
            items.add(item);
        }

        public Act getAct() {
            return Act.this;
        }
    }
}
