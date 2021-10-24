package com.example.dicerolljava.controller;

import com.example.dicerolljava.evaluator.RollPayloadEvaluator;
import com.example.dicerolljava.resource.Payload;
import com.example.dicerolljava.resource.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class DiceRollController {
    private final RollPayloadEvaluator rollPayloadEvaluator;

    @Autowired
    public DiceRollController(RollPayloadEvaluator rollPayloadEvaluator) {
        this.rollPayloadEvaluator = rollPayloadEvaluator;
    }

    @PostMapping(path = "dice-roll",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> roll(@Valid @RequestBody Payload payload) {
        Response response = rollPayloadEvaluator.evaluate(payload);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(response);
    }
}
