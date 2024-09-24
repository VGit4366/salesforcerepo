package pageMethods;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import pageLocators.BasePage;
import pageLocators.MyProfilePageElements;
import pageLocators.MySettingsPageElements;
import tests.BaseTest;
import utils.WaitUtils;

public class Landingpage extends BasePage {
	public static WebDriver driver;
	
	public Landingpage(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[2]")
	public WebElement mySettings;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	public WebElement devConsole;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	WebElement iframeAboutTab;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	WebElement aboutTab;
	
	@FindBy(xpath = "//*[@id='userNav-menuItems']/a[3]")
	WebElement contactTab;
	
	public void verifyUserMenuDropDwn(WebDriver driver) {
		int n = userMenuOptions.size();
		userMenu.click();
		
		for(int i=1;i<=n;i++) {
			String xpath = "//*[@id='userNav-menuItems']/a["+i+"]";
			WebElement w = driver.findElement(By.xpath(xpath));
			Assert.assertTrue(w.isDisplayed());
		}
	}

	public boolean isHomePage() {
		return this.communityPanel.isDisplayed();
	}

	public void clickUserMenu() {
		this.userMenu.click();
	}

	public MyProfilePageElements selectMyProfilePage(WebDriver driver) {
		this.myProfile.click();
		return new MyProfilePageElements(driver);
	}
	
	public MySettingsPageElements selectMySettingsPage(WebDriver driver) {
		this.mySettings.click();
		return new MySettingsPageElements(driver);
	}
	
	public MySettingsPageElements selectDevConsole(WebDriver driver) {
		this.devConsole.click();
		return new MySettingsPageElements(driver);
	}
	
	public boolean verifyContactIframeAvailability(WebDriver driver) {
		boolean isIframeLoaded = false;
		if (WaitUtils.explicitlyWaitForClickableElement(driver, iframeAboutTab)) {
			driver.switchTo().frame(iframeAboutTab);
			if (aboutTab.isDisplayed() && contactTab.isDisplayed()) {
				isIframeLoaded = true;
			} else {
				System.out.println("Iframe Not loaded");
			}
		}
		return isIframeLoaded;
	}
	
	public boolean verifyDevConsoleWindow(WebDriver driver) {
		boolean isWindowLoaded = false;
			Object[] windowHandles=driver.getWindowHandles().toArray();
			driver.switchTo().window((String) windowHandles[1]);
			String title=driver.getTitle();
			if (title.equalsIgnoreCase("Developer Console")) {
				isWindowLoaded = true;
			} 
			driver.close();
		    //Switch back to the old tab or window
		    driver.switchTo().window((String) windowHandles[0]);
		return isWindowLoaded;
	}

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
