package pageLocators;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.WaitUtils;

public class AccountsPageElements extends BasePage{
	public AccountsPageElements(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElement accountsLink;

	@FindBy(xpath = "//*[@id='fcf']/option[2]")
	public WebElement accountsOption;
	
	@FindBy(xpath = "//*[@id='filter_element']/div/span/span[1]/input")
	public WebElement goBtn;
	
	@FindBy(xpath = "//input[@value='New Account']")
	public WebElement newAcctBtn;
	
	@FindBy(xpath = "//*[@id='acc2']")
	public WebElement acctNameTxtBox;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	public WebElement saveAcctBtn;
	
	@FindBy(xpath="//*[@id='contactHeaderRow']/div[2]/h2")
	public WebElement acctPageHdr;
	
	public void createAcct() {
		acctNameTxtBox.sendKeys("test account");
		saveAcctBtn.click();
	}
	
	public void verifyAcctPageTitle() {
		String hdr = acctPageHdr.getText();
		System.out.println("Account Created: Page title ======>>>>> "+hdr);
		Assert.assertEquals(hdr, "test account");
	}
	
	public AccountsPageElements selectMyaccounts(WebDriver driver) {
		Select myAcct = new Select(driver.findElement(By.id("fcf")));
		myAcct.selectByValue("00Bbm00000Acf1k");  //value for selecting: My Accounts
		return new AccountsPageElements(driver);
	}
	
	public void clickNewAcct(WebDriver driver) {
		WaitUtils.explicitlyWaitForClickableElement(driver, this.newAcctBtn);
		this.newAcctBtn.click();
	}
	
	public void clickAcctsLink() {
		this.accountsLink.click();
	}
	
	public void clickGoBtn() {
		this.goBtn.click();
	}
	
	public void createNewAccount() {
		acctNameTxtBox.sendKeys("");
	}

}
