package me.rustjerk.itmo.lab3.performance;

import me.rustjerk.itmo.lab3.item.Items;
import me.rustjerk.itmo.lab3.person.Karlsson;
import me.rustjerk.itmo.lab3.person.Lillebror;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KarlssonOnTheRoofAct1 extends Act {
    private final Actor karlsson = new Karlsson();
    private final Actor lillebror = new Lillebror();
    private final List<String> script;

    public KarlssonOnTheRoofAct1() {
        stage.addItem(Items.VACUUM_CLEANER);
        stage.addActor(karlsson);
        stage.addActor(lillebror);

        script = new ArrayList<>();

        class ActionAdder {
            final Actor actor;

            ActionAdder(Actor actor) {
                this.actor = actor;
            }

            void add(ActionKind action, ActionTarget... targets) throws PerformanceException {
                script.add(actor.performAction(stage, action, Arrays.asList(targets)));
            }
        }

        ActionAdder karlssonActions = new ActionAdder(karlsson);

        try {
            karlssonActions.add(ActionKind.LAUGH);
            karlssonActions.add(ActionKind.POKE, lillebror);
            script.add("(Увы, Малышу не подарили новой машины)");
            karlssonActions.add(ActionKind.SULK);
            karlssonActions.add(ActionKind.LOOK, Items.VACUUM_CLEANER);
            script.add("(Мама забыла унести пылесос из комнаты)");
            karlssonActions.add(ActionKind.SHOUT);
            karlssonActions.add(ActionKind.CLING, Items.VACUUM_CLEANER);
        } catch (PerformanceException e) {
            StringWriter writer = new StringWriter();
            e.printStackTrace(new PrintWriter(writer));
            script.add("Сценарист напортачил: " + writer.toString());
        }
    }

    @Override
    public List<String> getScript() {
        return Collections.unmodifiableList(script);
    }
}
