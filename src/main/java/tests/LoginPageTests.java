package tests;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import listeners.ListenersSFDC;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;
import utils.FileUtils;

@Listeners(ListenersSFDC.class)
public class LoginPageTests extends BaseTest {
	Loginpage lp;
	Logoutpage lo;
	Properties driver = new Properties();
	 
	By userName = By.xpath("//input[@id='username']");
	By passWd = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='Login']");
	By errMsg = By.xpath("//*[@id='error']");
	
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
		test.get().info("Completed");
		logger.info("verifyLoginErrorMsg: Finished");
	}
	
	@Test()
	public void verifyLoginToSalesforce() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifyLoginToSalesforce: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		test.get().info("User logged in");
		String userText = lp.getUserMenuTitle();
		String expected = "User menu for Varsha Kommuri";
		Assert.assertEquals(userText, expected);
		logger.info("verifyLoginToSalesforce: Finished");
		test.get().info("Completed");
	}
	
	By chkRememberMe = By.xpath("//input[@id='rememberUn']");
	By dropdwnBtn = By.xpath("//div[@id='userNav-arrow']");
	By userId = By.xpath("//span[@id='idcard-identity']");
	
	@Test()
	public void verifyRememberMeCheckBox() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		lo = new Logoutpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifyRememberMeCheckBox: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(3000);
		driver.findElement(chkRememberMe).click();
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		driver.findElement(dropdwnBtn).click();
		logger.info("verifyRememberMeCheckBox: Drop down is clicked");
		lo.logOutUser();	
		test.get().info("User logged out");
		String userNm = driver.findElement(userId).getText();		
		String expected = FileUtils.readLoginPropertiesFile("username");
		Assert.assertEquals(userNm, expected);
		logger.info("verifyRememberMeCheckBox: Finished");
		test.get().info("Completed");
	}
	
	By reEnterUserNm = By.id("un");
	By continueBtn = By.xpath("//input[@id='continue']");
	By forgotPwdMsg = By.xpath("//*[@id='forgotPassForm']/a");
	By forgotPwd = By.id("forgot_password_link");
	
	@Test()
	public void verifyForgotPwdLink() throws InterruptedException, FileNotFoundException, IOException {	
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		lo = new Logoutpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		Thread.sleep(3000);
		logger.info("verifyForgotPwdLink: Browser launched");
		test.get().info("Browser launched");
		driver.findElement(forgotPwd).click();
		String t = driver.getTitle();
		String expected = FileUtils.readLoginPropertiesFile("forgotpwdtitle");
		Assert.assertEquals(t, expected);
		test.get().info("Verify forgot pwd page title");
		logger.info("verifyForgotPwdLink: Forgot pwd page is displayed");
		//Enter email ID to reset password
		driver.findElement(reEnterUserNm).sendKeys(FileUtils.readLoginPropertiesFile("wronguser"));
		driver.findElement(continueBtn).click();
		Thread.sleep(2000);
		logger.info("verifyForgotPwdLink: Re-entered email ID for pwd reset");
		test.get().info("Re-entered email Id for password reset");
		Assert.assertTrue(driver.findElement(forgotPwdMsg).isDisplayed());
		String pagetitle = driver.getTitle();
		String exp = FileUtils.readLoginPropertiesFile("resetpwdpagetitle");
		Assert.assertEquals(pagetitle, exp);
		logger.info("verifyForgotPwdLink: Finished");
		test.get().info("Completed");
	}
	
	@Test()
	public void verifyForgotPwdErrorMsg() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		lo = new Logoutpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		test.get().info("Browser launched");
		Thread.sleep(3000);
		logger.info("verifyForgotPwdErrorMsg: Browser launched");
		lp = new Loginpage(getBrowser());
		driver.findElement(userName).sendKeys(FileUtils.readLoginPropertiesFile("wronguser"));
		driver.findElement(passWd).sendKeys(FileUtils.readLoginPropertiesFile("wrongpwd"));
		driver.findElement(loginBtn).click();
		logger.info("verifyForgotPwdErrorMsg: Login attempted");
		test.get().info("Login attempted, error message verified");
		String errorMsg = driver.findElement(errMsg).getText();
		String expected = FileUtils.readLoginPropertiesFile("loginerrmsg");
		Assert.assertEquals(errorMsg, expected);
		logger.info("verifyForgotPwdErrorMsg: Login error message verified");
		logger.info("verifyForgotPwdErrorMsg: Finished");
		test.get().info("Completed");
	}
		
}

