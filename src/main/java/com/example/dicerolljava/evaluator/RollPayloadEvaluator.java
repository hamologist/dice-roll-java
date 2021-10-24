package com.example.dicerolljava.evaluator;

import com.example.dicerolljava.resource.Die;
import com.example.dicerolljava.resource.Payload;
import com.example.dicerolljava.resource.Response;
import com.example.dicerolljava.resource.Roll;
import com.example.dicerolljava.resource.Step;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class RollPayloadEvaluator {
    private final Random random;

    @Autowired
    public RollPayloadEvaluator(Random random) {
        this.random = random;
    }

    public Response evaluate(Payload payload) {
        Step[] steps = new Step[payload.getCount()];
        Roll[] rolls = new Roll[payload.getDice().length];

        for (int stepCount = 0; stepCount < payload.getCount(); stepCount++) {
            int totalRollValue = 0;
            Die[] dice = payload.getDice();
            for (int diceIndex = 0; diceIndex < dice.length; diceIndex++) {
                Die die = dice[diceIndex];
                int diceCount = die.getCount();

                int rollsTotal = die.getModifier();
                int[] rollValues = new int[diceCount];
                Roll.Builder rollBuilder = Roll.newBuilder();
                for (int rollCount = 0; rollCount < diceCount; rollCount++) {
                    int currentRollValue = random.nextInt(die.getSides()) + 1;
                    rollsTotal += currentRollValue;
                    rollValues[rollCount] = currentRollValue;
                }
                rolls[diceIndex] = rollBuilder.setCount(diceCount)
                        .setSides(die.getSides())
                        .setModifier(die.getModifier())
                        .setRolls(rollValues)
                        .setTotal(rollsTotal)
                        .build();
                totalRollValue += rollsTotal;
            }
            steps[stepCount] = new Step(rolls, totalRollValue);
        }

        return new Response(steps);
    }
}
