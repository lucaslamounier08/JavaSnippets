package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class Lesson15EnumerationsTest {

    @Test
    void lesson15EnumerationsTest() {
        // 15.1 - enums are implicitly final - cannot have subclasses
        // constructors in Enum are always PRIVATE

        // 15.2 - enum fields and methods

        // question deep dive: A, B, D, E
    }

    enum DayOfWeek {
        SUNDAY, MONDAY("Monday");

        DayOfWeek() {
        }

        DayOfWeek(String s) {
        }
    }


}
