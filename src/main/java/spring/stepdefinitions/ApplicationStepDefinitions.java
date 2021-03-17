package spring.stepdefinitions;

import cucumber.api.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import spring.pages.data.DataClass;
import spring.utils.BrowserUtil;
import spring.utils.Pages;

public class ApplicationStepDefinitions implements CommandLineRunner {

    @Autowired
    private MainClass mainClass;

    @Then("Verify the streak counter is incrementing on correct selections")
    public void Verify_the_streak_counter_is_incrementing_on_correct_selections() throws Exception {
        run();
        Pages pages = new Pages();
        DataClass dataClass = new DataClass();

        pages.loginPage().countingStrikes();

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running for jdbcurl: " + mainClass.test());
    }
}
