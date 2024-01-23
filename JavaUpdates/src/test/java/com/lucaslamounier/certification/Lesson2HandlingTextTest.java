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

    @Test
    void textBlocks() {
        String stringTextBlock = """
                Hello""";
        Assertions.assertEquals("Hello", stringTextBlock);
        String stringTextBlockWithLineBreakEnd = """
                Hello
                """;
        Assertions.assertEquals("Hello\n", stringTextBlockWithLineBreakEnd);

        String blockWithSlashDoesNotBreakLine = """
                TextBlock \
                continues""";
        Assertions.assertEquals("TextBlock continues", blockWithSlashDoesNotBreakLine);

        String s1 = """
                "\"""";
        Assertions.assertEquals("\"\"", s1);
    }

    @Test
    void methodsOfTheStringBuilder() {
        // StringBuilder with int as argument for capacity
        StringBuilder sb = new StringBuilder(1);

        Assertions.assertEquals("abacate", sb.append("abacate").toString());
        Assertions.assertEquals("aacate", sb.delete(1, 2).toString());
        Assertions.assertEquals("acate", sb.deleteCharAt(0).toString());
        Assertions.assertEquals("abacate", sb.insert(1, "ba").toString());
        Assertions.assertEquals("cacacate", sb.replace(0, 2, "cac").toString());
        Assertions.assertEquals("etacacac", sb.reverse().toString());
    }

    @Test
    void questionDeepDive() {
        int i = 0;
        String s = "Values: ";
        loop: while (i < 5) {
            if (i++ % 2 == 0) continue loop;
            s.concat(", ").concat(Integer.toString(i));
        }

        Assertions.assertEquals("Values: ", s);
    }
}
