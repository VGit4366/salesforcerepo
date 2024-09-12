package sfdcTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicScripts.BaseClass;
import basicScripts.Loginpage;
import basicScripts.Logoutpage;

//TC_4A_ForgotPassword: Tests forgot password link to verify reset pwd page is displayed
public class TC_4A_ForgotPassword extends BaseClass {
	Loginpage lp;
	Logoutpage lo;
	
	By reEnterUserNm = By.id("un");
	By continueBtn = By.xpath("//input[@id='continue']");
	By forgotPwdMsg = By.xpath("//*[@id='forgotPassForm']/a");
	By forgotPwd = By.id("forgot_password_link");
	
	@Test()
	public void verifyForgotPwdLink() throws InterruptedException {
		lp = new Loginpage(driver);
		lo = new Logoutpage();

		driver.findElement(forgotPwd).click();
		String t = driver.getTitle();
		String expected = prop.getProperty("forgotpwdtitle");
		Assert.assertEquals(t, expected);
		
		//Enter email ID to reset password
		driver.findElement(reEnterUserNm).sendKeys(prop.getProperty("wronguser"));
		driver.findElement(continueBtn).click();
		Thread.sleep(2000);
	
		Assert.assertTrue(driver.findElement(forgotPwdMsg).isDisplayed());
		String pagetitle = driver.getTitle();
		String exp = prop.getProperty("resetpwdpagetitle");
		Assert.assertEquals(pagetitle, exp);
	}

}
