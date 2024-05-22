package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
class Lesson17JavaCoreCollectionsTest {

    static void addToArray(Object[] oa) {
        oa[oa.length - 1] = LocalDateTime.now();
    }

    @Test
    void lesson17JavaCoreCollectionsTest() {
        // 17.1 - Arrays, and Methods of Collection, List and Set - part 1
        assertThrows(ArrayStoreException.class, () -> {
            String[] sa = new String[4];
            addToArray(sa);
        });

        String[][][] arrayArrayArray = new String[4][][];

        Arrays.asList("listTest");

        int[] a1 = {2, 0, 0, 1};
        int[] a2 = {5, 0, 1};
        assertEquals(1, Integer.compare(2001, 501));
        assertEquals(-1, Arrays.compare(a1, a2));

        String[] names = {
                "1", "2", "3", "5", "6", "7", "8", "9"
        };
        assertEquals(-4, Arrays.binarySearch(names, "4"));

        // 17.2 - arrays and methods of Collection, List and Set
        // Iterator does not have defined size
        // Collection has

        // Iterable < Collection < (List and Set)
        // Set rejects duplicates

        // 17.3 - methods of Deque and Map
        // Queue interface is sub-interface of Collection
        Queue<String> stringQueue = new ArrayDeque<>();
        // Deque is a sub-interface of Queue
        // and provides insertion, removal and examination - access at Head and Tail
        // can use Deque as a Stack
        stringQueue.toArray();


        Map.Entry<String, String> entry = Map.entry("entryKey", "entryValue");

        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        map.merge("a", "b", (s, s2) -> {
            s.toString();
            return s;
        });
        assertEquals(2, map.size());
    }

}
