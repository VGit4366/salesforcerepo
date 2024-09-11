package basicScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver driver;
public Properties prop;

	@BeforeClass
	public void beforeclass() throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		readFileConfig();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("baseURL"));
	}
	
	@AfterClass
	public void afterclass() {
		driver.quit();
	}
	
	public void readFileConfig() throws IOException {
		prop = new Properties();
		FileInputStream fs = new FileInputStream("C:\\Users\\varsh\\July2024_JavaClass\\SeleniumAutomationFrameworkJuly24\\src\\main\\java\\testData\\logindata.properties");
		prop.load(fs);
	}
	
	public static void sendKeysElement(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	public static void clickOnWebElement(WebElement element) {
		element.click();
	}
}
