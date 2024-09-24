package utils;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Function;

public class WaitUtils {

	public static boolean explicitlyWaitForVisibility(WebDriver driver, WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean isElementClickable = false;
		try {
			wait.until(ExpectedConditions.visibilityOf(elementToWait));
			isElementClickable = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}

	public static boolean explicitlyWaitForInVisibility(WebDriver driver, WebElement elementToWait) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		boolean isElementInVisible = false;
		try {
			wait.until(ExpectedConditions.invisibilityOf(elementToWait));
			isElementInVisible = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementInVisible;

	}

	public static boolean explicitlyWaitForClickableElement(WebDriver driver, WebElement elementToWait) {
		boolean isElementClickable = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
			isElementClickable = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isElementClickable;
	}

	public static void fluentlyWait(WebDriver driver, final WebElement elementToWait) {
		Wait<WebDriver> fWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(2000));
		WebElement ele = fWait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return elementToWait;
			}
		});
	}
	
}
