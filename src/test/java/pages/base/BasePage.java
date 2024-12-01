package pages.base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static util.PropertiesUtil.getProp;

public class BasePage {
    protected WebDriver driver;
    protected Actions actions;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver, Actions actions, JavascriptExecutor js) {
        this.driver = driver;
        this.actions = actions;
        this.js = (JavascriptExecutor) driver;
    }

    public WebElement waitElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(getProp("explicit_wait"))))
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementToBeVisible(WebElement element, long seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public boolean elementIsVisible(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WebElement scrollToElement(WebElement element) {
        actions.scrollToElement(element).perform();
        return element;
    }

    public WebElement moveToElement(WebElement element) {
        actions.moveToElement(element).perform();
        return element;
    }

    public WebElement moveToElementAndClickWithPause(WebElement element, long seconds) {
        actions.moveToElement(element)
                .pause(Duration.ofSeconds(seconds))
                .click()
                .perform();
        return element;
    }
}
