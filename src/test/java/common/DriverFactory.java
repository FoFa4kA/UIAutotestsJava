package common;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class DriverFactory {

    public static WebDriver createDriver() {
        WebDriver driver = null;
        String browser = getProp("browser");

        if (Boolean.parseBoolean(getProp("remote"))) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setPlatform(Platform.WIN10);
            switch (browser) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "ie":
                    capabilities.setBrowserName("internet explorer");
                    break;
                default:
                    System.out.println("Unsupported browser or invalid browser name: " + browser);
            }

            try {
                driver = new RemoteWebDriver(new URL(getProp("grid_hub")), capabilities);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        } else {
            switch (browser) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", getProp("chromedriver"));
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.setProperty("webdriver.gecko.driver", getProp("geckodriver"));
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver", getProp("edgedriver"));
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    System.setProperty("webdriver.ie.driver", getProp("iedriver"));
                    InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                    ieOptions.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                    ieOptions.setCapability(CapabilityType.BROWSER_VERSION, "11");
                    ieOptions.setCapability("ignoreProtectedModeSettings", true);
                    driver = new InternetExplorerDriver(ieOptions);
                    break;
                default:
                    System.out.println("Unsupported browser or invalid browser name: " + browser);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
        return driver;
    }
}
