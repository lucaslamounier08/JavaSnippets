package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class Lesson14InterfacesTest {

    @Test
    void lesson14InterfacesTest() {
        // 14.1 - interfaces, methods and functional interfaces
        // interface can EXTENDS another interface - private and static methods are no inherited

        // functional interface - declares exactly one abstract method
        // @FunctionalInterface
    }

    interface Interface {
        private void doA() {
        }
    }

    class InterfaceImpl implements Interface {
        public void main() {

        }
    }


    //////////////////////////////
    interface A extends Interface {
        public void m1();

        /*protected*/ void m2();

        void m3();
        //private void m4();

        //        public void m5() {}
//        protected void m6() {}
//        void m7() {}
        private void m8() {
        }

    }


    ///////////////////////
    interface Aa {
        default void doStuff(int x) {
        }
    }

    interface Bb extends Aa {
        void doStuff(int y);
    }

    class Xx implements Aa {
    }

    class Yy implements Bb {
        public void doStuff(int y) {
            // SHOULD OVERRIDE
        }
    }

    @FunctionalInterface
    interface Dd {
        static void m1() {
        }

        void m3();
    }

    @FunctionalInterface
    interface Ee extends Dd {
    }

    @Test
    void continuationTest() {
        // 14.2 - interface implementation

        // 14.3 - default method resOlution
        // default method: default void doStuff() {}

        // A, B , C
    }

    interface P {
        default void doStuff() {
        }
    }

    interface Q {
        void doStuff();
    }

//    abstract class Aaa implements P, Q {
//        abstract void doStuff() {}
//    }

    abstract class B implements P, Q {
        public abstract void doStuff();
    }

    class C implements P {
    }

    //    class D implements P,Q {}
    class E implements P {
//        public void doStuff() {
//            super.doStuff();
//        }
    }
}
