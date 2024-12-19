package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.way2automation.LoginPage;

import static common.DriverFactory.createDriver;
import static org.testng.AssertJUnit.assertFalse;
import static util.PropertiesUtil.getProp;

public class Steps {
    protected WebDriver driver = createDriver();
    protected Actions actions = new Actions(driver);
    protected LoginPage loginPage = new LoginPage(driver, actions);

    @Before
    public void setUp() {
        driver.get(getProp("login_page"));
    }

    @Given("Login button is disabled")
    public void loginButtonIsDisabled() {
        loginPage.waitElementToBeVisible(loginPage.getDisabledLoginButton());
    }

    @When("User enters username password and username description")
    public void userEntersUsernamePasswordAndUsernameDescription() {
        loginPage.enterCredentialsIntoFields("username", "password", "user_desc");
    }

    @Then("Login button become active")
    public void loginButtonBecomeActive() {
        assertFalse(loginPage.elementIsVisible(loginPage.getDisabledLoginButton()));
    }

    @Given("User enters valid username password and username description")
    public void userEntersValidUsernamePasswordAndUsernameDescription() {
        loginPage.enterCredentialsIntoFields("username", "password", "user_desc");
    }

    @When("User click login button")
    public void userClickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("Authorisation is successful")
    public void authorisationIsSuccessful() {
        loginPage.successLoginMessageAppears();
    }

    @Then("Incorrect credentials message appears")
    public void incorrectCredentialsMessageAppears() {
        loginPage.incorrectCredentialsMessageAppears();
    }

    @Given("User enters invalid {string} {string} and username description")
    public void userEntersInvalidUsernamePasswordAndUsernameDescription(String username, String password) {
        loginPage.enterCredentialsIntoFields(username, password, "user_desc");
    }

    @When("User click logout button")
    public void userClickLogoutButton() {
        loginPage.waitElementToBeVisible(loginPage.getLogoutButton()).click();
    }

    @Then("Login page opens")
    public void loginPageOpens() {
        loginPage.waitElementToBeVisible(loginPage.getDisabledLoginButton());
    }

    @After
    public void tearDown() {
        if (Boolean.parseBoolean(getProp("close_browser"))) {
            driver.quit();
        }
    }
}
