package pageMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Landingpage extends BaseClass {
	WebDriver driver;
	
	public Landingpage(WebDriver driver) {
		this.driver = driver;
	}
	
	By userMenuDrpDwn = By.xpath("//*[@id='userNav-menuItems']/a");
	By userNav = By.xpath("//span[@id='userNavLabel']");
	
	public void verifyUserMenuDropDwn() {
		int n = driver.findElements(userMenuDrpDwn).size();
		driver.findElement(userNav).click();
		
		for(int i=1;i<=n;i++) {
			String xpath = "//*[@id='userNav-menuItems']/a["+i+"]";
			WebElement w = driver.findElement(By.xpath(xpath));
			Assert.assertTrue(w.isDisplayed());
		}
	}
	
}
