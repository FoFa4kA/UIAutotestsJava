package util;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import tests.base.BaseTest;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static util.AddAttachment.getBytes;

public class TestListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        Object currentTestClass = testResult.getInstance();
        WebDriver driver = ((BaseTest) currentTestClass).getDriver();
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            try {
                ImageIO.write(screenshot.getImage(), "PNG",
                        new File("src/test/resources/screen.png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            getBytes("screen.png");
        }
        IInvokedMethodListener.super.afterInvocation(method, testResult);
    }
}
