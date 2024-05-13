package com.lucaslamounier.certification;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
class Lesson11LocalVariableTypeInferenceTest {

    @Test
    void lesson11LocalVariableTypeInferenceTest() {
        // 11.1 - using var for Regular Variables
        // "var" is Pseudotype

        var x = "Hello";
        //x = 99; -> fails

        // var x; -> fails, need to be initialized in declaration

        // var x = { 1, 2, 3 }; -> fails, this is ambiguous

        var xxx = new int[]{1, 2, 3};

        // var [] x = new int[] {1, 2, 3}; -> fails because var is the entire object declared

        // var x = 1, y = 2; -> fails because var is restricted to single variable

        // 11.2 - uses and restrictions of var
        class x {
            // var x = 0; -> fails, var is only for inside methods
        }

        for (var var = 0; var < 10; var++) {
            System.out.println(var); // var can be used inside for, and VAR is not a restricted word
        }

        try (var in = Files.newBufferedReader(Path.of(""))) { // VAR here is ok
        } catch (IOException e) { // VAR here is not ok, because exception is not explicit
            //
        }

    }

}
