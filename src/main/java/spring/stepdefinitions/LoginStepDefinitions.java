package spring.stepdefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import spring.utils.Pages;

public class LoginStepDefinitions {

    Pages pages = new Pages();

    @When("User is lands on the {string}")
    public void user_is_lands_on_the(String string) {
        pages.loginPage().goToLandingPage();
    }


}
