package com.lucaslamounier.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringMethodsTest {

    @Test
    void stringIndent_ShouldIndentString_AndBreakLine() {
        assertThat("normal text".indent(2)).isEqualTo("  normal text\n");
    }
}
