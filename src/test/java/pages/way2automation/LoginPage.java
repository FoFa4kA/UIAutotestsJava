package pages.way2automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.base.BasePage;

import java.util.List;
import java.util.Map;

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


    private void enterCredentialsIntoFields(String username, String password, String usernameDesc) {
        Map.of(
                usernameInput, username,
                passwordInput, password,
                usernameDiscInput, usernameDesc
        ).forEach((field, value) -> waitElementToBeVisible(field).sendKeys(getProp(value)));
    }

    public LoginPage checkInputsAndLoginButtonDisabled() {
        waitElementToBeVisible(disabledLoginButton);
        enterCredentialsIntoFields("username", "password", "user_desc");
        assertFalse(elementIsVisible(disabledLoginButton));
        return this;
    }

    public LoginPage checkSuccessLogin() {
        enterCredentialsIntoFields("username", "password", "user_desc");
        waitElementToBeVisible(loginButton).click();
        waitElementToBeVisible(successLoggedInMessage);
        return this;
    }

    public LoginPage checkLoginWithInvalidCredentials() {
        enterCredentialsIntoFields("invalid_data", "invalid_data", "user_desc");
        waitElementToBeVisible(loginButton).click();
        waitElementToBeVisible(incorrectCredentialsMessage);
        return this;
    }

    public LoginPage checkLogout() {
        waitElementToBeVisible(logoutButton).click();
        waitElementToBeVisible(usernameInput);
        return this;
    }

    public LoginPage clearAllFieldsOrLogout() {
        if (elementIsVisible(usernameInput)) {
            usernameInput.clear();
            passwordInput.clear();
            usernameDiscInput.clear();
        } else {
            checkLogout();
        }
        return this;
    }
}
