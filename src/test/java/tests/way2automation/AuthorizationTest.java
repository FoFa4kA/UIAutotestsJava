package tests.way2automation;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import tests.base.BaseTest;
import util.LoginDataProviders;

import static util.PropertiesUtil.getProp;

public class AuthorizationTest extends BaseTest {

    @BeforeTest
    public void setUp() {
        driver.get(getProp("login_page"));
    }

    @Epic(value = "Страница авторизации")
    @Feature(value = "Авторизация")
    @Story(value = "Попытка авторизации с невалидными данными")
    @Test(dataProvider = "Invalid data for login", dataProviderClass = LoginDataProviders.class)
    public void checkLoginWithInvalidData(String username, String password, String description) {
        loginPage.enterCredentialsIntoFields(username, password, description)
                .clickLoginButton()
                .incorrectCredentialsMessageAppears();
    }

    @Epic(value = "Страница авторизации")
    @Feature(value = "Авторизация")
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
