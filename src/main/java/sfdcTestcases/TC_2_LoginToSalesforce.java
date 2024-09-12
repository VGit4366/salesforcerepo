package sfdcTestcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicScripts.BaseClass;
import basicScripts.Loginpage;

//Verify successful login to salesforce application
public class TC_2_LoginToSalesforce extends BaseClass {
	Loginpage lp;
	
	@Test()
	public void verifyLoginToSalesforce() {
		lp = new Loginpage(driver);
		lp.userLogin(prop.getProperty("username"), prop.getProperty("password"));
		String userText = lp.getUserMenuTitle();
		String expected = "User menu for Varsha Kommuri";
		Assert.assertEquals(userText, expected);
	}
}
