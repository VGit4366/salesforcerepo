package pageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import tests.BaseTest;

public class Logoutpage extends BaseTest {

	By logoutBtn = By.xpath("//*[@id='userNav-menuItems']/a[5]");

	public void logOutUser() {
		getBrowser().findElement(logoutBtn).click();
	}
}
