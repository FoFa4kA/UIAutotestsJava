package tests.sqlex;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.sqlex.MainPage;
import tests.base.BaseTest;

import java.io.File;

import static util.CookiesManager.readCookiesFromFile;
import static util.CookiesManager.writeCookiesToFile;
import static util.PropertiesUtil.getProp;

@Feature(value = "SQL-ex - Главная страница")
public class MainPageTest extends BaseTest {
    protected MainPage mainPage = new MainPage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("sqlex_page"));
    }

    @Story("Авторизация и запись cookies в файл, чтение cookies из файла при повторном прогоне")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void loginAndWriteCookiesOrReadCookiesForLogin() {
        if (new File(getProp("cookies_file")).exists()) {
            readCookiesFromFile(driver);
            driver.navigate().refresh();
        } else {
            mainPage.loginWithoutRegistration();
            writeCookiesToFile(driver);
        }
        mainPage.assertMainPageRedirect();
    }
}
