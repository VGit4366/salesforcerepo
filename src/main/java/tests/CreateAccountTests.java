package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ListenersSFDC;
import pageLocators.AccountsPageElements;
import pageLocators.HomePageElements;
import pageLocators.MySettingsPageElements;
import pageMethods.Landingpage;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;
import utils.FileUtils;

@Listeners(ListenersSFDC.class)
public class CreateAccountTests extends BaseTest{
		Loginpage lp;
		AccountsPageElements ap;
		HomePageElements hp;
		Landingpage lpg;
		MySettingsPageElements settings;
		Logoutpage lo;
		
		//Creates new account
		@Test()
		//@Ignore
		public void verifyAccountCreation() throws InterruptedException, FileNotFoundException, IOException {
			WebDriver driver = getBrowser();
			lp = new Loginpage(driver);
			driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
			logger.info("verifyAccountCreation: Browser launched");
			test.get().info("Browser launched");
			Thread.sleep(3000);
			lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
			logger.info("verifyAccountCreation: User logged in");
			test.get().info("User logged in");
			hp = new HomePageElements(driver);
			hp.clickAllTabsBtn();
			logger.info("verifyAccountCreation: All tabs is selected");
			ap = new AccountsPageElements(driver);
			ap.clickAcctsLink();
			logger.info("verifyAccountCreation: Accounts home page is displayed");
			ap.selectMyaccounts(driver);
			test.get().info("Accounts home page is displayed");
			Thread.sleep(2000);
			ap.clickGoBtn(driver);
			Thread.sleep(2000);
			ap.clickNewAcct(driver);
			Thread.sleep(2000);
			ap.createAcct();
			Thread.sleep(2000);
			ap.verifyAcctPageTitle();
			logger.info("verifyAccountCreation: New account creation page is displayed");
			test.get().info("New account creation page is displayed");
			logger.info("verifyAccountCreation: Finished");
			test.get().info("Completed");
		}
		
		//creates new view
		@Test()
		//@Ignore
		public void verifyViewCreation() throws InterruptedException, FileNotFoundException, IOException {
			WebDriver driver = getBrowser();
			lp = new Loginpage(driver);
			driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
			logger.info("verifyAccountCreation: Browser launched");
			test.get().info("Browser launched");
			Thread.sleep(3000);
			lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
			logger.info("verifyAccountCreation: User logged in");
			test.get().info("User logged in");
			hp = new HomePageElements(driver);
			hp.clickAllTabsBtn();
			logger.info("verifyAccountCreation: All tabs is selected");
			ap = new AccountsPageElements(driver);
			ap.clickAcctsLink();
			logger.info("verifyAccountCreation: Accounts home page is displayed");
			ap.clickCreateViewBtn();
			ap.createView();
			Thread.sleep(3000);
			ap.verifyViewCreated(driver);
			logger.info("verifyAccountCreation: New account creation page is displayed");
			test.get().info("New account creation page is displayed");
			logger.info("verifyAccountCreation: Finished");
			test.get().info("Completed");
		}
	}


