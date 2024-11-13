package com.lucaslamounier.java21;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
                                new Point(3,4), Color.RED
                        )
                ));
        Assertions.assertThat(ramdomPointColor).isEqualTo(Color.RED);
    }


}
