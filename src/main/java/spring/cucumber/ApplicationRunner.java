package spring.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = {"spring.stepdefinitions"},
        tags = {"@namegame"},
        dryRun = false,
        plugin = {
                "pretty",
                "html:target/cucumber-report",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber-results.xml",
        }
)
@SpringBootApplication
public class ApplicationRunner {
	/* public static void main(String[] args) { SpringApplication.run(CucumberApplication.class, args); } */
}
