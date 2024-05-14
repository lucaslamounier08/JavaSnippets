package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
class Lesson13WorkingWithPolymorphism {

    @Test
    void lesson13WorkingWithPolymorphism() {
        // 13.1 - object and reference type
        CharSequence cs = "";
        CharSequence[] csa = {cs};
        String s1 = (String) cs + 3;
        System.out.println(s1);
        String s2 = (String) csa[0] + 3;
        System.out.println(s2);
        int l1 = ((String)cs).length(); // fails without parens
        System.out.println(l1);

        // 13.2 - pattern matching in instanceof
        // instanceof can declare variables
        Object thing = "Hello";
        if (thing instanceof String thingString && thingString.length() > 1) {
            System.out.println(thingString);
            Assertions.assertInstanceOf(String.class, thingString);
        }

        // 13.3 - additional topics in pattern-matched instanceof

        // 13.4 - possible and impossible casts

        // 13.5 - virtual method invocation

        // 13.6 - covariant returns

    }

    interface A {
        default void doA() {
            System.out.println("A.doA");
        }
    }
    class Super {
        public void doA() {
            System.out.println("Super.doA");
        }
    }
    class Sub extends Super implements A {
        public void doA() {
            System.out.println("Sub.doA");
        }
    }

    @Test
    void test() {
        A a = (A) new Sub();
        a.doA();
    }

}
