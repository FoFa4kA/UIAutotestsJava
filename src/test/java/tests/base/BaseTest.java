package tests.base;

import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import util.TestListener;
import util.TestRetry;

import java.util.Arrays;

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

    @BeforeSuite
    @Parameters({"context"})
    public void beforeSuite(@org.testng.annotations.Optional ITestContext context) {
        Arrays.stream(context.getAllTestMethods()).forEach(method -> method.setRetryAnalyzerClass(TestRetry.class));
    }

    @AfterClass
    public void close() {
        if (Boolean.parseBoolean(getProp("close_browser"))) {
            driver.quit();
        }
    }
}
