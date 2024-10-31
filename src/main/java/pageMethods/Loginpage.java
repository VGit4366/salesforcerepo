package pageMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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

@FindBy(id = "Login")
public WebElement loginButton;

@FindBy(xpath = "//input[@id='username']")
public WebElement username;

@FindBy(id = "password")
public WebElement password;

@FindBy(how = How.ID, using = "error")
public WebElement errorMessage;

	
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
	
	public void enterUsername(String usernm) {
		this.username.sendKeys(usernm);
		logger.debug("Username is entered");
	}
	
	public void enterPassword(String passWord) {
		this.password.sendKeys(passWord);
		logger.debug("password is entered");
	}
	
	public String getErrorMessage() {
		logger.debug("Error message is fetched");
		return this.errorMessage.getText();
	}
	
	public void clickLogin() {
		this.loginButton.click();
		logger.debug("Logging button clicked");
	}

}