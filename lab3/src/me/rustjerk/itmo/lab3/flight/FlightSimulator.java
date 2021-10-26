package me.rustjerk.itmo.lab3.flight;

import me.rustjerk.itmo.lab3.Simulator;
import me.rustjerk.itmo.lab3.goal.Goal;
import me.rustjerk.itmo.lab3.item.Item;
import me.rustjerk.itmo.lab3.person.trait.Trait;
import me.rustjerk.itmo.lab3.util.DurationUtils;

import java.time.Duration;
import java.util.Objects;

public class FlightSimulator implements Simulator {
    private FlightPlan plan;
    private Duration remainingTime;

    public FlightSimulator(FlightPlan plan) {
        this.plan = plan;
    }

    public FlightPlan getPlan() {
        return plan;
    }

    public void setPlan(FlightPlan plan) {
        this.plan = plan;
    }

    @Override
    public void reset() {
        remainingTime = plan.getDuration();
    }

    @Override
    public void simulate() {
        reset();
        System.out.println("Взлетели в небо.");

        for (Goal goal : plan.getGoals()) {
            simulateGoal(goal);
        }

        System.out.println("Сели на аэродром.");
    }

    private void simulateGoal(Goal goal) {
        System.out.println("Топлива осталось на " + DurationUtils.format(remainingTime) + " полета.");
        System.out.println("Займемся следующей целью: " + goal.getDescription());

        if (goal.getRequiredTime().compareTo(remainingTime) > 0) {
            System.out.println("Нам не хватает времени.");
            return;
        }

        for (Item item : goal.getRequiredItems()) {
            if (!plan.getCargo().contains(item)) {
                System.out.println("У нас нет необходимого предмета: " + item.getName());
                return;
            }
        }

        for (Trait trait : goal.getRequiredTraits()) {
            if (plan.getCrew().stream().noneMatch((person) -> person.hasActiveTrait(trait))) {
                System.out.println("У нас нет ни одного человека со следующей чертой: " + trait.getDescription());
                return;
            }
        }

        remainingTime = remainingTime.minus(goal.getRequiredTime());
        if (Math.random() < goal.getChanceOfSuccess()) {
            System.out.println("Цель достигнута.");
        } else {
            System.out.println("Не повезло. Цель провалена.");
        }
    }

    @Override
    public String toString() {
        return "Симулятор полетов";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightSimulator simulator = (FlightSimulator) o;
        return Objects.equals(plan, simulator.plan) && Objects.equals(remainingTime, simulator.remainingTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plan, remainingTime);
    }
}
