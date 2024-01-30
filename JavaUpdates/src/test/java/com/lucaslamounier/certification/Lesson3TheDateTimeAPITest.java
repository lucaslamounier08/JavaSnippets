package com.lucaslamounier.certification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lesson3TheDateTimeAPITest {

    @Test
    void dateTimeAPI() throws InterruptedException {
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

        // time-zone considerations
        ZoneId.of("Brazil/East").getRules().getTransitions().forEach(System.out::println);

        // be careful comparing ZonedDateTime
        Instant instant1 = Instant.now();
        ZonedDateTime zdt1 = ZonedDateTime.ofInstant(instant1, ZoneId.of("Brazil/East"));
        ZonedDateTime zdt2 = ZonedDateTime.ofInstant(instant1, ZoneId.of("Brazil/Acre"));

        System.out.println(zdt1);
        System.out.println(zdt2);
        assertNotEquals(zdt1, zdt2);
        assertNotEquals(zdt1.toLocalDateTime(), zdt2.toLocalDateTime());
        assertEquals(zdt1.toInstant(), zdt2.toInstant());

        // instant operations
        Instant januaryFirst = LocalDateTime.of(2024, 1, 1, 1, 1, 1).toInstant(ZoneOffset.ofHours(-3));
        Instant januarySecond = LocalDateTime.of(2024, 1, 2, 1, 1, 1).toInstant(ZoneOffset.ofHours(-3));
        assertEquals(1, januaryFirst.until(januarySecond, ChronoUnit.DAYS));
        assertEquals(24, januaryFirst.until(januarySecond, ChronoUnit.HOURS));

        // question deep dive:
        var ins1 = Instant.now();
        Thread.sleep(100);
        var ins2 = Instant.now();
        assertEquals(0, ins1.truncatedTo(ChronoUnit.MINUTES)
                .compareTo(ins2.truncatedTo(ChronoUnit.MINUTES)));
    }

}
