package com.lucaslamounier;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class NewStringMethodsTest {

    @Test
    void stringStrip_ShouldRemoveEmptySpaces() {
        String s = " text between spaces ";

        s = s.strip();

        assertThat(s).isEqualTo("text between spaces");
    }
}