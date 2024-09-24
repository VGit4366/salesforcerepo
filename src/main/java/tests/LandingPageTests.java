package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listeners.ListenersSFDC;
import pageLocators.MyProfilePageElements;
import pageLocators.MySettingsPageElements;
import pageMethods.Landingpage;
import pageMethods.Loginpage;
import pageMethods.Logoutpage;
import utils.FileUtils;

@Listeners(ListenersSFDC.class)
public class LandingPageTests extends BaseTest {
	Loginpage lp;
	Landingpage lpg;
	MySettingsPageElements settings;
	Logoutpage lo;

	@Test()
	public void verifySelectUserMenu() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifySelectUserMenu: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyLoginToSalesforce: User logged in");
		test.get().info("User logged in");
		lpg = new Landingpage(driver);
		lpg.verifyUserMenuDropDwn(driver);
		logger.info("verifySelectUserMenu: User Menu items are verified");
		logger.info("verifySelectUserMenu: Finished");
		test.get().info("Completed");
	}
	
	@Test
	public void verifyMyProfileOption() throws FileNotFoundException, IOException, InterruptedException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		logger.info("verifyMyProfileOption: Browser launched");
		test.get().info("Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyMyProfileOption: User logged in");
		lpg = new Landingpage(driver);
		lpg.clickUserMenu();
		Assert.assertTrue(lpg.verifyUserMenuOptions(), "User Menu options should be verified");
	    MyProfilePageElements profilePage = lpg.selectMyProfilePage(driver);
	    profilePage.clickEditProfile(driver);
	    logger.info("verifyMyProfileOption: Edit profile clicked");
	    test.get().info("Edit profile is clicked");
	    Assert.assertTrue(profilePage.verifyContactIframeAvailability(driver), "");
	    Assert.assertTrue(profilePage.verifyAboutTab(driver), "");
	    Assert.assertTrue(profilePage.verifyLastNameChange(),"");
	    Assert.assertTrue(profilePage.verifyCreatePost(driver, "This is java programming!"));
	    logger.info("verifyMyProfileOption: User post created");
	    test.get().info("User post is created");
	    Assert.assertTrue(profilePage.verifyFileUpload(driver));
	    logger.info("verifyMyProfileOption: File upload completed");
	    profilePage.clickOnAddPhoto(driver);
	    Assert.assertTrue(profilePage.verifyAddPhoto(driver));
	    logger.info("verifyMyProfileOption: Photo added and verified");
	    logger.info("verifyMyProfileOption: Finished");
	    test.get().info("Completed");
	}

	@Test()
	public void verifyMysettingsOption() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		test.get().info("Browser launched");
		logger.info("verifyMysettingsOption: Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyMysettingsOption: User logged in");
		lpg = new Landingpage(driver);
		lpg.clickUserMenu();
		logger.info("verifyMysettingsOption: User menu clicked");
		test.get().info("User Menu clicked");
		Assert.assertTrue(lpg.verifyUserMenuOptions(), "Dropdown is displayed");
		logger.info("verifyMysettingsOption: User Menu Options are visible");
		lpg.selectMySettingsPage(driver);
		settings = new MySettingsPageElements(driver);
		Thread.sleep(2000);
		//settings.clickPersonalInfo(); elements not interactable
		//settings.clickLoginHistory();  elements not interactable
		//settings.clickDownloadHistory();  elements not interactable
		Thread.sleep(5000);
		logger.info("verifyMysettingsOption: Finished");
		test.get().info("Completed");
	}
	
	@Test()
	public void verifyDevConsoleOption() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		test.get().info("Browser launched");
		logger.info("verifyDevConsoleOption: Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyDevConsoleOption: User logged in");
		lpg = new Landingpage(driver);
		lpg.clickUserMenu();
		logger.info("verifyDevConsoleOption: User menu clicked");
		test.get().info("User menu clicked");
		Assert.assertTrue(lpg.verifyUserMenuOptions(), "Dropdown is displayed");
		logger.info("verifyDevConsoleOption: User Menu Options are visible");
		lpg.selectDevConsole(driver);
		test.get().info("verifyDevConsoleOption: Developer console option is selected");
		Thread.sleep(5000);
		Assert.assertTrue(lpg.verifyDevConsoleWindow(driver));
		logger.info("verifyDevConsoleOption: Finished");
		test.get().info("Completed");
	}
	
	@Test()
	public void verifyLogout() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = getBrowser();
		lp = new Loginpage(driver);
		driver.get(FileUtils.readLoginPropertiesFile("baseURL"));
		test.get().info("Browser launched");
		logger.info("verifyLogout: Browser launched");
		Thread.sleep(3000);
		lp.userLogin(FileUtils.readLoginPropertiesFile("username"), FileUtils.readLoginPropertiesFile("password"));
		logger.info("verifyDevConsoleOption: User logged in");
		test.get().info("User logged in");
		lpg = new Landingpage(driver);
		lpg.clickUserMenu();
		lo = new Logoutpage(driver);
		lo.logOutUser();
		logger.info("verifyLogout: User log out complete");
		logger.info("verifyLogout: Finished");
		test.get().info("Completed");
	}
}
