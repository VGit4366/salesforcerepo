package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ListenersSFDC;
import pageLocators.AccountsPageElements;
import pageLocators.HomePageElements;
import pageLocators.OpportunitiesPageElements;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;
import utils.FileUtils;

@Listeners(ListenersSFDC.class)
public class OpportunitiesPageTests extends BaseTest {
	Loginpage lp;
	OpportunitiesPageElements op;
	HomePageElements hp;
	AccountsPageElements ap;
	Logoutpage lo;
	
	//@Test()
	@Ignore
	public void verifyOpportunitiesDropDown() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifyOpportunitiesDropDown: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyOpportunitiesDropDown: User logged in");
		test.get().info("User logged in");
		hp = new HomePageElements(driver);
		hp.clickAllTabsBtn();
		logger.info("verifyOpportunitiesDropDown: All tabs is selected");
		Thread.sleep(2000);
		op = new OpportunitiesPageElements(driver);
		op.clickOppsLink();
		Thread.sleep(2000);
		Assert.assertTrue((op.verifyOpportunitiesOptions()));
		logger.info("verifyOpportunitiesDropDown: All Opportunities drop down options verified");
		test.get().info("Completed");
	}
	
	@Test()
	//@Ignore
	public void verifyNewOppoCreation() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		String oppoName = utils.FileUtils.readOpportunitiesDataPropertiesFile("oname");
		String oppoStage = utils.FileUtils.readOpportunitiesDataPropertiesFile("ostage");
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifyNewOppoCreation: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyNewOppoCreation: User logged in");
		test.get().info("User logged in");
		hp = new HomePageElements(driver);
		hp.clickAllTabsBtn();
		logger.info("verifyNewOppoCreation: All tabs is selected");
		Thread.sleep(2000);
		op = new OpportunitiesPageElements(driver);
		op.clickOppsLink();
		logger.info("verifyNewOppoCreation: Opportunities option is selected");
		Thread.sleep(2000);
		op.clickNewOppoLink();
		op.createNewOppo(driver, oppoName, oppoStage);
		logger.info("verifyNewOppoCreation: New opportunity is created");
		Thread.sleep(2000);
		op.deleteOppo(driver, oppoName);
		logger.info("verifyNewOppoCreation: New opportunity created successfully");
		test.get().info("Completed");
	}
}
