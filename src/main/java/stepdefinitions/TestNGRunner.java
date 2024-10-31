package stepdefinitions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
	//Runner file changes
	@CucumberOptions(glue = "stepdefinitions", 
	features = "src/main/java/features", monochrome = true, 
	plugin = {"pretty","html:target/reports.html"}, tags = "@test and not @regression",
	dryRun = true)
	public class TestNGRunner extends AbstractTestNGCucumberTests{
	
	}
