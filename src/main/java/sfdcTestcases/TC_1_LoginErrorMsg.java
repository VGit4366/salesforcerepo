package sfdcTestcases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicScripts.BaseClass;
import basicScripts.Loginpage;

//Verify error message for an invalid login
public class TC_1_LoginErrorMsg extends BaseClass {
	Loginpage lp;
	 
	By userName = By.xpath("//input[@id='username']");
	By passWd = By.xpath("//input[@id='password']");
	By loginBtn = By.xpath("//input[@id='Login']");
	
	@Test()
	public void verifyLoginErrorMsg() throws InterruptedException {
		lp = new Loginpage(driver);
		driver.findElement(userName).sendKeys(prop.getProperty("username"));
		driver.findElement(passWd).sendKeys(prop.getProperty("wrongpwd"));
		driver.findElement(loginBtn).click();
		Thread.sleep(2000);
		String errText = lp.getElementText();
		String expected = prop.getProperty("loginerrmsg");
		Assert.assertEquals(errText, expected);
	}
}
