package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

@Slf4j
class Lesson19DefiningLambdaExpressionsTest {

    interface PS { boolean test(String st);}

    @Test
    void lesson19DefiningLambdaExpressionsTest() {
        // 19.1 - lambda expression syntax variations
        // lambdas are object expressions that implement an interface
        // must have exactly one abstract method - can have @FunctionalInterface

        // 19.2 - lambda expression context
        PS[] psa = {null};
        psa[0] = s -> s.length() > 3;

        PS[] psa2 = { s -> s.length() > 3, s -> s.length() > 3, s -> {
            System.out.println("Testing");
            return s.length() > 3;
        }};

        for (int i = 0; i < psa2.length; i++) {
            System.out.println(i + " - " + psa2[i].test("abacate"));
        }

        // 19.3 - core functional interfaces
        BiFunction biFunction = new BiFunction() {
            @Override
            public Object apply(Object o, Object o2) {
                return false;
            }
        };

        BiConsumer biConsumer = new BiConsumer() {
            @Override
            public void accept(Object o, Object o2) {
                return;
            }
        };

        Predicate predicate = new Predicate() {
            @Override
            public boolean test(Object o) {
                return false;
            }
        };

        BiPredicate biPredicate = new BiPredicate() {
            @Override
            public boolean test(Object o, Object o2) {
                return false;
            }
        };

        Supplier supplier = new Supplier() {
            @Override
            public Object get() {
                return null;
            }
        };

        UnaryOperator unaryOperator = new UnaryOperator() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };

        BinaryOperator binaryOperator = new BinaryOperator() {
            @Override
            public Object apply(Object o, Object o2) {
                return null;
            }
        };

        UnaryOperator<String> stringUnaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };

        Callable<String> stringCallable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        };

        // 19.4 - method references

    }

}
