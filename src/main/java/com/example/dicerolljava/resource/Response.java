package com.example.dicerolljava.resource;

public class Response {
    private final Step[] steps;

    public Response(Step[] steps) {
        this.steps = steps;
    }

    public Step[] getSteps() {
        return steps;
    }
}

