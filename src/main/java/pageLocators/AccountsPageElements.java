package pageLocators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utils.WaitUtils;

public class AccountsPageElements extends BasePage{
	static long number = new Random().nextLong();
	static String viewName = "viewname"+number;
	static String viewUniqueName = Long.toString(number);
	
	public AccountsPageElements(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElement accountsLink;

	@FindBy(xpath = "//*[@id='fcf']/option[2]")
	public WebElement accountsOption;
	
	@FindBy(xpath = "//input[@class='btn' and @title='Go!']")
	public WebElement goBtn;
	
	@FindBy(xpath = "//input[@value='New Account']")
	public WebElement newAcctBtn;
	
	@FindBy(xpath = "//*[@id='acc2']")
	public WebElement acctNameTxtBox;
	
	@FindBy(xpath = "//input[@value=' Save ']")
	public WebElement saveAcctBtn;
	
	@FindBy(xpath="//*[@id='contactHeaderRow']/div[2]/h2")
	public WebElement acctPageHdr;
	
	@FindBy(xpath="//*[@id='filter_element']//a[contains(text(), 'Create New View')]")
	public WebElement createNewViewBtn;
	
	@FindBy(xpath = "//*[@id='fname']")
	public WebElement viewNameTxtBox;
	
	@FindBy(xpath = "//*[@id='devname']")
	public WebElement viewUniqueNameTxtBox;
	
	@FindBy(xpath = "//*[@id='00Bbm00000CJfQN_listSelect']") 
	public WebElement viewDropdown;
	
	public void createAcct() throws FileNotFoundException, IOException {
		acctNameTxtBox.sendKeys(utils.FileUtils.readAcctDataPropertiesFile("acctname"));
		saveAcctBtn.click();
	}
	
	public void createView() throws FileNotFoundException, IOException, InterruptedException {
		viewNameTxtBox.sendKeys(viewName);
		Thread.sleep(2000);
		viewUniqueNameTxtBox.sendKeys(String.valueOf(number));
		Thread.sleep(2000);
		saveAcctBtn.click();
	}
	
	public void clickCreateViewBtn() { 
		createNewViewBtn.click();
	}
	
	public void verifyAcctPageTitle() {
		String hdr = acctPageHdr.getText();
		Assert.assertEquals(hdr, "test account");
	}
	
	public void verifyViewCreated(WebDriver driver) throws FileNotFoundException, IOException, InterruptedException {
		String name = driver.findElement(By.xpath("//select/option[contains(text(), '"+viewName+"')]")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(name, viewName);
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
	
	public void clickGoBtn(WebDriver driver) {
		List<WebElement> x = driver.findElements(By.xpath("//input[@class='btn' and @title='Go!']"));
		if (x.size() > 0) {
		  x.get(0).click();
		}
	}
}
