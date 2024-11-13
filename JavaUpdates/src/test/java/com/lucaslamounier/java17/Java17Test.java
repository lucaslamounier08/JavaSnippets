package com.lucaslamounier.java17;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.random.RandomGeneratorFactory;
import java.util.stream.Collectors;

class Java17Test {

    @Test
    void testPseudoInts() {
        RandomGeneratorFactory.all()
                .sorted(Comparator.comparing(RandomGeneratorFactory::name))
                .map(RandomGeneratorFactory::name)
                .collect(Collectors.toSet())
                .forEach(algorithm -> {
                    RandomGeneratorFactory.of(algorithm)
                            .create()
                            .ints(10, 0, 100)
                            .forEach(value -> System.out.println(algorithm + " - " + value));
                });
    }

    @Test
    void switchPatternMatching() {
        Object o = "test";
        String result = switch (o) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            case null -> "Null object";
            default     -> o.toString();
        };

        Assertions.assertThat(result).isEqualTo("String test");
    }
}
