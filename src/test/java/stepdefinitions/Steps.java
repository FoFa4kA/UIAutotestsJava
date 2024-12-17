package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    @Given("User opens login page {string}")
    public void userOpensLoginPage(String loginPage) {

    }

    @When("user enters username as {string}, password as {string} and username description as {string}")
    public void userEntersCredentials(String username, String password, String userDesc) {

    }

    @Then("login button become active")
    public void loginButtonBecomeActive() {

    }
}
