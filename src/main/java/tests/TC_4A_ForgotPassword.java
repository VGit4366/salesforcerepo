package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageMethods.BaseClass;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;

//TC_4A_ForgotPassword: Tests forgot password link to verify reset pwd page is displayed
public class TC_4A_ForgotPassword extends BaseTest {
	Loginpage lp;
	Logoutpage lo;
	
	By reEnterUserNm = By.id("un");
	By continueBtn = By.xpath("//input[@id='continue']");
	By forgotPwdMsg = By.xpath("//*[@id='forgotPassForm']/a");
	By forgotPwd = By.id("forgot_password_link");
	
	@Test()
	public void verifyForgotPwdLink() throws InterruptedException {
		lp = new Loginpage(getBrowser());
		lo = new Logoutpage();

		getBrowser().findElement(forgotPwd).click();
		String t = getBrowser().getTitle();
		String expected = prop.getProperty("forgotpwdtitle");
		Assert.assertEquals(t, expected);
		
		//Enter email ID to reset password
		getBrowser().findElement(reEnterUserNm).sendKeys(prop.getProperty("wronguser"));
		getBrowser().findElement(continueBtn).click();
		Thread.sleep(2000);
	
		Assert.assertTrue(getBrowser().findElement(forgotPwdMsg).isDisplayed());
		String pagetitle = getBrowser().getTitle();
		String exp = prop.getProperty("resetpwdpagetitle");
		Assert.assertEquals(pagetitle, exp);
	}

}
