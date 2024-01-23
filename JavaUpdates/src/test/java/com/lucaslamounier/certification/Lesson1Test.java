package com.lucaslamounier.certification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Lesson1Test {

    @Test
    void wrapperTests() {
        Void voidIsWrapperForVoid;

        List<Integer> validList;
        //List<int> invalidList;

        // autoboxing and auto-unboxing
        Integer intg = 99;
        int i = intg;
        long l = intg;
        Object obj = i;

        //Long bad = 99;
        Long good = 99L;

        // wrapper method compare
        int x = 1;
        int y = 2;
        Assertions.assertEquals(-1, Integer.compare(x, y));
        Integer integer = 3;
        Assertions.assertEquals(1, integer.compareTo(y));
        Assertions.assertEquals(3.0f, integer.floatValue());

        Integer intzero = Integer.valueOf(0);
        //System.out.println(intzero.booleanValue()); //booleanValue does not exists
        Boolean booleano = Boolean.FALSE;
        booleano.booleanValue(); // exists

        Assertions.assertTrue(Double.isNaN(Double.parseDouble("NaN")));
        Assertions.assertFalse(Double.isFinite(Double.parseDouble("NaN")));
        Assertions.assertFalse(Double.isInfinite(Double.parseDouble("NaN")));
    }

    @Test
    void primitivesReferencesAndAliasing() {
        // primitives: boolean, byte, short, char, int, long, float, double;
        // reference: String, LocalDate, ArrayList

        int x = 99;
        int y = 99;
        Assertions.assertTrue(x == y);

        LocalDateTime localDateTime1 = LocalDateTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.now().withYear(2025);
        Assertions.assertFalse(localDateTime1 == localDateTime2);

        // aliasing
        Assertions.assertEquals(99, x);
        Assertions.assertEquals(99, y);
        y = 100;
        Assertions.assertEquals(99, x);
        Assertions.assertEquals(100, y);

        String s1 = "s1";
        String s2 = s1;
        s2.concat("ignored"); // changes nothing
        Assertions.assertEquals("s1", s1);
        Assertions.assertEquals("s1", s2);
        s1 = "changed";
        Assertions.assertEquals("changed", s1);
        Assertions.assertEquals("s1", s2);

        StringBuilder sb1 = new StringBuilder("Hello");
        StringBuilder sb2 = sb1;
        Assertions.assertNotEquals("Hello", sb1);
        Assertions.assertNotEquals("Hello", sb2);

        // trick question
        var l1 = new ArrayList<>();
        l1.add("1");
        var l2 = new ArrayList<>(l1);
        l1.add("2");
        Assertions.assertEquals("1", l1.get(0));
        Assertions.assertEquals("2", l1.get(1));
        Assertions.assertEquals("1", l2.get(0));
        l2 = l1;
        l1.add("3");
        Assertions.assertEquals("1", l2.get(0));
        Assertions.assertEquals("2", l2.get(1));
        Assertions.assertEquals("3", l2.get(2));
    }

    @Test
    void questionDeepDive() {
        int i = 0;
        int [] ia = new int[]{0, 1, 2, 3};
        ia[++i] = ia[++i] + ia[i];
        String stringArray = Arrays.toString(ia);
        Assertions.assertEquals("[0, 4, 2, 3]", stringArray);
    }
}
