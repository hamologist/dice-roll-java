package com.example.dicerolljava.resource;

public class Roll {
    private final int count;
    private final int sides;
    private final int modifier;
    private final int[] rolls;
    private final int total;

    public Roll(int count, int sides, int modifier, int[] rolls, int total) {
        this.count = count;
        this.sides = sides;
        this.modifier = modifier;
        this.rolls = rolls;
        this.total = total;
    }

    public int getCount() {
        return count;
    }

    public int getSides() {
        return sides;
    }

    public int getModifier() {
        return modifier;
    }

    public int[] getRolls() {
        return rolls;
    }

    public int getTotal() {
        return total;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private int count;
        private int sides;
        private int modifier;
        private int[] rolls;
        private int total;

        public Roll build() {
            return new Roll(count, sides, modifier, rolls, total);
        }

        public Builder setCount(int count) {
            this.count = count;
            return this;
        }

        public Builder setSides(int sides) {
            this.sides = sides;
            return this;
        }

        public Builder setModifier(int modifier) {
            this.modifier = modifier;
            return this;
        }

        public Builder setRolls(int[] rolls) {
            this.rolls = rolls;
            return this;
        }

        public Builder setTotal(int total) {
            this.total = total;
            return this;
        }
    }
}
