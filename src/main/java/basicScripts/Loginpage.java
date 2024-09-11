package basicScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage extends BaseClass {
	WebDriver driver;
	
	public Loginpage(WebDriver driver) {
		this.driver = driver;
	}

By userName = By.xpath("//input[@id='username']");
By passWd = By.xpath("//input[@id='password']");
By loginBtn = By.xpath("//input[@id='Login']");
By loginErrorMsg = By.xpath("//div[@id='error']");
By userMenu = By.xpath("//*[@id='userNav']");

	
	public void userLogin(String uname, String pass) {
		driver.findElement(userName).sendKeys(uname);
		driver.findElement(passWd).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
	
	public String getElementText() {
		String eleText = driver.findElement(loginErrorMsg).getText().trim();
		return eleText;
	}
	
	public String getUserMenuTitle() {
		WebElement ele = driver.findElement(userMenu);
		String strTitle = ele.getAttribute("title");
		return strTitle;
	}

}