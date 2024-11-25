package pages.way2automation;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.List;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;
import static util.PropertiesUtil.getProp;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, Actions actions) {
        super(driver, actions);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#username")
    private WebElement usernameInput;
    @FindBy(css = "#password")
    private WebElement passwordInput;
    @FindBy(css = "input[ng-model='model[options.key]']")
    private WebElement usernameDiscInput;
    @FindBy(css = "button[disabled='disabled']")
    private WebElement disabledLoginButton;
    @FindBy(css = ".btn")
    private WebElement loginButton;
    @FindBy(xpath = "//p[text()=\"You're logged in!!\"]")
    private WebElement successLoggedInMessage;
    @FindBy(css = ".alert-danger")
    private WebElement incorrectCredentialsMessage;
    @FindBy(css = "a[href='#/login']")
    private WebElement logoutButton;

    @Step("Ввод данных для авторизации")
    public LoginPage enterCredentialsIntoFields(String username, String password, String usernameDesc) {
        waitElementToBeVisible(usernameInput).sendKeys(getProp(username));
        waitElementToBeVisible(passwordInput).sendKeys(getProp(password));
        waitElementToBeVisible(usernameDiscInput).sendKeys(getProp(usernameDesc));
        return this;
    }

    @Step("Нажатие на активную кнопку 'Login'")
    public LoginPage clickLoginButton() {
        moveToElementAndClickWithPause(loginButton, 1);
        return this;
    }

    @Step("Появление сообщения 'Username or password is incorrect'")
    public LoginPage incorrectCredentialsMessageAppears() {
        waitElementToBeVisible(incorrectCredentialsMessage);
        return this;
    }

    @Step("Появление сообщения об успешной авторизации")
    public LoginPage successLoginMessageAppears() {
        waitElementToBeVisible(successLoggedInMessage);
        return this;
    }

    @Step("Проверка ввод во все поля ввода и активация кпопки 'Login'")
    public LoginPage checkInputsAndLoginButtonDisabled() {
        waitElementToBeVisible(disabledLoginButton);
        enterCredentialsIntoFields("username", "password", "user_desc");
        assertFalse(disabledLoginButton.isDisplayed());
        return this;
    }

    @Step("Проверка выхода из аккаунта")
    public LoginPage checkLogout() {
        waitElementToBeVisible(logoutButton).click();
        List.of(
            usernameInput,
            passwordInput,
            usernameDiscInput
        ).forEach(this::waitElementToBeVisible);
        return this;
    }

    @Step("Очистка полей ввода или выход из аккаунта")
    public LoginPage clearAllFieldsOrLogout() {
        if (usernameInput.isDisplayed()) {
            waitElementToBeVisible(usernameInput).clear();
            waitElementToBeVisible(passwordInput).clear();
            waitElementToBeVisible(usernameDiscInput).clear();
        } else {
            checkLogout();
        }
        return this;
    }
}
