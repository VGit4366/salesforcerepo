package sfdcTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicScripts.BaseClass;
import basicScripts.Loginpage;
import basicScripts.Logoutpage;

//TC_4B Forgot password: Validate error message
public class TC_4B_ForgotPassword extends BaseClass {
Loginpage lp;
Logoutpage lo;

By userName = By.xpath("//input[@id='username']");
By passWd = By.xpath("//input[@id='password']");
By loginBtn = By.xpath("//input[@id='Login']");
By errMsg = By.xpath("//*[@id='error']");

	@Test()
	public void verifyForgotPwdErrorMsg() {
		lp = new Loginpage(driver);
		driver.findElement(userName).sendKeys(prop.getProperty("wronguser"));
		driver.findElement(passWd).sendKeys(prop.getProperty("wrongpwd"));
		driver.findElement(loginBtn).click();
		
		String errorMsg = driver.findElement(errMsg).getText();
		String expected = prop.getProperty("loginerrmsg");
		Assert.assertEquals(errorMsg, expected);
	}
}
