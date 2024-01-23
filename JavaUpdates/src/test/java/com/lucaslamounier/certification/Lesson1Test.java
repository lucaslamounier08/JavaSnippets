package com.lucaslamounier.certification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

        Assertions.assertTrue(Double.isNaN(Double.parseDouble("NaN")));
        Assertions.assertFalse(Double.isFinite(Double.parseDouble("NaN")));
        Assertions.assertFalse(Double.isInfinite(Double.parseDouble("NaN")));
    }
}
