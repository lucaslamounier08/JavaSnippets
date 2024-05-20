package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class Lesson16GenericsAndGenericDeclarationsTest {

    @Test
    void lesson16GenericsAndGenericDeclarationsTest() {
        // 16.1 - fundamentals of generics
        List list = new ArrayList<>();
        list.add("Test");
        list.add(LocalDateTime.now());
        list.forEach(System.out::println);

        list = new ArrayList<>(List.of("TestName", LocalDateTime.now()));
        list.forEach(System.out::println);

        //new ArrayList<>(List.of("")).add(LocalDateTime.now()); // compilation error
        new ArrayList<Object>(List.of("")).add(LocalDateTime.now()); // is ok

        assertThrows(ClassCastException.class, () -> {
            List l = new ArrayList<String>();
            l.add(LocalDateTime.now());
            List<String> ls = l;
            String s = ls.get(0); // throw ClassCastException here
        });

        // 16.2 - declaring generic types and methods
        Map<Integer, String> mis = Map.of(1, "one", 2, "two");
        processElement(mis, 1, v -> System.out.println("Number is " + v));

        // 16.3 - using bounds and wildcards

    }

    public <K, V> void processElement(Map<K, V> map, K key, Consumer<V> op) {
        V element = map.get(key);
        if (element != null) op.accept(element);
    }

    class C1 {
    }

    interface I1 {
    }

    interface I2 {
    }

    interface I3 {
    }

    class B<E extends C1 & I1 & I2 & I3> {
    }

    public static void doStuffLC1(List<? super String> list) {
        list.forEach(System.out::println);
    }

    public static void doStuffLC2(List<? extends String> list) {
        list.forEach(System.out::println);
    }

    @Test
    void continueTest() {
        doStuffLC1(Collections.singletonList("test"));
        doStuffLC2(Collections.singletonList("test"));
    }

    interface Function<A, B> {
        B apply(A a);
    }

    class C<A, B> {
        private A a;
        public void modify(Function<A, A> fn) {
            a = fn.apply(a);
        }
    }
}
