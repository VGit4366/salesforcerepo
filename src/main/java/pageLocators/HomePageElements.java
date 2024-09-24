package pageLocators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageElements extends BasePage {
	
	public HomePageElements(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='Community']")
	public WebElement communityPanel;

	@FindBy(id = "userNavButton")
	public WebElement userMenu;

	@FindBy(xpath = "//*[@id='userNav-menuItems']/a")
	public List<WebElement> userMenuOptions;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[1]")
	public WebElement myProfile;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	public WebElement devConsole;
	
	@FindBy(xpath = "//*[@id='AllTab_Tab']")
	public WebElement allTabBtn;

	public boolean isHomePage() {
		return this.communityPanel.isDisplayed();
	}

	public void clickUserMenu() {
		this.userMenu.click();
	}
	
	public void clickAllTabsBtn() {
		this.allTabBtn.click();
	}

	public MyProfilePageElements selectMyProfilePage(WebDriver driver) {
		this.myProfile.click();
		return new MyProfilePageElements(driver);
	}

	/**
	 * This function will verify user menu options
	 * @return boolean true if all options are verified
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean verifyUserMenuOptions() throws FileNotFoundException, IOException {
		boolean isUserMenuOptionsVerified = true;
		String[] expectedUserMenuOptions = utils.FileUtils.readHomePropertiesFile("usermenu.options").split(",");
		for (int i = 0; i < expectedUserMenuOptions.length; i++) {
			if (expectedUserMenuOptions[i].equals(userMenuOptions.get(i).getText())) {
				System.out.println(
						"Expected: " + expectedUserMenuOptions[i] + " Actual: " + userMenuOptions.get(i).getText());
			} else {
				isUserMenuOptionsVerified = false;
			}
		}
		return isUserMenuOptionsVerified;
	}
}
