package stepdefinitions;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageMethods.Landingpage;
import pageMethods.Loginpage;
import tests.BaseTest;

public class LoginSteps extends BaseTest{

	WebDriver driver;
	Loginpage lp;
	
	@Before("@regression")
	public void setup() {
		System.out.println("Only for regression");
	}
	
	@After(value = "@test")
	public void tearDown() {
		driver.close();
	}
	
	@Given("I landed on login page of sfdc")
	public void i_landed_on_login_page_of_sfdc() {
		WebDriver driver = getDriver("chrome", false);
		lp = new Loginpage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com");
	}

	@When("I enter valid username")
	public void i_enter_valid_username() {
		lp.enterUsername("varsha.kommuri5@gmail.com");
	}

	@When("enter valid password")
	public void enter_valid_password() {
		lp.enterPassword("Rainbow@2033");
	}

	@When("clicked on login button")
	public void clicked_on_login_button() {
		lp.clickLogin();
	}

	@Then("I should be taken to homepage")
	public void i_should_be_taken_to_homepage() {
		Landingpage hp = new Landingpage(driver);
		Assert.assertTrue(hp.isHomePage());
	}
	
	@When("I enter invalid username")
	public void i_enter_invalid_username() {
		lp.enterUsername("mith@xyz.com");
	}

	@When("enter invalid password")
	public void enter_invalid_password() {
		lp.enterPassword("2344xyx");
	}
	
	@Then("I should be seeing error message")
	public void i_should_be_seeing_error_message() {
		String actualError = lp.getErrorMessage();
		String expectedError = "";
		Assert.assertTrue(actualError.equals(expectedError));
	}
	
	@Given("I want go to {string}")
	public void i_want_go_to_https_login_salesforce_com(String url) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(url);
	}

	@When("I enter {string} and {string}")
	public void i_enter_mitun_and_mit1234(String username, String pass) {
		System.out.println(username+" passwprd is: "+pass);
	}

	@Then("I click on the login button")
	public void i_click_on_the_login_button() {
	}
}
