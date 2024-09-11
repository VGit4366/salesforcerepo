package sfdcTestcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//TC_4A_ForgotPassword: Tests forgot password link to verify reset pwd page is displayed
public class TC_4A_ForgotPassword {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		//CommonMethods cm = new CommonMethods();
		//Loginpage logon = new Loginpage();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://login.salesforce.com/");

		WebElement forgotPwd = driver.findElement(By.id("forgot_password_link"));
		//cm.click(forgotPwd);
		
		String t = driver.getTitle();
		String expected = "Forgot Your Password | Salesforce";
		if(t.equalsIgnoreCase(expected))
			System.out.println("User is in Forgot Password page");
		
		//Enter email ID to reset password
		WebElement reEnterUserNm = driver.findElement(By.id("un"));
		//cm.sendKeys(reEnterUserNm, logon.getUser());
		WebElement continueBtn = driver.findElement(By.xpath("//input[@id=\"continue\"]"));
		//cm.click(continueBtn);
		
		WebElement message = driver.findElement(By.xpath("//*[@id=\"forgotPassForm\"]/div/p[1]"));
		String expected_msg = "We’ve sent you an email with a link to finish resetting your password.";
		//cm.verifyTextElement(message, expected_msg);

		String pagetitle = driver.getTitle();
		String exp = "Check Your Email | Salesforce";
		//cm.verifyMsgStrings(pagetitle, exp);
		
		driver.quit();

	}

}
