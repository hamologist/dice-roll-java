package com.example.dicerolljava.resource;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Payload {
    @NotEmpty
    @Valid
    private Die[] dice;

    @Min(value = 1)
    private Integer count = 1;

    public Die[] getDice() {
        return dice;
    }

    public int getCount() {
        return count;
    }
}
