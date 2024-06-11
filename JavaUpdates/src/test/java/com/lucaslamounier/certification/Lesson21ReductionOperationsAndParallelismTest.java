package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Lesson21ReductionOperationsAndParallelismTest {

    @Test
    void lesson21ReductionOperationsAndParallelismTest() {
        // 21.1 - Collection and Reduction - part 1
        // reduction - Stream operation that produces a single result
        List<Integer> integerList = List.of(1, 2, 3);
        Optional<Integer> reducedInts = integerList.stream().reduce((integer, integer2) -> integer + integer2);
        assertEquals(6, reducedInts.get()); // 1 + 2 = 3; 3 + 3 = 6;

        List<String> stringList = List.of("one", "two", "three");
        Optional<String> reducedStrings = stringList.stream().reduce((s, s2) -> s.concat(s2));
        assertEquals("onetwothree", reducedStrings.get());

        List<String> emptyList = new ArrayList<>();
        String stringReduced = emptyList.stream().reduce("no elements", (s, s2) -> s.concat(s2));
        assertEquals("no elements", stringReduced);

        // 21.2 - Mutating Reduction
        stringList.stream().collect(Collectors.toList());

        // 21.3 - grouping and partitioning with collectors
        // Collectors.groupingBy:
        Map<Integer, List<String>> collectedByGrouping = stringList.stream().collect(Collectors.groupingBy(s -> s.length()));
        collectedByGrouping.forEach((integer, strings) -> System.out.println(integer + " - " + strings));

        Map<Boolean, List<String>> collectedByPartitioning = stringList.stream().collect(Collectors.partitioningBy(s -> s.length() == 3));
        collectedByPartitioning.forEach((aBoolean, strings) -> System.out.println(aBoolean + " - " + strings));

        // but this we can also achieve with stream.filter
        stringList.stream().filter(s -> s.length() == 3).toList().forEach(System.out::println);

        stringList.stream().map(s -> s.length()).toList().forEach(System.out::println);

        // 21.4 - downstream operations with Collectors
        // downstream - collectors inside collectors
        Map<Integer, String> collect = stringList
                .stream()
                .collect(Collectors.groupingBy(s -> s.length(),
                        Collectors.mapping(s -> s.toUpperCase(), Collectors.joining(", "))));
        collect.forEach((integer, s) -> System.out.println(integer + " - " + s));

        // 21. 5 - parallel stream operation
        stringList.parallelStream().collect(Collectors.toList()).forEach(s -> System.out.println(s));

        stringList.stream()
                .map(s -> s.length())
                .map(integer -> integer + 10)
                .map(integer -> integer + 100)
                .collect(Collectors.toList());

        // 21.6 - question deep dive

    }

}
