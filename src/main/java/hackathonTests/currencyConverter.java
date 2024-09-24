package hackathonTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class currencyConverter {
	public static WebDriver driver;
	////span[contains(text(), 'US Dollar')]
	public static By fromArrow = By.xpath("//ul[@id='midmarketFromCurrency-listbox']");
	public static By toArrow = By.xpath("//ul[@id='midmarketToCurrency-listbox']");
	public static By convertBtn = By.xpath("//*[@id=\"__next\"]//button");
	public static By fromOptionUSD = By.xpath("//*[@id='midmarketFromCurrency-option-0']//span[contains(text(),'USD')]");
	public static By toOptionUSD = By.xpath("//*[@id='midmarketToCurrency-option-0']//span[contains(text(),'INR')]");

	public static void main(String[] args) throws InterruptedException {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
	      driver.get("https://www.xe.com/");
	      Thread.sleep(3000);
	      driver.findElement(fromArrow).click();
	      Thread.sleep(5000);
	      Select selectFrom = new Select(driver.findElement(By.xpath("fromArrow")));
	      selectFrom.selectByValue("USD");
	      driver.findElement(toArrow).click();
	      Thread.sleep(5000);
	      Select selectTo = new Select(driver.findElement(By.xpath("fromArrow")));
	      selectTo.selectByValue("INR");
	      driver.findElement(convertBtn).click();
	      Thread.sleep(3000);
	      driver.quit();
	}

}
