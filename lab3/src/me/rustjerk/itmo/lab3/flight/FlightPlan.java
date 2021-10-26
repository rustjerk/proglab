package me.rustjerk.itmo.lab3.flight;

import me.rustjerk.itmo.lab3.goal.Goal;
import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.person.Person;
import me.rustjerk.itmo.lab3.person.trait.Trait;
import me.rustjerk.itmo.lab3.person.trait.Traits;
import me.rustjerk.itmo.lab3.report.HasDescription;
import me.rustjerk.itmo.lab3.util.DurationUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FlightPlan implements HasDescription {
    private FlightKind kind;
    private Duration duration;
    private List<Person> crew;
    private List<Item> cargo;
    private List<Goal> goals;

    private FlightPlan() {
    }

    public FlightKind getKind() {
        return kind;
    }

    public Duration getDuration() {
        return duration;
    }

    public List<Person> getCrew() {
        return Collections.unmodifiableList(crew);
    }

    public List<Item> getCargo() {
        return Collections.unmodifiableList(cargo);
    }

    public List<Goal> getGoals() {
        return Collections.unmodifiableList(goals);
    }

    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder("План полета:\n");

        sb.append(" - Тип: ").append(kind).append("\n");
        sb.append(" - Продолжительность: ").append(DurationUtils.format(duration)).append("\n");

        sb.append(" - Экипаж: \n");
        for (Person person : crew) {
            sb.append("    - ").append(person.getName()).append("\n");
        }

        if (!cargo.isEmpty())
            sb.append(" - Груз: \n");
        for (Item item : cargo) {
            sb.append("    - ").append(item.getName()).append("\n");
            sb.append("      ").append(item.getDescription()).append("\n");
        }

        if (!goals.isEmpty())
            sb.append(" - Цели: \n");
        for (Goal goal : goals) {
            sb.append("    - ").append(goal.getDescription()).append("\n");
            sb.append("      Шанс успеха: ").append(goal.getChanceOfSuccess() * 100).append("%\n");
            sb.append("      Необходимое время: ")
                    .append(DurationUtils.format(goal.getRequiredTime()))
                    .append("\n");
            sb.append("      Необходимые предметы: ");
            for (Item item : goal.getRequiredItems())
                sb.append(item.getName()).append("; ");
            sb.append("\n      Необходимые черты экипажа: \n");
            for (Trait trait : goal.getRequiredTraits())
                sb.append("       - ").append(trait.getDescription()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return getDescription();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightPlan that = (FlightPlan) o;
        return kind == that.kind
                && Objects.equals(duration, that.duration)
                && Objects.equals(crew, that.crew)
                && Objects.equals(cargo, that.cargo)
                && Objects.equals(goals, that.goals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kind, duration, crew, cargo, goals);
    }

    public static class Builder {
        private final FlightPlan plan;

        public Builder(FlightKind kind) {
            if (kind != FlightKind.SCOUTING)
                throw new RuntimeException("пока поддерживаются только развед. полеты");

            plan = new FlightPlan();
            plan.kind = kind;
            plan.duration = Duration.ZERO;
            plan.crew = new ArrayList<>();
            plan.cargo = new ArrayList<>();
            plan.goals = new ArrayList<>();
        }

        public Builder setDuration(Duration duration) {
            plan.duration = duration;
            return this;
        }

        public Builder addCrewMember(Person member) {
            plan.crew.add(member);
            return this;
        }

        public Builder addCrewMembers(Person... members) {
            for (Person member : members)
                addCrewMember(member);
            return this;
        }

        public Builder addCargoItem(Item item) {
            plan.cargo.add(item);
            return this;
        }

        public Builder addCargoItems(Item... items) {
            for (Item item : items)
                addCargoItem(item);
            return this;
        }

        public Builder addGoal(Goal goal) {
            plan.goals.add(goal);
            return this;
        }

        public FlightPlan build() {
            if (plan.crew.isEmpty())
                throw new IllegalStateException("Нет экипажа!");

            if (plan.crew.stream().noneMatch((p) -> p.hasActiveTrait(Traits.PILOT)))
                throw new IllegalStateException("Нет пилота!");

            return plan;
        }
    }
}
