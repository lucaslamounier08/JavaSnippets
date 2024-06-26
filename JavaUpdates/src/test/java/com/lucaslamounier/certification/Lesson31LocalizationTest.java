package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Lesson31LocalizationTest {

    @Test
    void lesson31LocalizationTest() {
        // 002. 31.1 Parsing, formatting, and locale
        LocalDate ld = LocalDate.of(1996, 4, 30);
        DateTimeFormatter dtf1 = DateTimeFormatter.ISO_LOCAL_DATE;

        assertEquals("1996-04-30", dtf1.format(ld));

        assertEquals("30 abril 1996",
                DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.of("pt", "BR"))
                        .format(ld));

        assertEquals("30 April 1996",
                DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.CANADA)
                        .format(ld));

        assertEquals("30 四月 1996",
                DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.CHINESE)
                        .format(ld));

        //003. 31.2 ResourceBundle and data lookup
        
    }
}
