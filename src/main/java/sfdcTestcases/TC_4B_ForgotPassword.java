package sfdcTestcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TC_4B Forgot password: Validate error message
public class TC_4B_ForgotPassword {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		//CommonMethods cm = new CommonMethods();
		//Loginpage logon = new Loginpage();
		driver.get("https://login.salesforce.com/");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		//userName.sendKeys(logon.getWrongUser());
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		//password.sendKeys(logon.getWrongPwd());
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='Login']"));	
		loginBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement errMsg = driver.findElement(By.xpath("//*[@id=\"error\"]"));
		String errorMsg = errMsg.getText();
		String expected = "Please check your username and password. If you still can't log in, contact your Salesforce administrator.";
		//cm.verifyMsgStrings(errorMsg, expected);
		
		driver.quit();

	}

}
