package tests.way2automation;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.way2automation.LoginPage;
import tests.base.BaseTest;
import util.LoginDataProviders;

import static util.PropertiesUtil.getProp;

@Feature(value = "Авторизация")
public class AuthorizationTest extends BaseTest {
    protected LoginPage loginPage = new LoginPage(driver, actions);

    @BeforeTest
    public void setUp() {
        driver.get(getProp("login_page"));
    }

    @Story(value = "Попытка авторизации с невалидными данными")
    @Test(priority = 1, dataProvider = "Invalid data for login", dataProviderClass = LoginDataProviders.class)
    public void checkLoginWithInvalidData(String username, String password, String description) {
        loginPage.enterCredentialsIntoFields(username, password, description)
                .clickLoginButton()
                .incorrectCredentialsMessageAppears();
    }

    @Story(value = "Авторизация с валидными данными")
    @Test(dataProvider = "Valid data for login", dataProviderClass = LoginDataProviders.class)
    public void checkLoginWithValidData(String username, String password, String description) {
        loginPage.enterCredentialsIntoFields(username, password, description)
                .clickLoginButton()
                .successLoginMessageAppears();
    }

    @AfterMethod
    public void clearAllFieldsOrLogout() {
        loginPage.clearAllFieldsOrLogout();
    }
}
