package tests.base;

import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import util.TestListener;

import static common.CommonActions.createDriver;
import static util.PropertiesUtil.getProp;

@Epic(value = "UI Тесты")
@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void close() {
        if (Boolean.parseBoolean(getProp("close_browser"))) {
            driver.quit();
        }
    }
}
