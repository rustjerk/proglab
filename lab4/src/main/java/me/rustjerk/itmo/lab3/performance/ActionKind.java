package me.rustjerk.itmo.lab3.performance;

public enum ActionKind {
    LAUGH("расхохотался"),
    POKE("ткнул"),
    SULK("надулся"),
    LOOK("посмотрел"),
    SHOUT("вскрикнул"),
    CLING("вцепился");

    private final String verb;

    ActionKind(String verb) {
        this.verb = verb;
    }

    public String getVerb() {
        return this.verb;
    }
}
