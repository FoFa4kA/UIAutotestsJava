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
    private static final String BROWSER_ERROR_MESSAGE = "Unexpected browser name: ";

    private static void setSysPropWebDriver(String browser) {
        String webDriverName;
        String webDriverProp;

        if (browser.equals("firefox")) {
            webDriverName = "webdriver.gecko.driver";
            webDriverProp = "geckodriver";
        } else {
            webDriverName = "webdriver." + browser + ".driver";
            webDriverProp = browser + "driver";
        }
        System.setProperty(webDriverName, getProp(webDriverProp));
    }

    private static WebDriver createRemoteWebDriver(String browser) {
        WebDriver remoteWebDriver = null;
        String platform = getProp("os");
        String gridHubUrl = getProp("grid_hub");

        try {
            switch (browser) {
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setPlatformName(platform);
                    remoteWebDriver = new RemoteWebDriver(new URL(gridHubUrl), chromeOptions);
                    break;
                case "firefox":
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setPlatformName(platform);
                    remoteWebDriver = new RemoteWebDriver(new URL(gridHubUrl), firefoxOptions);
                    break;
                case "edge":
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.setPlatformName(platform);
                    remoteWebDriver = new RemoteWebDriver(new URL(gridHubUrl), edgeOptions);
                    break;
                default:
                    throw new IllegalStateException(BROWSER_ERROR_MESSAGE + browser);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        return remoteWebDriver;
    }

    private static WebDriver createLocalWebDriver(String browser) {
        WebDriver localWebDriver = null;

        switch (browser) {
            case "chrome":
                setSysPropWebDriver(browser);
                localWebDriver = new ChromeDriver();
                break;
            case "firefox":
                setSysPropWebDriver(browser);
                localWebDriver = new FirefoxDriver();
                break;
            case "edge":
                setSysPropWebDriver(browser);
                localWebDriver = new EdgeDriver();
                break;
            default:
                throw new IllegalStateException(BROWSER_ERROR_MESSAGE + browser);
        }
        return localWebDriver;
    }

    public static WebDriver createDriver() {
        String browser = getProp("browser");

        WebDriver driver = Boolean.parseBoolean(getProp("remote"))
                ? createRemoteWebDriver(browser)
                : createLocalWebDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
        return driver;
    }
}
