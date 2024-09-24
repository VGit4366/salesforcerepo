package hackathonTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class amazonEcomm {
	public static WebDriver driver;
	
	static By searchTxtBox = By.xpath("//input[@id='twotabsearchtextbox']");
	
	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	      driver.get("https://amazon.in");
	      Thread.sleep(10000);
	      driver.findElement(searchTxtBox).sendKeys("kindle");
	      driver.findElement(searchTxtBox).sendKeys(Keys.ENTER);
	      WebElement selectProduct = driver.findElement(By.xpath("//*[@id=\"a-autoid-1-announce\"]")); 
	      selectProduct.click();
	      WebElement cartElement = driver.findElement(By.xpath("//span[@id='nav-cart-count']"));
	      cartElement.click();
	      WebElement productTitle = driver.findElement(By.xpath("//*[@id=\"sc-active-0889a10c-4661-4952-bafa-8cb37575ec47\"]//span[contains(text(),'Amazon Kindle Paperwhite')]"));
	      String productName= productTitle.getText();
	      String expected = "Amazon Kindle Paperwhite (16 GB) – Now with a larger display,…";
	      System.out.println("Product name: "+productName);
	      Assert.assertEquals(productName, expected);
	      driver.quit();
	}

}
