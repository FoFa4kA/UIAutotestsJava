package util;

import io.qameta.allure.Attachment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AddAttachment {

    @Attachment(value = "Screenshot", fileExtension = ".png")
    public static byte[] getBytes(String resourceName) {
        try {
            return Files.readAllBytes(Paths.get("src/test/resources", resourceName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
