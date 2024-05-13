package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.Serializable;

@Slf4j
class Lesson12ImplementationInheritance {

    @Test
    void lesson12ImplementationInheritance() {
        // 12.1 - subclass -> class EXTENDS parentClass
        // only 1 class in extends
        // if without <extends>, then extends Object
        // can prevent extends with FINAL keyword

        // 12.2 - subclass initialization
        // if not explicit, "super()" will be generated by compiler
    }

    class Y {
        {
            System.out.println("Init Y");
        }
    }

    class X extends Y {
        {
            System.out.println("Init X");
        }

        public X() {
            System.out.println("X()");
        }

        public X(int x) {
            this();
            System.out.println("X(" + x + ");");
        }
    }

    @Test
    void testX() {
        new X(1);
        //Init Y
        //Init X
        //X()
        //X(1);
    }

    @Test
    void lesson12ImplementationInheritance_continuation() {
        // 12.3 - abstract class constraints
        // cannot be instanciated, must be extended, blablabla
        // abstract method does not have a body, and MUST be PUBLIC or protected or default

        // 12.4 - sealed type hierarchies
        // sealed interface > only certain classes can implement from that interface - and all MUST be declared
        // sealed class > only certain classes can extends from that class
        // remember that sealed classes also can be NON-SEALED, SEALED and FINAL
    }

    sealed interface Example permits ExampleImpl {
    }

    final class ExampleImpl implements Example, Example2 {
    }

//    sealed interface Vehicle permits Car extends Serializable {
//    }
    // error because PERMITS must be the last

    sealed interface Example2 extends Serializable permits ExampleImpl {
    }

    @Test
    void lesson12ImplementationInheritance_continuation_two() {
        // 12.5 - special cases in sealed type hierarchies

        // RECORD and ENUM doesn't permit EXTENDS, but permit IMPLEMENTS
        // record is implicitly final - doesn't need to mark as final
    }

    class Base /* permits Sub1, Sub2 */ {}
    final class Sub1 extends Base{}
    final class Sub2 extends Base{}


    sealed interface BaseIF permits SubEnum, SubRecord {}
    enum SubEnum implements BaseIF {}
    final record SubRecord() implements BaseIF {}


}
