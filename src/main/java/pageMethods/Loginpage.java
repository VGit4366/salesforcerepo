package pageMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.BaseTest;

public class Loginpage extends BaseTest {

	public static WebDriver driver;
	
	public Loginpage(WebDriver dr) {
		this.driver = dr;
	}

By userName = By.xpath("//input[@id='username']");
By passWd = By.xpath("//input[@id='password']");
By loginBtn = By.xpath("//input[@id='Login']");
By loginErrorMsg = By.xpath("//div[@id='error']");
By userMenu = By.xpath("//*[@id='userNav']");

	
	public void userLogin(String uname, String pass) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(userName).sendKeys(uname);
		driver.findElement(passWd).sendKeys(pass);
		driver.findElement(loginBtn).click();
	}
	
	public String getElementText() throws InterruptedException {
		WebElement ele = driver.findElement(loginErrorMsg);
		while(!ele.isDisplayed()) {
			ele.wait(2000);
		}
		String eleText = driver.findElement(loginErrorMsg).getText().trim();
		return eleText;
	}
	
	public String getUserMenuTitle() {
		WebElement ele = driver.findElement(userMenu);
		String strTitle = ele.getAttribute("title");
		return strTitle;
	}

}