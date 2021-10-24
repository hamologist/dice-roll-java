package com.example.dicerolljava.config;

import com.example.dicerolljava.evaluator.RollPayloadEvaluator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class AppConfig {
    @Bean
    public Random random() {
        return new Random();
    }

    @Bean
    public RollPayloadEvaluator rollPayloadEvaluator(Random random) {
        return new RollPayloadEvaluator(random);
    }
}
