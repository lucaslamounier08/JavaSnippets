package com.lucaslamounier.certification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Lesson2HandlingTextTest {

    @Test
    void stringAndStringBuilder() {
        String octalEscapes = "\377";
        Assertions.assertEquals("ÿ", octalEscapes);

        String backslashEscapes = "\b \t \n \f \r \" ' \\";

        String unicodeEscapes = "\u7237";
        Assertions.assertEquals("爷", unicodeEscapes);

        // strings are immutable, mutations should create a new string
        String s = "string";
        s.toUpperCase(); // does nothing
        Assertions.assertEquals("string", s);
        s = s.toUpperCase();
        Assertions.assertEquals("STRING", s);

        // string overrides equals() and hashCode(), StringBuilder don't
    }

    @Test
    void methodsOfTheStringClass() {
        // strings are immutable, identical text can be shared in the String Pool
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "He";
        String s4 = s3 + "llo";
        Assertions.assertTrue(s1 == s2);
        Assertions.assertFalse(s1 == s4);
        s4 = s4.intern();
        Assertions.assertTrue(s1 == s4);
    }

    
}
