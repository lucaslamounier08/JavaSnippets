package com.lucaslamounier.java21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class Java21Test {

    record Point(int x, int y) {
    }

    public static int beforeRecordPattern(Object obj) {
        int sum = 0;
        if (obj instanceof Point p) {
            int x = p.x();
            int y = p.y();
            sum = x + y;
        }
        return sum;
    }

    public static int afterRecordPattern(Object obj) {
        if (obj instanceof Point(int x, int y)) {
            return x + y;
        }
        return 0;
    }

    enum Color {RED, GREEN, BLUE}

    record ColoredPoint(Point point, Color color) {}

    record RandomPoint(ColoredPoint cp) {}

    public static Color getRamdomPointColor(RandomPoint r) {
        if (r instanceof RandomPoint(ColoredPoint cp)) {
            return cp.color();
        }
        return null;
    }

    @Test
    void testRecordPatterns() {
        Assertions.assertThat(beforeRecordPattern(new Point(3, 4))).isEqualTo(7);
        Assertions.assertThat(afterRecordPattern(new Point(3, 4))).isEqualTo(7);

        Color ramdomPointColor = getRamdomPointColor(
                new RandomPoint(
                        new ColoredPoint(
                                new Point(3, 4), Color.RED
                        )
                ));
        Assertions.assertThat(ramdomPointColor).isEqualTo(Color.RED);
    }

    static String processInputNew(String input) {
        String output;
        switch (input) {
            case null -> output = "Oops, null";
            case String s when "Yes".equalsIgnoreCase(s) -> output = "It's Yes";
            case String s when "No".equalsIgnoreCase(s) -> output = "It's No";
            case String s -> output = "Try Again";
        }
        return output;
    }

    @Test
    void testPatternMatchingSwitch() {
        Assertions.assertThat(processInputNew(null)).isEqualTo("Oops, null");
        Assertions.assertThat(processInputNew("yes")).isEqualTo("It's Yes");
        Assertions.assertThat(processInputNew("no")).isEqualTo("It's No");
        Assertions.assertThat(processInputNew("other string")).isEqualTo("Try Again");
    }

    @Test
    void testVirtualThreads() {
        Instant start = Instant.now();
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            IntStream.rangeClosed(1, 10_000).forEach(i -> {
                executor.submit(() -> {
                    System.out.println(i);
                    try {
                        Thread.sleep(Duration.ofSeconds(1));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            });
        }

        System.out.println("Duration of 10000 Virtual Thread, with Thread.sleep of 1 second: " +
                Duration.between(start, Instant.now()).toMillis() + "ms");
    }

}
