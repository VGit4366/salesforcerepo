package pageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageLocators.BasePage;

public class Logoutpage extends BasePage {

	public Logoutpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
	WebElement logoutBtn;

	@FindBy(xpath = "//input[@id='Login']")
	WebElement logintBtn;
	
	public void logOutUser() {
		logoutBtn.click();
		Assert.assertTrue(logintBtn.isDisplayed());
	}
}
