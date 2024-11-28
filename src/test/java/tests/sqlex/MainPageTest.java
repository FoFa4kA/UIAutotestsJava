package tests.sqlex;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.File;

import static util.PropertiesUtil.getProp;

@Feature(value = "Авторизация с использованием cookies")
public class MainPageTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(getProp("sqlex_page"));
    }

    @Story("Авторизация и запись cookies в файл, чтение cookies из файла при повторном прогоне")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test()
    public void loginAndWriteCookiesOrReadCookiesForLogin() {
        if (new File(getProp("cookies_file")).exists()) {
            mainPage.readCookiesFromFile();
            driver.navigate().refresh();
            mainPage.logout();
        } else {
            mainPage.loginWithoutRegistration()
                    .writeCookiesToFile();
        }
    }
}
