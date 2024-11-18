package tests.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.way_2_automation.HomePage;
import pages.way_2_automation.LoginPage;

import static common.CommonActions.createDriver;
import static util.GetBoolean.getBooleanFromString;
import static util.PropertiesUtil.getProp;

public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected BasePage basePage = new BasePage(driver, actions);
    protected HomePage homePage = new HomePage(driver, actions);
    protected LoginPage loginPage = new LoginPage(driver, actions);

    @AfterTest
    public void close() {
        boolean closeBrowser = getBooleanFromString(getProp("close_browser"));
        if (closeBrowser) {
            driver.quit();
        }
    }
}
