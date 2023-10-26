package com.lucaslamounier.java14;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecordsTest {
    public record User(Long id, String name) {
    };

    private final User user = new User(1L, "UserOne");

    @Test
    void givenRecord_whenObjInitialized_thenValuesCanBeFetchedWithGetters() {
        assertEquals(1, user.id());
        assertEquals("UserOne", user.name());
    }

    @Test
    void whenRecord_thenEqualsImplemented() {
        User user2 = user;
        assertTrue(user.equals(user2));
    }

    @Test
    void whenRecord_thenToStringImplemented() {
        assertTrue(user.toString().contains("UserOne"));
    }
}
