package com.lucaslamounier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NewStringMethodsTest {

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
}