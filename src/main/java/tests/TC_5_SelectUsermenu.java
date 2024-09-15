package tests;

import org.testng.annotations.Test;

import pageMethods.BaseClass;
import pageMethods.Landingpage;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;

//TC_5_Select user menu drop down
public class TC_5_SelectUsermenu extends BaseTest {
Loginpage lp;
Landingpage landingpage;
Logoutpage lo;

		@Test()
		public void verifyUserMenuDropDown() {
		lp = new Loginpage(getBrowser());
		landingpage = new Landingpage(getBrowser());
		lp.userLogin(prop.getProperty("username"), prop.getProperty("password"));
		landingpage.verifyUserMenuDropDwn();
	}

}
