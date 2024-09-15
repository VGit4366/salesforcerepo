package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import testData.FileConstants;

public class CommonUtils {

	public static String getTimeStamp() {
		return new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	}
	
	public static String captureScreenshot(WebDriver driver) {
		String filePath = FileConstants.SCREENSHOTS_FOLDER_PATH;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(filePath);
		src.renameTo(dst);
		return filePath;
	}
	
	@DataProvider(name="validAccounts")
	public Object loginTestDataValid() {
		//to read user accounts logic
		return new Object[][] { {"varsha.kommuri5@gmail.com", "12345" }, { "murthy.varsha@gmail.com", "12345"} };
	}
}
