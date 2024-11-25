package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static util.PropertiesUtil.getProp;

@Feature(value = "Страница авторизации")
public class LoginPageTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(getProp("login_page"));
    }


    @Story(value = "Поля ввода и кнопка 'Login'")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkInputsAndLoginButton() {
        loginPage.checkInputsAndLoginButtonDisabled();
    }

    @Story(value = "Успешная авторизация")
    @Severity(value = SeverityLevel.BLOCKER)
    @Test
    public void checkSuccessLogin() {
        loginPage.checkSuccessLogin();
    }

    @Story(value = "Авторизация с невалидными данными")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkLoginWithInvalidCredentials() {
        loginPage.checkLoginWithInvalidCredentials();
    }

    @Story(value = "Выход из аккаунта")
    @Severity(value = SeverityLevel.CRITICAL)
    @Test
    public void checkLogout() {
        loginPage.checkSuccessLogin()
                .checkLogout();
    }

    @AfterMethod
    public void clearAllFieldsOrLogout() {
        loginPage.clearAllFieldsOrLogout();
    }
}
