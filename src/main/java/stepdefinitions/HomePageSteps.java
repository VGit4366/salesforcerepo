package stepdefinitions;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps {

	@Given("Step1")
	public void step1() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@When("Step2")
	public void step2() {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("Step3")
	public void step3(DataTable dataTable) {
		Map<String, String> m = dataTable.asMap();
		
		List<String> al = dataTable.asList();
		
		for(String s:al) {
			System.out.println(s);
		}
	}
}
