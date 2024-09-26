package tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import org.openqa.selenium.By;
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
		
		static long number = new Random().nextInt(64);
		static String viewName = "viewname"+number;
		static String newViewName = viewName+" edited";
		static String viewUniqueName = Long.toString(number);
		
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
			logger.info("verifyViewCreation: Browser launched");
			test.get().info("Browser launched");
			Thread.sleep(3000);
			lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
			logger.info("verifyViewCreation: User logged in");
			test.get().info("User logged in");
			hp = new HomePageElements(driver);
			hp.clickAllTabsBtn();
			logger.info("verifyViewCreation: All tabs is selected");
			ap = new AccountsPageElements(driver);
			ap.clickAcctsLink();
			logger.info("verifyViewCreation: Accounts home page is displayed");
			Thread.sleep(2000);
			ap.clickCreateViewBtn();
			ap.createView(viewName, viewUniqueName);
			Thread.sleep(2000);
			ap.verifyViewCreated(driver, viewName);
			Thread.sleep(2000);
			ap.deleteView(driver, viewName);
			logger.info("verifyViewCreation: New account creation page is displayed");
			test.get().info("New account creation page is displayed");
			logger.info("verifyViewCreation: Finished");
			test.get().info("Completed");
		}
		
		By editBtn = By.xpath("//*[@id='00Bbm00000AcYUm_filterLinks']/a[1]");
		
		@Test()
		//@Ignore
		public void verifyEditView() throws InterruptedException, FileNotFoundException, IOException {
			WebDriver driver = getBrowser();
			lp = new Loginpage(driver);
			driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
			logger.info("verifyEditView: Browser launched");
			test.get().info("Browser launched");
			Thread.sleep(3000);
			lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
			logger.info("verifyEditView: User logged in");
			test.get().info("User logged in");
			hp = new HomePageElements(driver);
			hp.clickAllTabsBtn();
			logger.info("verifyEditView: All tabs is selected");
			ap = new AccountsPageElements(driver);
			ap.clickAcctsLink();
			logger.info("verifyEditView: Accounts home page is displayed");
			ap.clickCreateViewBtn();
			ap.createView(viewName, viewUniqueName);
			logger.info("verifyEditView: New view created");
			Thread.sleep(3000);
			ap.verifyViewCreated(driver, viewName);
			logger.info("verifyEditView: View verified");
			Thread.sleep(3000);
			ap.editView(driver, newViewName);
			logger.info("verifyEditView: View is edited");
			Thread.sleep(3000);
			ap.deleteView(driver, newViewName);
			logger.info("verifyEditView: New account creation page is displayed");
			test.get().info("New account creation page is displayed");
			logger.info("verifyEditView: Finished");
			test.get().info("Completed");
		}
	}


