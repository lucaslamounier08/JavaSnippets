package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

@Slf4j
class Lesson7ClassDefinitionAndReachabilityTest {

    static class MyList<E> implements Iterable<E> {
        private E[] data = (E[]) (new Object[10]);
        private int count = 0;

        public void add(E e) {
            data[count++] = e;
        }

        @Override
        public String toString() {
            return Arrays.stream(data).limit(count).map(Object::toString).collect(Collectors.joining(", ", "MyList[", "]"));
        }

        class MyIterator implements Iterator<E> {
            private int progress = 0;

            @Override
            public boolean hasNext() {
                return progress < count;
            }

            @Override
            public E next() {
                return data[progress++];
            }
        }

        @Override
        public Iterator<E> iterator() {
            return new MyIterator();
        }
    }

    @Test
    void lesson7ClassDefinitionAndReachabilityTest() {
        // 7.4
        MyList<String> mls = new MyList<>();
        MyList<String> mls2 = new MyList<>();
        mls.add("A");
        mls.add("B");
        mls.add("C");
        mls2.add("E");
        mls2.add("F");
        mls2.add("G");
        System.out.println(mls);
        System.out.println(mls2);

        Iterator<String> is1 = mls.iterator();
        Iterator<String> is2 = mls.iterator();
        Iterator<String> is3 = mls2.iterator();


        // Java allows class declarations inside blocks or methods
        class Test {
            private String t1;

            public Test(String t1) {
                this.t1 = t1;
            }

            public String getT1() {
                return t1;
            }

            public void setT1(String t1) {
                this.t1 = t1;
            }
        }


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("We can make instances of INTERFACES");
            }
        };
        runnable.run();


        // abstract class implementing interface:
        abstract class MyRunnable2 implements Runnable {
            final String message;
            public MyRunnable2(String message) {
                this.message = message;
            }
        }

        MyRunnable2 myRunnable2 = new MyRunnable2("Aloha") {
            @Override
            public void run() {
                System.out.println("MyRunnable2.message: " + message);
            }
        };


        // 7,6

        // 7.7

    }

    public class Access {
        String name = "";
        class A1 {
            String name = "A1";
        }
        static class A2 {
            String name = "A2";
        }
    }

    @Test
    void questionDeepDive() {
        System.out.println(new Access().new A1().name);
    }
}
