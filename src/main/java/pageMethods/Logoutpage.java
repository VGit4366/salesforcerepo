package pageMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pageLocators.BasePage;

public class Logoutpage extends BasePage {

	public Logoutpage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[5]")
	WebElement logoutBtn;

	public void logOutUser() {
		logoutBtn.click();
	}
}
