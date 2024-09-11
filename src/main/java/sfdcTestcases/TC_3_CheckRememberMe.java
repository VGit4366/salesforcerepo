package sfdcTestcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicScripts.BaseClass;
import basicScripts.Loginpage;
import basicScripts.Logoutpage;

//TC_3_CheckRememberMe: Tests the remember username check box on login page
public class TC_3_CheckRememberMe extends BaseClass {
	Loginpage lp;
	Logoutpage lo;
	
	By chkRememberMe = By.xpath("//input[@id='rememberUn']");
	By dropdwnBtn = By.xpath("//div[@id='userNav-arrow']");
	By userId = By.xpath("//span[@id='idcard-identity']");
	
	@Test()
	public void verifyRememberMeCheckBox() {
		lp = new Loginpage(driver);
		lo = new Logoutpage();
		driver.findElement(chkRememberMe).click();
		lp.userLogin(prop.getProperty("username"), prop.getProperty("password"));
		driver.findElement(dropdwnBtn).click();
		lo.logOutUser();	
		String userNm = driver.findElement(userId).getText();		
		String expected = prop.getProperty("username");
		Assert.assertEquals(userNm, expected);
	}

}
