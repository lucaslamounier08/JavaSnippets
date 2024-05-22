package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Lesson18ComparatorComparableAndOrderingTest {

    @Test
    void lesson18ComparatorComparableAndOrderingTest() {
        // 18.1 - comparison is subtraction, always first argument minus second argument
        // 8 - 2 = 6 ---> 8 comes after 2
        // 5 - 5 = 0 ---> equals
        String aaa = "aaa";
        String b = "b";
        assertEquals(-1, aaa.compareTo(b));

        // 18.2 - sorting arrays and collections
//        Arrays.sort();
//        List.sort();
//        Collections.sort();

        // 18.3 - comparator factories and decorators
        List<Student> students = new ArrayList<>(List.of(
                new Student("a", 44),
                new Student("b", 45),
                new Student("c", 46),
                new Student("d", 47),
                new Student("a", 48),
                new Student("e", 49),
                new Student("b", 51)
        ));
        System.out.println("Original order");
        students.forEach(System.out::println);

        System.out.println("By order");
        students.sort(Comparator.comparing((Student s) -> s.name)
                .thenComparing(s -> s.order, Comparator.reverseOrder()));
        students.forEach(System.out::println);
    }

    public record Student(String name, int order) {

    }

}
