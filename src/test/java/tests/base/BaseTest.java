package tests.base;

import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import pages.base.BasePage;
import pages.sqlex.MainPage;
import pages.way2automation.HomePage;
import pages.way2automation.LoginPage;
import util.TestListener;

import static common.CommonActions.createDriver;
import static util.PropertiesUtil.getProp;

@Epic(value = "UI Тесты")
@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected BasePage basePage = new BasePage(driver, actions);
    protected HomePage homePage = new HomePage(driver, actions);
    protected LoginPage loginPage = new LoginPage(driver, actions);
    protected MainPage mainPage = new MainPage(driver, actions);

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
