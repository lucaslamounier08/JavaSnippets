package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Lesson4FundamentalsOfFlowControlTest {

    @Test
    void lesson4FundamentalsOfFlowControlTest() {
        for (int x = 0, y = 2, z[] = {1, 2, 3};
             x < 3;
             x++, y--, System.out.println()) {
            log.info("x: {}, y: {}, z[y]: {}", x, y, z[y]);
        }

        for (int i = 0; i < 1; i++) {
            if (i == 0) break; // BREAK exits loop
            if (i == 1) continue; // CONTINUE exit only current index of loop

            continue;
            //i++; // compilation fails because is never reached
        }

        // break and continue are related to immediately enclosing loop
        // only exception is when used with labels:
        outerLoop:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                log.info("i: {}, j: {}", i, j);
                if (j >= 5) continue outerLoop;
            }
        }

        // new switch statement - doesn't need to use BREAK keyword
        int x = 99;
        switch (x) {
            case 97, 98, 99 -> System.out.println(x);
            case 100 -> System.out.println(x);
            default -> System.out.println(x);
        }

        // 4.6 - expressions with switch
        // switch can be a expression -> returns values -> NEED DEFAULT VALUE:
        x = 0;
        var res = switch (x) {
            case 0 -> "Zero";
            case 1 -> "One";
            default -> "Invalid input";
        };
        assertEquals("Zero", res);

        // but doesnt need default value if ENUM:
        // also, YIELD instead of RETURN in SWITCHS
        enum Suit {
            SPADE, HEART, DIAMOND, CLUB;
        }
        Suit s = Suit.CLUB;
        var res2 = switch (s) {
            case CLUB -> {
                System.out.println("calculating");
                yield "Clubs";
            }
            case SPADE -> {
                System.out.println("calculating");
                yield "Spades";
            }
            case HEART -> {
                System.out.println("calculating");
                yield "Hearts";
            }
            case DIAMOND -> {
                System.out.println("calculating");
                yield "Diamonds";
            }
        };
        assertEquals("Clubs", res2);

        // question deep dive
        int xxx = 0;
        var var = switch (xxx) {
            case 0:
                System.out.println("Zero");
            case -1, -2, -3:
                yield "Small negative";
            case 1, 2, 3:
                yield "Small positive";
            default:
                throw new RuntimeException();
        };
        assertEquals("Small negative", var);
    }

    @Test
    void examQuestionDeepDive() {
        // question deep dive - exam question
        String result = "";
        int x = 0;
        outer:
        while (x < 5) {
            result = result.concat(String.valueOf(x));
            inner:
            switch (x) {
                case 0:
                    x = 1;
                    break inner;
                case 1:
                    x = 3;
                case 2:
                    x = 4;
                    break;
                case 3:
                    continue outer;
                case 4:
                    x = 5;
                    break outer;
            }
            result = result.concat("X");
        }
        assertEquals("0X1X4", result);
    }

}
