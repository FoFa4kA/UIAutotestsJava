package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.way2automation.LoginPage;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

@Feature(value = "Страница авторизации")
public class LoginPageTests extends BaseTest {
    protected LoginPage loginPage = new LoginPage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("login_page"));
    }


    @Story(value = "Поля ввода и кнопка 'Login'")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkInputsAndLoginButtonTest() {
        loginPage.checkInputsAndLoginButtonDisabled();
    }

    @Story(value = "Успешная авторизация")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkSuccessLoginTest() {
        loginPage.enterCredentialsIntoFields("username", "password", "user_desc")
                .clickLoginButton()
                .successLoginMessageAppears();
    }

    @Story(value = "Авторизация с невалидными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkLoginWithInvalidCredentialsTest() {
        loginPage.enterCredentialsIntoFields("invalid_data", "invalid_data", "user_desc")
                .clickLoginButton()
                .incorrectCredentialsMessageAppears();
    }

    @Story(value = "Выход из аккаунта")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkLogoutTest() {
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
