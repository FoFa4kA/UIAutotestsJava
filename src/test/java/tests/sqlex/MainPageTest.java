package tests.sqlex;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.sqlex.MainPage;
import tests.base.BaseTest;

import java.io.File;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
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

    @Story("Тест снятия фокуса с поля воода и наличия скролла на странице")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void testInputFocusDisableAndPageScroll() {
        JavascriptExecutor jsEx = (JavascriptExecutor) driver;
        mainPage.checkLoginInputInactive(jsEx);
        assertNotEquals(jsEx.executeScript("return document.body.offsetHeight"),
                jsEx.executeScript("return window.innerHeight"));
    }

    @Story("Авторизация и запись cookies в файл, чтение cookies из файла при повторном прогоне")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(priority = 1)
    public void loginAndWriteCookiesOrReadCookiesForLogin() {
        if (new File(getProp("cookies_file")).exists()) {
            readCookiesFromFile(driver);
            driver.navigate().refresh();
        } else {
            mainPage.loginWithoutRegistration();
            writeCookiesToFile(driver);
        }
        assertFalse(mainPage.elementIsVisible(mainPage.getLoginWithoutRegButton()));
    }
}
