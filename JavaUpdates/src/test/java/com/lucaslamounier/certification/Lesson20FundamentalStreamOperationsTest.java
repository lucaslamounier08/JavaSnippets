package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.Spliterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Slf4j
class Lesson20FundamentalStreamOperationsTest {

    @Test
    void lesson20FundamentalStreamOperationsTest() {
        // 20.1 - the monad-like methods
        // map operation -> modify content and creates another map
        // list.stream.map()

        // filter method -> takes a single argument of type Predicate<? super A>

        // 20.2 - stream utilities
        // Box/Unbox primitives is inefficient, stream handles better:
        // IntStream
        // LongStream
        // DoubleStream
        // methods> mapToInt, mapToLong, mapToDouble
        List<String> strings = List.of("1", "2", "3", "4", "5");
        IntStream intStream = strings.stream().mapToInt(String::length).filter(value -> value != 0);

        Stream.Builder<Object> builder = Stream.builder();
        builder.add("test");
        Stream<Object> build = builder.build();

        IntStream numbersFrom1To1000 = IntStream.iterate(1, v -> v < 1000, v -> v + 2);
        IntStream numbersFrom1To1000_2 = IntStream.iterate(1, v -> v + 2).limit(500);
        IntStream numbersFrom1To1000_3 = IntStream.rangeClosed(1, 999).filter(v -> v % 2 != 0);
        IntStream numbersFrom1To1000_4 = IntStream.range(1, 1000).filter(v -> v % 2 != 0);

        for (int i = 1; i < 1000; i = i + 2) {
            System.out.println(i);
        }

        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@@@@@@@@@@@@@@@@@@");

        // Spliterator exists to support parallel operations
        IntStream range = IntStream.range(0, 1000);
        Spliterator.OfInt spliterator1 = range.spliterator();
        spliterator1.tryAdvance((int x) -> System.out.println(x));
        spliterator1.tryAdvance((int x) -> System.out.println(x));
        spliterator1.tryAdvance((int x) -> System.out.println(x));

        Spliterator.OfInt sp2 = spliterator1.trySplit();
        spliterator1.tryAdvance((int x) -> System.out.println(x));
        sp2.tryAdvance((int x) -> System.out.println(x));

        // 20.3 - simple terminal methods, and laziness
        // terminal operations - operations of stream that not returns a Stream - termines stream
        // exemple: allMatch, anyMatch, collect, count, findAny, findFirst, max, min, noneMatch, reduce,
        // Streams try to be lazy

        new Random().doubles(-1.0, 1.0)
                .limit(1000)
                .average()
                .ifPresent(System.out::println);

    }

}
