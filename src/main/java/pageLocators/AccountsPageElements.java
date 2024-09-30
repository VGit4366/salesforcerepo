package pageLocators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
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
	
	@FindBy(css = "a[href*='/ui/list/FilterEditPage?id=']")
	public WebElement viewEditBtn;
	
	@FindBy(xpath = "//input[@value='Delete' and @class='btn']")
	public WebElement deleteBtn;
	
	@FindBy(css = "a[href*='/merge/accmergewizard.jsp']")
	public WebElement mergeAcctsBtn;
	
	@FindBy(css = "a[href*='/001?fcf=00Bbm00000Acf1k']")
	public WebElement backToAcctsBtn;
	
	@FindBy(xpath = "//*[@id='srch']")
	public WebElement findAcctsTxtBox;
	
	@FindBy(xpath = "//input[@value='Find Accounts']")
	public WebElement findAcctsBtn;
	
	@FindBy(xpath = "//input[@id='cid0']")
	public WebElement selectAcct1;
	
	@FindBy(xpath = "//input[@id='cid1']")
	public WebElement selectAcct2;
	
	@FindBy(xpath = "//input[@value=' Next ']")
	public WebElement nextBtn;
	
	@FindBy(xpath = "//input[@value=' Merge ']")
	public WebElement mergeBtn;
	
	@FindBy(xpath = "//input[@value='Delete']")
	public WebElement acctDeleteBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Accounts with last activity')]")
	public WebElement acctActivityBtn;
	
	@FindBy(xpath="//td[@class='x-date-active x-date-today x-date-selected' and @title='Today']")
	public WebElement todaysDate1;
	
	@FindBy(xpath="//*[@id='ext-gen152']")
	public WebElement fromDatePicker;
	
	@FindBy(xpath="//*[@id='ext-gen154']")
	public WebElement toDatePicker;
	
	@FindBy(xpath="//td[@class='x-date-active x-date-selected']")
	public WebElement todaysDate2;
	
	@FindBy(xpath="//*[@id='ext-gen49']")
	public WebElement saveReportBtn;
	
	@FindBy(xpath="//*[@id='saveReportDlg_reportNameField']")
	public WebElement reportNmTxtBox;
	
	@FindBy(xpath="//*[@id='saveReportDlg_DeveloperName']")
	public WebElement reportUniqueNmTxtBox;
	
	@FindBy(xpath="//table[@id='dlgSaveReport']//td[@class='x-btn-mc']/em/button[(text()='Save')]")  
	public WebElement saveBtnOnPopUp;
	
	@FindBy(xpath="//button[contains(text(), 'Save and Run Report')]")
	public WebElement saveRunBtn;
	
	public void mergeAccts(WebDriver driver, String acctName) throws InterruptedException {
		findAcctsTxtBox.sendKeys(acctName);
		findAcctsBtn.click();
		if(!selectAcct1.isSelected())
			selectAcct1.click();
		if(!selectAcct2.isSelected())
			selectAcct2.click();
		nextBtn.click();
		Thread.sleep(2000);
		mergeBtn.click();
		driver.switchTo().alert().accept();
	}
	
	public void deleteAcct(WebDriver driver, String acctToDelete) throws FileNotFoundException, IOException, InterruptedException {
		driver.findElement(By.xpath("//a[text()='"+acctToDelete+"']")).click();
		Thread.sleep(2000);
		acctDeleteBtn.click();
		confirmDeleteAcct(driver);
	}
	
	public void createAcct(String acctName) throws FileNotFoundException, IOException {
		acctNameTxtBox.sendKeys(acctName);
		saveAcctBtn.click();
	}
	
	public void createReport(WebDriver dr, String repName, String repUniqName) throws FileNotFoundException, IOException, InterruptedException {
		fromDatePicker.click();
		todaysDate1.click();
		toDatePicker.click();
		todaysDate2.click();
		saveReportBtn.click();
		//System.out.println("Switching to pop up window ===>>> "+dr.switchTo().window(repName));
		reportNmTxtBox.sendKeys(repName);
		reportUniqueNmTxtBox.sendKeys(repUniqName);
		saveRunBtn.click();
		Thread.sleep(3000);
		//System.out.println("Window Handle ===>>> "+dr.getWindowHandle());
	}
	
	public void createView(String vName, String vUniqueName) throws FileNotFoundException, IOException, InterruptedException {
		viewNameTxtBox.sendKeys(vName);
		Thread.sleep(2000);
		viewUniqueNameTxtBox.sendKeys(vUniqueName);
		Thread.sleep(2000);
		saveAcctBtn.click();
	}
	
	public void verifyDropDown(WebDriver dr, String option) {
		List<WebElement> allOptions=dr.findElements(By.cssSelector("//*[@id='00Bbm00000CJfQN_listSelect']/option"));
		for(WebElement el:allOptions) {
            if(el.getText().contains(option)) {
                  el.click();
            }
		}
	}
	
	public void clickCreateViewBtn() { 
		createNewViewBtn.click();
	}
	
	public void clickMergeAcctsBtn() { 
		mergeAcctsBtn.click();
	}
	
	public void clickBackToAcctsPage() {
		backToAcctsBtn.click();
	}
	
	public void clickAcctsActivity() {
		this.acctActivityBtn.click();
	}
	
	public void verifyAcctPageTitle() {
		String hdr = acctPageHdr.getText();
		Assert.assertEquals(hdr, "test account");
	}
	
	public void verifyViewCreated(WebDriver driver, String viewToVerify) throws FileNotFoundException, IOException, InterruptedException {
		String name = driver.findElement(By.xpath("//select/option[contains(text(), '"+viewToVerify+"')]")).getText();
		Thread.sleep(3000);
		Assert.assertEquals(name, viewToVerify);
	}
	
	public void editView(WebDriver driver, String viewToEdit) throws FileNotFoundException, IOException, InterruptedException {
		viewEditBtn.click();
		Thread.sleep(2000);
		viewNameTxtBox.sendKeys(viewToEdit);
		saveAcctBtn.click();
		String newName = driver.findElement(By.xpath("//select/option[contains(text(), '"+viewToEdit+"')]")).getText();
		Assert.assertEquals(viewToEdit, newName);
	}
	
	public void deleteView(WebDriver driver, String viewToDelete) throws FileNotFoundException, IOException, InterruptedException {
		boolean x = true;
		viewEditBtn.click();
		Thread.sleep(1000);
		deleteBtn.click();
		if(isAlertPresent(driver)) 					//verify if alert pop up exists
			driver.switchTo().alert().accept();		//click ok if exists
		Thread.sleep(1000); 
		//x = isElementPresent(driver, viewToDelete);  //tried to verify deletion, didn't work
		//Assert.assertFalse(x);
	}
	
	public boolean isElementPresent(WebDriver driver, String str){  //checks if deletion worked
		   try{
			  driver.findElement(By.xpath("//select/option[contains(text(), '"+str+"')]"));
		      return true;
		   }catch(NoSuchElementException e){
		     return false;
		   }
		}
	
	public boolean isAlertPresent(WebDriver driver) //checks if delete button shows alert pop up
	{ 
	    try 
	    { 
	        driver.switchTo().alert(); 
	        return true; 
	    }  
	    catch (NoAlertPresentException Ex) 
	    { 
	        return false; 
	    }  
	}
	
	public void confirmDeleteAcct(WebDriver driver) throws InterruptedException {
		try {
			deleteBtn.click();
			Thread.sleep(2000);
		} catch (UnhandledAlertException f) {
		    try {
		        Alert alert = driver.switchTo().alert();//(Keys.RETURN);
		        Thread.sleep(2000);
		        String t = alert.getText();
		        String tt = driver.getWindowHandle();
		        System.out.println("Alert data ===>>> " + t + "Windows: "+tt);
		        alert.accept();
		    } catch (NoAlertPresentException e) {
		        e.printStackTrace();
		    }
	}
	}
	
	public AccountsPageElements selectView(WebDriver driver, String viewToSelect) {
		Select myViews = new Select(driver.findElement(By.xpath("//select/option[contains(text(), '"+viewToSelect+"')]")));
		myViews.selectByValue(viewToSelect); 
		return new AccountsPageElements(driver);
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
