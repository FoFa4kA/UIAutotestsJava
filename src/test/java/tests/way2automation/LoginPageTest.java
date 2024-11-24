package tests.way2automation;

import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

public class LoginPageTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(getProp("login_page"));
    }

    @Epic(value = "Страница авторизации")
    @Feature(value = "Форма авторизации")
    @Story(value = "Поля ввода и кнопка 'Login'")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkInputsAndLoginButton() {
        loginPage.checkInputsAndLoginButtonDisabled();
    }

    @Epic(value = "Страница авторизации")
    @Feature(value = "Авторизация")
    @Story(value = "Успешная авторизация")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkSuccessLogin() {
        loginPage.enterCredentialsIntoFields("username", "password", "user_desc")
                .clickLoginButton()
                .successLoginMessageAppears();
    }

    @Epic(value = "Страница авторизации")
    @Feature(value = "Авторизация")
    @Story(value = "Авторизация с невалидными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkLoginWithInvalidCredentials() {
        loginPage.enterCredentialsIntoFields("invalid_data", "invalid_data", "user_desc")
                .clickLoginButton()
                .incorrectCredentialsMessageAppears();
    }

    @Epic(value = "Страница авторизации")
    @Feature(value = "Авторизация")
    @Story(value = "Выход из аккаунта")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkLogout() {
        loginPage.enterCredentialsIntoFields("username", "password", "user_desc")
                .clickLoginButton()
                .successLoginMessageAppears()
                .checkLogout();
    }

    @AfterMethod
    public void clearAllFieldsOrLogout() {
        loginPage.clearAllFieldsOrLogout();
    }
}
