package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
            try {
                switch (browser) {
                    case "chrome":
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setPlatformName("Windows 10");
                        driver = new RemoteWebDriver(new URL(getProp("grid_hub")), chromeOptions);
                        break;
                    case "firefox":
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setPlatformName("Windows 10");
                        driver = new RemoteWebDriver(new URL(getProp("grid_hub")), firefoxOptions);
                        break;
                    case "edge":
                        EdgeOptions edgeOptions = new EdgeOptions();
                        edgeOptions.setPlatformName("Windows 10");
                        driver = new RemoteWebDriver(new URL(getProp("grid_hub")), edgeOptions);
                        break;
                    default:
                        System.out.println("Unsupported browser or invalid browser name: " + browser);
                }
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
                default:
                    System.out.println("Unsupported browser or invalid browser name: " + browser);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
        return driver;
    }
}
