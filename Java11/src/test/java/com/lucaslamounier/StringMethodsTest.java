package com.lucaslamounier;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringMethodsTest {

    @Test
    void stringStrip_ShouldRemoveEmptySpaces() {
        assertThat(" text between spaces ".strip()).isEqualTo("text between spaces");
    }

    @Test
    void stringStripLeading_ShouldRemoveInitialEmptySpaces() {
        assertThat(" text between spaces ".stripLeading()).isEqualTo("text between spaces ");
    }

    @Test
    void stringStripTrailing_ShouldRemoveEndEmptySpaces() {
        assertThat(" text between spaces ".stripTrailing()).isEqualTo(" text between spaces");
    }

    @Test
    void stringRepeat_ShouldRepeatText() {
        assertThat("Dummy!".repeat(2)).isEqualTo("Dummy!Dummy!");
    }
}