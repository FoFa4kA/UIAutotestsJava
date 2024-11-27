package tests.base;

import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import pages.base.BasePage;
import pages.way2automation.HomePage;
import pages.way2automation.LoginPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import util.TestListener;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static common.CommonActions.createDriver;
import static util.AddAttachment.getBytes;
import static util.PropertiesUtil.getProp;

@Epic(value = "UI Тесты")
@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected BasePage basePage = new BasePage(driver, actions);
    protected HomePage homePage = new HomePage(driver, actions);
    protected LoginPage loginPage = new LoginPage(driver, actions);

    public void takeScreenshot() {
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

    @AfterClass
    public void close() {
        if (Boolean.parseBoolean(getProp("close_browser"))) {
            driver.quit();
        }
    }
}
