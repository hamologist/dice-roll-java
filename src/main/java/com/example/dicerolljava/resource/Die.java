package com.example.dicerolljava.resource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Die {
    @Min(value = 1)
    private int count = 1;

    @NotNull
    @Min(value = 1)
    private Integer sides;

    private int modifier = 0;

    public int getCount() {
        return count;
    }

    public int getSides() {
        if (sides == null) {
            return 0;
        }
        return sides;
    }

    public int getModifier() {
        return modifier;
    }
}
