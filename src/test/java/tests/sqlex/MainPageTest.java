package tests.sqlex;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.util.concurrent.TimeUnit;

import static util.PropertiesUtil.getProp;

@Feature(value = "Авторизация с использованием cookies")
public class MainPageTest extends BaseTest {
    int testRunCount = 0;

    @BeforeTest
    public void setUp() {
        driver.get(getProp("sqlex_page"));
    }

    @Story("Авторизация и получение cookie, авторизация с помощью cookie при втором прогоне")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test(invocationCount = 2)
    public void loginAndTakeCookie() {
        try {
            if (testRunCount == 0) {
                mainPage.loginWithoutRegistration()
                        .writeCookiesToFile();
                TimeUnit.SECONDS.sleep(2);
                mainPage.logout();
                TimeUnit.SECONDS.sleep(2);
                testRunCount++;
            } else {
                mainPage.readCookiesFromFile();
                TimeUnit.SECONDS.sleep(2);
                driver.navigate().refresh();
                TimeUnit.SECONDS.sleep(2);
                mainPage.logout()
                        .deleteFileWithCookies();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
