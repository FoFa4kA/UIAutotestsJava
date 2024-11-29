package util;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Stream;

import static util.PropertiesUtil.getProp;

public class CookiesManager {

    @Step("Запись cookies в файл")
    public static void writeCookiesToFile(WebDriver driver) {
        Set<Cookie> cookies = driver.manage().getCookies();
        File cookieFile = new File(getProp("cookies_file"));
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(cookieFile))) {
            for (Cookie cookie : cookies) {
                writer.write(cookie.getName() + "=" + cookie.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Чтение cookies из файла")
    public static void readCookiesFromFile(WebDriver driver) {
        try (Stream<String> lines = Files.lines(Paths.get(getProp("cookies_file")))) {
            lines.forEach(line -> {
                String[] split = line.split("=");
                driver.manage().addCookie(new Cookie(split[0], split[1]));
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
