package sfdcTestcases;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TC_3_CheckRememberMe: Tests the remember username check box on login page
public class TC_3_CheckRememberMe {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		userName.sendKeys("varsha.kommuri5@gmail.com");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("Rainbow@2033");
		WebElement chkRememberMe = driver.findElement(By.xpath("//input[@id=\"rememberUn\"]"));	
		chkRememberMe.click();
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='Login']"));	
		loginBtn.submit();

		WebElement dropdwnBtn = driver.findElement(By.xpath("//div[@id='userNav-arrow']"));
		dropdwnBtn.click();

		WebElement logoutBtn = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[5]"));	
		logoutBtn.click();
		Thread.sleep(3000);
		
		WebElement userId = driver.findElement(By.xpath("//span[@id='idcard-identity']"));
		String userNm = userId.getText();

		String expected = "varsha.kommuri5@gmail.com";
		if(userNm.equalsIgnoreCase(expected))
			System.out.println("User is logged out successfully");
	
		driver.quit();
	}

}
