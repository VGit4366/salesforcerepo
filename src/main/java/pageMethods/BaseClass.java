package pageMethods;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebElement;

public class BaseClass {
	public Properties prop;
	
	public void readFileConfig() throws IOException {
		prop = new Properties();
		FileInputStream fs = new FileInputStream(
				"C:\\Users\\varsh\\July2024_JavaClass\\SeleniumAutomationFrameworkJuly24\\src\\main\\java\\testData\\logindata.properties");
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
