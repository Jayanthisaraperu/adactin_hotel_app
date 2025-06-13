package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.dataprovider.DataProviders;
import com.adactin.pageobjects.ForgotPasswordFormPage;
import com.adactin.pageobjects.GooglePlayPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.NewUserRegistrationFormPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.TestingAppsWithTestFlightPage;
import com.adactin.utility.Log;
import com.beust.jcommander.Parameter;

public class LoginPageTest extends BaseClass {

	private LoginPage loginpage;
	private SearchHotelPage searchHotelPage;
	private ForgotPasswordFormPage forgotPasswordFormPage;
	private TestingAppsWithTestFlightPage testingAppsWithTestFlightPage;
	private GooglePlayPage googlePlayPage;
	private NewUserRegistrationFormPage newUserRegistrationFormPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
//		loginpage = new LoginPage();	
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups = "Smoke", enabled = true)
	public void verifyLogoTest() {
		Log.startTestCase("loginTest");
		loginpage = new LoginPage();
		boolean result = loginpage.verifyLogo();
		Log.info("Verifying Logo");
		Assert.assertTrue(result);
		Log.info("Logo Success");
		Log.endTestCase("loginTest");

	}

	@Test(groups = "Smoke")
	public void verifyTitleTest() {
		Log.startTestCase("loginTest");
		loginpage = new LoginPage();
		String actualTitle = loginpage.verifyTitle();
		Log.info("Verifying Title");
		Assert.assertEquals(actualTitle, "Adactin.com - Hotel Reservation System");
		Log.info(" Title Success");
		Log.endTestCase("loginTest");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyFunctionalityForiOSTest() throws Exception {
		Log.startTestCase("verify Functionality For iOSTest");
		loginpage = new LoginPage();
		loginpage.verifyForiOS();
		Log.info("Verify For iOS Displayed");
		Assert.assertTrue(true);
		Log.info("iOS Displayed is Success");
		testingAppsWithTestFlightPage = loginpage.verifyFunctionalityForiOS();
		String actual = testingAppsWithTestFlightPage.getTestingAppsWithTestFlightPageUrl();
		String expected = "https://testflight.apple.com/join/Ai3nVPMD";
		Log.info("Verify functionality For iOS ");
		Assert.assertEquals(actual, expected);
		Log.info("iOS Success");
		Log.endTestCase("verify Functionality ForiOS Test");

	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyFunctionalityForGooglePlayTest() throws Exception {
		Log.startTestCase("verifyFunctionalityForGooglePlayTest");
		loginpage = new LoginPage();
		loginpage.verifyGooglePlay();
		Log.info("GooglePlay is displayed");

		Assert.assertTrue(true);
		Log.info("GooglePlay Success");
		Log.info("GooglePlay  is clicked");

		googlePlayPage = loginpage.verifyFunctionalityGooglePlay();
		Log.info(" Navigates to GooglePlayPage");

		String actual = googlePlayPage.getGooglePlayPageUrl();
		String expected = "https://play.google.com/store/apps/details?id=com.adactin.education.hotelbooking";
		Log.info("Verify GooglePlayPage");

		Assert.assertEquals(actual, expected);

		Log.info(" GooglePlayPage Success");

		Log.endTestCase("verifyFunctionalityForGooglePlayTest");

	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyNewUserRegisterHereLink() {
		Log.startTestCase("verifyNewUserRegisterHereLink");
		loginpage = new LoginPage();
		loginpage.displayOfNewUserRegisterHere();
		Log.info("NewUserRegisterHereLink is displayed");
		Assert.assertTrue(true);
		Log.info("NewUserRegisterHereLink Success");
		Log.info("NewUserRegisterHereLink  is clicked");
		newUserRegistrationFormPage = loginpage.verifyNewUserRegisterHere();
		Log.info(" Navigates to NewUserRegistrationFormPage");
		String actual = newUserRegistrationFormPage.getNewUserRegistrationFormPageUrl();
		String expected = "https://adactinhotelapp.com/Register.php";
		Log.info("Verify NewUserRegistrationFormPage");
		Assert.assertEquals(actual, expected);
		Log.info("NewUserRegistrationFormPage Success");
		Log.endTestCase("verifyNewUserRegisterHereLink");

	}

	@Test(groups = { "Sanity",
			"Regression" }, dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void verifyLoginFunctionality(String uname, String pwsd) throws Exception {
		// searchHotelPage = loginpage.doLogin(prop.getProperty("username"),
		// prop.getProperty("password"));

		Log.startTestCase("loginTest");
		loginpage = new LoginPage();
		searchHotelPage = loginpage.doLogin(uname, pwsd);
		Log.info("Enters Username and Password and clicks Login button ");
		Thread.sleep(2000);
		String actualUrl = searchHotelPage.getCurrUrlSearchHotelPage();
		String expectedUrl = "https://adactinhotelapp.com/SearchHotel.php";
		Log.info("Verifying if user is able to Login ");
		Assert.assertEquals(actualUrl, expectedUrl);
		Log.info("Login is Success");
		Log.endTestCase("loginTest");
	}

	@Test(groups = { "Smoke", "Sanity" })
	public void verifyForgotPassword() {
		Log.startTestCase(" ForgotPassword Test");
		loginpage = new LoginPage();
		forgotPasswordFormPage = loginpage.verifyFunctionalityForgotPassword();
		Log.info("Click Forgor Password Link");
		String actual = forgotPasswordFormPage.getForgotPasswordFormPageUrl();
		String expected = "https://adactinhotelapp.com/ForgotPassword.php";
		Log.info("Verify ForgotPassword Link ");
		Assert.assertEquals(actual, expected);
		Log.info("ForgorPassword Success ");
		Log.endTestCase("ForgotPassword Test");
	}
}
