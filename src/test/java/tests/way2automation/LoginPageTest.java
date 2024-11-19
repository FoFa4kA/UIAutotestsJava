package tests.way2automation;

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

    @Test
    public void checkInputsAndLoginButton() {
        loginPage.checkInputsAndLoginButtonDisabled();
    }

    @Test
    public void checkSuccessLogin() {
        loginPage.checkSuccessLogin();
    }

    @Test
    public void checkLoginWithInvalidCredentials() {
        loginPage.checkLoginWithInvalidCredentials();
    }

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
