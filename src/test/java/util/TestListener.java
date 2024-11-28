package util;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import tests.base.BaseTest;

public class TestListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Object currentTestClass = testResult.getInstance();
        WebDriver driver = ((BaseTest) currentTestClass).getDriver();
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Allure.getLifecycle().addAttachment("screenshot", "image/png", "png",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
        IInvokedMethodListener.super.afterInvocation(method, testResult);
    }
}
