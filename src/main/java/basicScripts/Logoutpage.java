package basicScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Logoutpage extends BaseClass {
	
	By logoutBtn = By.xpath("//*[@id='userNav-menuItems']/a[5]");


	public void logOutUser() {
		driver.findElement(logoutBtn).click();
	}
}
