package pages.way2automation;

import io.qameta.allure.Step;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[href='#example-1-tab-2']")
    private WebElement inputAlertTab;
    @FindBy(css = "[src='alert/input-alert.html']")
    private WebElement inputAlertFrame;
    @FindBy(css = "[onclick='myFunction()']")
    private WebElement promptAlertInvocationButton;
    @FindBy(css = "[id='demo']")
    private WebElement greetingText;

    public WebElement getGreetingText() {
        return greetingText;
    }

    @Step("Вызов алерта с полем ввода")
    public AlertsPage invokePromptAlert() {
        inputAlertTab.click();
        driver.switchTo().frame(inputAlertFrame);
        promptAlertInvocationButton.click();
        return this;
    }

    @Step("Ввод текста в поле ввода алерта и подтверждение")
    public AlertsPage inputAndAcceptPromptAlert(String text) {
        Alert promptAlert = driver.switchTo().alert();
        promptAlert.sendKeys(text);
        promptAlert.accept();
        return this;
    }
}
