package pageLocators;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public static Logger logger = LogManager.getLogger("BasePage");
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
