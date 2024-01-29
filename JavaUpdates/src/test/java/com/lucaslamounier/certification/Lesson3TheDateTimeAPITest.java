package com.lucaslamounier.certification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lesson3TheDateTimeAPITest {

    @Test
    void dateTimeAPI() {
        // absolute moment in history:
        Instant instant = Instant.now();
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        // points of human reference, not "absolute":
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();
        // elapsed time:
        Duration duration = Duration.ofDays(3);
        Period period = Period.ofYears(3);

        Assertions.assertEquals("PT5H40M", Duration.ofMinutes(340).toString());

        Assertions.assertEquals("P1Y14M540D", Period.of(1, 14, 540).toString());
        Assertions.assertEquals("P2Y2M540D", Period.of(1, 14, 540).normalized().toString());

        /** part 2:
         * date-time APIs are:
         * immutable
         *      except exceptions
         *      just like Strings, operations create a new object
         * it creates objects using factories, not constructors
          */
        LocalDate ld1 = LocalDate.of(2024, 4, 30);
        Assertions.assertEquals("2024-04-30", ld1.toString());

        ld1.plusDays(10);
        Assertions.assertEquals("2024-04-30", ld1.toString());

        ld1 = ld1.plusDays(10);
        Assertions.assertEquals("2024-05-10", ld1.toString());

        // we cannot access time extracted from a LocalDate (must use LocalDateTime)
        LocalDate localDate1 = LocalDate.now();
        assertDoesNotThrow(() -> localDate1.get(ChronoField.YEAR));
        assertThrows(Exception.class, () -> localDate1.get(ChronoField.HOUR_OF_DAY));
        assertTrue(localDate1.isSupported(ChronoField.YEAR));
        assertFalse(localDate1.isSupported(ChronoField.HOUR_OF_DAY));

        // LocalDate can be transformed to LocalDateTime
        var localDateTime1 = localDate1.atTime(13, 13);
        assertTrue(localDateTime1 instanceof LocalDateTime);

        LocalDate may4 = LocalDate.of(2024, 5, 4);
        Period thirtyDays = Period.ofDays(30);
        assertEquals(6, may4.plus(thirtyDays).getMonthValue());

    }

}
