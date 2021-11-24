package me.rustjerk.itmo.lab3.performance;

import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.person.Person;

import java.util.List;

public abstract class Actor extends Person implements ActionTarget {
    public String performAction(Act.Stage stage, ActionKind kind, List<ActionTarget> targets)
            throws PerformanceException {
        for (ActionTarget target : targets) {
            if (target instanceof Actor && !stage.hasActor((Actor) target))
                throw new NoSuchActorException((Actor) target);
            if (target instanceof Item && !stage.hasItem((Item) target))
                throw new NoSuchItemException((Item) target);
        }

        StringBuilder sb = new StringBuilder();

        sb.append(getName()).append(" ").append(kind.getVerb());

        if (targets.size() > 0)
            sb.append(" ");

        for (int i = 0; i < targets.size(); i++) {
            ActionTarget target = targets.get(i);

            if (i > 0) {
                if (i == targets.size() - 1)
                    sb.append(" и ");
                else
                    sb.append(", ");
            }

            if (target instanceof Actor)
                sb.append("персона ").append(((Actor) target).getName());
            else if (target instanceof Item)
                sb.append("предмет ").append(((Item) target).getName());
            else
                sb.append("какой-то ").append(target.toString());
        }

        sb.append(".");
        return sb.toString();
    }
}
