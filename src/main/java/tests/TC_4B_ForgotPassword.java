package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageMethods.BaseClass;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;

//TC_4B Forgot password: Validate error message
public class TC_4B_ForgotPassword extends BaseTest {
Loginpage lp;
Logoutpage lo;

By userName = By.xpath("//input[@id='username']");
By passWd = By.xpath("//input[@id='password']");
By loginBtn = By.xpath("//input[@id='Login']");
By errMsg = By.xpath("//*[@id='error']");

	@Test()
	public void verifyForgotPwdErrorMsg() {
		lp = new Loginpage(getBrowser());
		getBrowser().findElement(userName).sendKeys(prop.getProperty("wronguser"));
		getBrowser().findElement(passWd).sendKeys(prop.getProperty("wrongpwd"));
		getBrowser().findElement(loginBtn).click();
		
		String errorMsg = getBrowser().findElement(errMsg).getText();
		String expected = prop.getProperty("loginerrmsg");
		Assert.assertEquals(errorMsg, expected);
	}
}
