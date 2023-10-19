package com.lucaslamounier.java12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class FileMethodsTest {

    @Test
    void filesMismatch_givenIdenticalFiles_thenShouldNotFindMismatch() throws IOException {
        Path filePath1 = Files.createTempFile("file1", ".txt");
        Path filePath2 = Files.createTempFile("file2", ".txt");
        Files.writeString(filePath1, "Java 12 Article");
        Files.writeString(filePath2, "Java 12 Article");

        long mismatch = Files.mismatch(filePath1, filePath2);
        Assertions.assertEquals(-1, mismatch);

        Files.delete(filePath1);
        Files.delete(filePath2);
    }

    @Test
    void filesMismatch_givenDifferentFiles_thenShouldFindMismatch() throws IOException {
        Path filePath3 = Files.createTempFile("file3", ".txt");
        Path filePath4 = Files.createTempFile("file4", ".txt");
        Files.writeString(filePath3, "Java 12 Article");
        Files.writeString(filePath4, "Java 12 Tutorial");

        long mismatch = Files.mismatch(filePath3, filePath4);
        Assertions.assertEquals(8, mismatch);

        Files.delete(filePath3);
        Files.delete(filePath4);
    }
}
