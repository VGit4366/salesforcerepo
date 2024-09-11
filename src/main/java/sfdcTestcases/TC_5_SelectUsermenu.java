package sfdcTestcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import basicScripts.Loginpage;

//TC_5_Select user menu drop down
public class TC_5_SelectUsermenu extends Loginpage {

	public TC_5_SelectUsermenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		//Loginpage logon = new Loginpage();
		//CommonMethods cm = new CommonMethods();
		
		driver.get("https://login.salesforce.com/");
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='username']"));
		//userName.sendKeys(logon.getUser());
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		//password.sendKeys(logon.getPwd());
		WebElement loginBtn = driver.findElement(By.xpath("//input[@id='Login']"));	
		loginBtn.click();
		Thread.sleep(3000);
		WebElement userNav = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		userNav.click();
		WebElement myProf = driver.findElement(By.xpath("//a[contains(text(), 'My Profile')]"));
		//cm.verifyTextElement(myProf, "My Profile");
		myProf.isDisplayed();
		WebElement mySettings = driver.findElement(By.xpath("//a[contains(text(), 'My Settings')]"));
		//cm.verifyTextElement(mySettings, "My Settings");
		mySettings.isDisplayed();
		WebElement devConsole = driver.findElement(By.xpath("//a[contains(text(), 'Developer Console')]"));
		//cm.verifyTextElement(devConsole, "Developer Console");
		devConsole.isDisplayed();
		WebElement switchExp = driver.findElement(By.xpath("//*[@id=\"userNav-menuItems\"]/a[4]"));
		//cm.verifyTextElement(switchExp, "Switch to Lightning Experience");
		switchExp.isDisplayed();
		WebElement logOut = driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		//cm.verifyTextElement(logOut, "Logout");
		logOut.isDisplayed();
		
		driver.quit();
		
	}

}
