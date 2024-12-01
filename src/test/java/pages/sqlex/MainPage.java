package pages.sqlex;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import static util.JsExecutorActions.removeFocusFromElement;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[name='subm2']")
    private WebElement loginWithoutRegButton;
    @FindBy(css = "[href='/logout.php']")
    private WebElement logoutButton;
    @FindBy(css = "[type='text'][name='login']")
    private WebElement loginInput;
    @FindBy(css = "[rel='nofollow']")
    private WebElement liveInternetLink;

    public WebElement getLoginWithoutRegButton() {
        return loginWithoutRegButton;
    }

    public WebElement getLoginInput() {
        return loginInput;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

    @Step("Нажатие на кнопку 'Вход без регистрации'")
    public MainPage loginWithoutRegistration() {
        waitElementToBeVisible(loginWithoutRegButton).click();
        waitElementToBeVisible(logoutButton);
        return this;
    }

    @Step("Cнятие фокуса с поля ввода логина")
    public MainPage removeFocusFromLoginInput(JavascriptExecutor jsEx) {
        removeFocusFromElement(jsEx, loginInput);
        return this;
    }
}
