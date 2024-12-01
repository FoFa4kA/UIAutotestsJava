package pages.sqlex;

import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;

import static util.PropertiesUtil.getProp;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='subm2']")
    private WebElement loginWithoutRegButton;
    @FindBy(css = "[href='/logout.php']")
    private WebElement logoutButton;

    @Step("Нажатие на кнопку 'Вход без регистрации'")
    public MainPage loginWithoutRegistration() {
        waitElementToBeVisible(loginWithoutRegButton).click();
        waitElementToBeVisible(logoutButton);
        return this;
    }

    @Step("Нажатие на кнопку выхода")
    public MainPage logout() {
        waitElementToBeVisible(logoutButton).click();
        return this;
    }

    @Step("Запись cookies в файл")
    public MainPage writeCookiesToFile() {
        Set<Cookie> cookies = driver.manage().getCookies();
        File cookieFile = new File(getProp("cookies_file"));
        try(FileWriter writer = new FileWriter(cookieFile)) {
            for (Cookie cookie : cookies) {
                writer.write(cookie.getName() + "=" + cookie.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Чтение cookies из файла")
    public MainPage readCookiesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getProp("cookies_file")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String name = parts[0];
                    String value = parts[1];
                    driver.manage().addCookie(new Cookie(name, value));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }
}
