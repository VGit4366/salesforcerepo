package pageLocators;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MySettingsPageElements extends BasePage{

	public MySettingsPageElements(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id='PersonalInfo']") 
	public WebElement personalInfo;
	
	@FindBy(xpath = "//*[@id='LoginHistory_font']")
	public WebElement loginHistory;
	
	@FindBy(xpath = "//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement downloadLoginHist;
	
	
	public void clickPersonalInfo() {
		this.personalInfo.sendKeys(Keys.ENTER);
	}
	
	public void clickLoginHistory() {
		this.loginHistory.sendKeys(Keys.ENTER);
	}
	
	public void clickDownloadHistory() {
		this.downloadLoginHist.sendKeys(Keys.ENTER);
	}
}
