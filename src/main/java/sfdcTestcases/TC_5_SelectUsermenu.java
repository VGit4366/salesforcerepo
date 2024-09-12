package sfdcTestcases;

import org.testng.annotations.Test;

import basicScripts.BaseClass;
import basicScripts.Landingpage;
import basicScripts.Loginpage;
import basicScripts.Logoutpage;

//TC_5_Select user menu drop down
public class TC_5_SelectUsermenu extends BaseClass {
Loginpage lp;
Landingpage landingpage;
Logoutpage lo;

		@Test()
		public void verifyUserMenuDropDown() {
		lp = new Loginpage(driver);
		landingpage = new Landingpage(driver);
		lp.userLogin(prop.getProperty("username"), prop.getProperty("password"));
		landingpage.verifyUserMenuDropDwn();
	}

}
