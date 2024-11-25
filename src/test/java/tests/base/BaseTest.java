package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import pages.base.BasePage;
import pages.way2automation.HomePage;
import pages.way2automation.LoginPage;

import static common.CommonActions.createDriver;
import static util.PropertiesUtil.getProp;

public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected BasePage basePage = new BasePage(driver, actions);
    protected HomePage homePage = new HomePage(driver, actions);
    protected LoginPage loginPage = new LoginPage(driver, actions);

    @AfterClass
    public void close() {
        if (Boolean.parseBoolean(getProp("close_browser"))) {
            driver.quit();
        }
    }
}
