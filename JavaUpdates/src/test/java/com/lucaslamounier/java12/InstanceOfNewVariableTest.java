package com.lucaslamounier.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InstanceOfNewVariableTest {

    @Test
    void instanceOf_CanCreateVariableInIf() {
        Object obj = "Hello World!";
        if (obj instanceof String s) {
            obj = "Object changed if true: " + s;
        }

        assertThat(obj).isEqualTo("Object changed if true: Hello World!");
    }

}
