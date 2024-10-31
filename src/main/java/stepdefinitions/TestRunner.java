package stepdefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

	@RunWith(Cucumber.class)
	@CucumberOptions(glue = "stepdefinitions", 
	features = "src/main/java/features", monochrome = true, 
	plugin = {"pretty","html:target/reports.html"}, tags = "@test and not @regression",
	dryRun = true)
	
	public class TestRunner {
	

	}
