package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class CommonActions {

    public static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", getProp("chromedriver"));
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(getProp("implicit_wait"))));
        return driver;
    }
}
