package tests;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.ListenersSFDC;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;
import utils.FileUtils;

//Verify error message for an invalid login
@Listeners(ListenersSFDC.class)
public class LoginPageTests extends BaseTest {
	Loginpage lp;
	Logoutpage lo;
	Properties prop = new Properties();
	 
	By userName = By.xpath("//input[@id='username']");
	By passWd = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='Login']");
	
	@Test()
	public void verifyLoginErrorMsg() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifyLoginErrorMsg: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(2000);
		driver.findElement(userName).sendKeys(FileUtils.readLoginPropertiesFile("username"));
		driver.findElement(passWd).sendKeys(FileUtils.readLoginPropertiesFile("wrongpwd"));
		driver.findElement(loginBtn).click();
		test.get().info("Login button clicked");
		logger.info("verifyLoginErrorMsg: Login successful");
		Thread.sleep(2000);
		String errText = lp.getElementText();
		String expected = FileUtils.readLoginPropertiesFile("loginerrmsg");
		Assert.assertEquals(errText, expected);
		logger.info("verifyLoginErrorMsg: Finished");
	}
	
	@Test()
	public void verifyLoginToSalesforce() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		String userText = lp.getUserMenuTitle();
		String expected = "User menu for Varsha Kommuri";
		Assert.assertEquals(userText, expected);
	}
	
	By chkRememberMe = By.xpath("//input[@id='rememberUn']");
	By dropdwnBtn = By.xpath("//div[@id='userNav-arrow']");
	By userId = By.xpath("//span[@id='idcard-identity']");
	
	@Test()
	public void verifyRememberMeCheckBox() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		lo = new Logoutpage();
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		Thread.sleep(3000);
		driver.findElement(chkRememberMe).click();
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		driver.findElement(dropdwnBtn).click();
		lo.logOutUser();	
		String userNm = driver.findElement(userId).getText();		
		String expected = FileUtils.readLoginPropertiesFile("username");
		Assert.assertEquals(userNm, expected);
	}
}

