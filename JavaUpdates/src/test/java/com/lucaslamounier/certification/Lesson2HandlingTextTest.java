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

    
}
