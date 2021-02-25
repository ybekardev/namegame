package spring.cucumber;

import cucumber.api.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CucumberApplicationTests {


	@When("User logs on the {string} page with {string} and {string}")
	public void user_logs_on_the_page_with_and(String string, String string2, String string3) {
		log.info("Logging...");
	}
	@Test
	void contextLoads() {
	}



}
