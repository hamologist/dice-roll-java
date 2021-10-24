package com.example.dicerolljava.resource;

public class Step {
    private final Roll[] rolls;
    private final int total;

    public Step(Roll[] rolls, int total) {
        this.rolls = rolls;
        this.total = total;
    }

    public Roll[] getRolls() {
        return rolls;
    }

    public int getTotal() {
        return total;
    }
}
