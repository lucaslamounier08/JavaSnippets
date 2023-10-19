package com.lucaslamounier.java13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringMethodsTest {

    @Test
    void textBlocks_AreNowPermitted() {
        String giantString = """
                hello
                world!
                This is a giant String using 3 ", and without scape
                """;

        assertThat(giantString).isEqualTo(
                """
                hello
                world!
                This is a giant String using 3 ", and without scape
                """
        );
    }
}
