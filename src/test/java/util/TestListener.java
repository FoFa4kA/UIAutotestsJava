package util;

import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestContext;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static util.AddAttachment.getBytes;

public class TestListener implements IInvokedMethodListener {

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult, ITestContext context) {
        WebDriver driver = (WebDriver) context.getAttribute("driver");
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
            System.out.println(method.getTestMethod().getMethodName());
        }
    }
}