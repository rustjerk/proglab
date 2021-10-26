package me.rustjerk.itmo.lab3;

import me.rustjerk.itmo.lab3.flight.FlightKind;
import me.rustjerk.itmo.lab3.flight.FlightPlan;
import me.rustjerk.itmo.lab3.flight.FlightSimulator;
import me.rustjerk.itmo.lab3.goal.EnjoyScenery;
import me.rustjerk.itmo.lab3.goal.FindPerson;
import me.rustjerk.itmo.lab3.item.Items;
import me.rustjerk.itmo.lab3.person.*;

import java.time.Duration;

public class Lab3 {
    public static void main(String[] args) {
        Person sherman = new Sherman();
        Person pabodie = new Pabodie();
        Person mcTighe = new McTighe();
        Person gedney = new Gedney();

        FlightPlan flightPlan = new FlightPlan.Builder(FlightKind.SCOUTING)
                .setDuration(Duration.ofHours(4))
                .addCrewMembers(sherman, pabodie, mcTighe)
                .addCargoItems(Items.AERIAL_CAMERA)
                .addGoal(new FindPerson(gedney))
                .addGoal(new EnjoyScenery())
                .build();

        System.out.println(flightPlan);

        FlightSimulator simulator = new FlightSimulator(flightPlan);
        simulator.simulate();
    }
}
