package com.lucaslamounier;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class FileMethodsTest {

    @Test
    void fileMustBe_Created_Written_Excluded() throws IOException {
        Path tempFile = Files.createTempFile(Path.of("./"), "temp", ".txt");
        Path filePath = Files.writeString(tempFile, "Sample text");

        String fileContent = Files.readString(filePath);
        assertThat(fileContent).isEqualTo("Sample text");

        Files.delete(tempFile);
    }
}
