package spring;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import spring.stepdefinitions.MainClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features"},
        glue = {"spring.stepdefinitions"},
        tags = {"@namegame"},
        dryRun = true,
        plugin = {
                "pretty",
                "html:target/cucumber-report",
                "json:target/cucumber-report/cucumber.json",
                "junit:target/cucumber-report/cucumber-results.xml",
        }
)
@SpringBootApplication
public class ApplicationRunnerDemo implements CommandLineRunner {
	 public static void main(String[] args) {
	         SpringApplication.run(ApplicationRunnerDemo.class, args);

	 }

	 @Autowired
	 private MainClass mainClass;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("run method invoked");
		String test = mainClass.test();
		System.out.println(test);
	}
}
