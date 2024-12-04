package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class CommonActions {

    public static WebDriver createDriver() {
        WebDriver driver = null;
        if (Boolean.parseBoolean(getProp("remote"))) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setPlatform(Platform.WIN10);
                capabilities.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL(getProp("grid_hub")), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.setProperty("webdriver.chrome.driver", getProp("chromedriver"));
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
        return driver;
    }
}
