package tests.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.way_2_automation.HomePage;

import static common.CommonActions.createDriver;
import static util.GetBoolean.getBooleanFromString;
import static util.PropertiesUtil.getProp;

public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected BasePage basePage = new BasePage(driver, actions);
    protected HomePage homePage = new HomePage(driver, actions);

//    @AfterTest
//    public void clearCookiesAndLocalStorage() {
//        boolean clearCookiesAndStorage = getBooleanFromString(getProp("clear_cookies_and_storage"));
//        if (clearCookiesAndStorage) {
//            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//            driver.manage().deleteAllCookies();
//            jsExecutor.executeScript("window.sessionStorage.clear();");
//        }
//    }

    @AfterSuite(alwaysRun = true)
    public void close() {
        boolean closeBrowser = getBooleanFromString(getProp("close_browser"));
        if (closeBrowser) {
            driver.quit();
        }
    }
}
