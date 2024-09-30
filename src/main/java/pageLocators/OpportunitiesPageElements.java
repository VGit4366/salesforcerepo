package pageLocators;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OpportunitiesPageElements extends BasePage {
	
	public OpportunitiesPageElements(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id='bodyCell']/div[3]/div[2]/table/tbody/tr[1]/td[1]/a")
	public WebElement accountsLink;

	@FindBy(xpath = "//*[@id='fcf']/option[2]")
	public WebElement accountsOption;
	
	@FindBy(xpath="//*[@id='bodyCell']//a/img[@title='Opportunities']")
	public WebElement oppLink;
	
	@FindBy(xpath="//*[@id='fcf']/option")
	public List<WebElement> oppMenuOptions;
	
	@FindBy(xpath="//input[@value=' New ' and @title='New' and @class='btn']")
	public WebElement newBtn;
	
	@FindBy(xpath="//*[@id='bottomButtonRow']/input[@class='btn' and @title='Save']")
	public WebElement oppoSaveBtn;
	
	@FindBy(id="opp3")
	public WebElement oppNameTxtBox;
	
	@FindBy(id="opp11")
	public WebElement selectStageDropDown;
	
	@FindBy(css="a[href*='DatePicker.insertDate']")
	public WebElement oppDatePicker;
	
	@FindBy(xpath="//*[@id='topButtonRow']/input[4]")
	public WebElement oppoDelBtn;
	
	@FindBy(xpath="//tr[@class='dataRow even first']/th/a[1]")
	public WebElement oppoForDelete;
	
	@FindBy(id="hoverIterm75")
	public WebElement recentNewOppo;
	
	public void clickOppsLink() {
		this.oppLink.click();
	}
	
	public void clickNewOppoLink() {
		this.newBtn.click();
	}
	
	public void deleteOppo(WebDriver driver, String oppoToDelete) throws FileNotFoundException, IOException, InterruptedException {
		//boolean x = true;
		oppoDelBtn.click();
		if(isAlertPresent(driver)) 					//verify if alert pop up exists
			driver.switchTo().alert().accept();		//click ok if exists
		Thread.sleep(1000); 
		//x = isElementPresent(driver, viewToDelete);  //tried to verify deletion, didn't work
		//Assert.assertFalse(x);
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
	
	public void createNewOppo(WebDriver driver, String oppoName, String stageToSelect) throws InterruptedException {
		oppNameTxtBox.sendKeys(oppoName);
		Thread.sleep(2000);
		oppDatePicker.click();
		Thread.sleep(2000);
		Select myStages = new Select(driver.findElement(By.id("opp11")));
		myStages.selectByValue(stageToSelect);
		Thread.sleep(2000);
		oppoSaveBtn.click();
	}
	
	public boolean verifyOpportunitiesOptions() throws FileNotFoundException, IOException {
		boolean isOpportunitiesOptionsVerified = true;
	String[] expectedOpportunitiesOptions = utils.FileUtils.readOpportunitiesDataPropertiesFile("opportunities.options").split(",");
		for (int i = 1; i < expectedOpportunitiesOptions.length; i++) {
			if (expectedOpportunitiesOptions[i].equals(oppMenuOptions.get(i).getText())) {
				System.out.println(
						"Expected: " + expectedOpportunitiesOptions[i] + " Actual: " + oppMenuOptions.get(i).getText());
			} else {
				isOpportunitiesOptionsVerified = false;
			}
		}
		return isOpportunitiesOptionsVerified;
	}	
}
