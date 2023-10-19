package com.lucaslamounier.java12;

import org.junit.jupiter.api.Test;

import java.text.NumberFormat;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NumberFormatTest {

    @Test
    void numberFormat_ShouldFormatValues_AccordingToLocaleAndStyle() {
        NumberFormat numberFormatShortUS = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        numberFormatShortUS.setMaximumFractionDigits(2);
        assertThat(numberFormatShortUS.format(2592)).isEqualTo("2.59K");

        NumberFormat numberFormatLongUS = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        numberFormatLongUS.setMaximumFractionDigits(2);
        assertThat(numberFormatLongUS.format(2592)).isEqualTo("2.59 thousand");

        NumberFormat numberFormatShort = NumberFormat.getCompactNumberInstance(new Locale("pt", "BR"), NumberFormat.Style.SHORT);
        numberFormatShort.setMaximumFractionDigits(2);
        assertThat(numberFormatShort.format(2592)).isEqualTo("2,59 mil");

        NumberFormat numberFormatLong = NumberFormat.getCompactNumberInstance(new Locale("pt", "BR"), NumberFormat.Style.LONG);
        numberFormatLong.setMaximumFractionDigits(2);
        assertThat(numberFormatLong.format(2592)).isEqualTo("2,59 mil");
    }
}
