package com.lucaslamounier.java12;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.assertj.core.api.Assertions.assertThat;

class SwitchExpressionsTest {

    @Test
    void givenOldAndNewSwitchImplementations_BothMustReturnEqual() {
        DayOfWeek dayOfWeek = DayOfWeek.FRIDAY;
        assertThat(oldSwitchGetTypeOfDay(dayOfWeek)).isEqualTo(newSwitchGetTypeOfDay(dayOfWeek));

        dayOfWeek = DayOfWeek.SATURDAY;
        assertThat(oldSwitchGetTypeOfDay(dayOfWeek)).isEqualTo(newSwitchGetTypeOfDay(dayOfWeek));
    }

    private String oldSwitchGetTypeOfDay(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return "Working Day";
            case SATURDAY:
            case SUNDAY:
            default:
                return  "Day Off";
        }
    }

    private String newSwitchGetTypeOfDay(DayOfWeek dayOfWeek) {
        return switch (dayOfWeek) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> "Working Day";
            case SATURDAY, SUNDAY -> "Day Off";
        };
    }
}
