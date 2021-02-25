package spring.stepdefinitions;


import cucumber.api.java.en.Then;
import spring.pages.data.DataClass;
import spring.utils.BrowserUtil;
import spring.utils.Pages;

public class ApplicationStepDefinitions {

    @Then("Verify the streak counter is incrementing on correct selections")
    public void Verify_the_streak_counter_is_incrementing_on_correct_selections() {
        Pages pages = new Pages();
        DataClass dataClass = new DataClass();

        pages.loginPage().countingStrikes();

    }

}
