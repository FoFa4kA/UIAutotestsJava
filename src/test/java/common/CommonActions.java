package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class CommonActions {

    public static WebDriver createDriver() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(Platform.WIN10);
            capabilities.setBrowserName("chrome");
            WebDriver driver = new RemoteWebDriver(new URL(getProp("grid_hub")), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
