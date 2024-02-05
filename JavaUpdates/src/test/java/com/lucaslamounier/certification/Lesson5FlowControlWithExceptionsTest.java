package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class Lesson5FlowControlWithExceptionsTest {

    @Test
    void lesson5FlowControlWithExceptionsTest() {
        // checked exceptions ->
        // generally external, compiler expects exception handling (IOException, SQLException)
        // unchecked exceptions ->
        // compiler ignores (nullpointer, outofboundsindex)
    }

    ///////////////////////////////////
    // Compiler Want You To Declare The Most Generic Exception
    ///////////////////////////////////

    class SpecificException extends IOException {
    }

    void handle() throws IOException {
        throw new SpecificException();
    }

    @Test
    void flowControlTryWithResources() throws IOException {
//        try (FileReader fr = new FileReader("");
//             FileWriter fw = new FileWriter("");) {
//        }
    }

    //////////////////////////////////////////
    // try-with-resources only works when class implements AutoClosable (or extends Closable)

    class MyResource implements AutoCloseable {
        @Override
        public void close() {
            System.out.println("MyResource closing");
        }
    }

    @Test
    void shouldCloseResource() {
        System.out.println("Starting...");
        try (MyResource myResource = new MyResource()) {
            System.out.println("started try");
        }
        System.out.println("Finishing method");

        /// NOTE -> resources are closed in the reverse order they are in try-with-resources
    }
}
