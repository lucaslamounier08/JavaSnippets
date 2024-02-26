package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class Lesson6CustomExceptionsTest {

    @Test
    void lesson6CustomExceptionsTest() {
        // should simple subclass exceptions
        // bug -> RuntimeException child
        // catastrophe -> Error child
        // recoverable -> Exception -> this is a CHECKED exception
    }
}
