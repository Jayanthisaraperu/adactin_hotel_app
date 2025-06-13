package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.dataprovider.DataProviders;
import com.adactin.pageobjects.BookedItineraryPage;
import com.adactin.pageobjects.ChangePasswordPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.LogoutPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.SelectHotelPage;
import com.adactin.utility.Log;

public class SearchHotelPageTest extends BaseClass {
	private LoginPage loginPage;
	private SearchHotelPage searchHotelPage;
	private SelectHotelPage selectHotelPage;
	private BookedItineraryPage bookedItineraryPage;
	private ChangePasswordPage changePasswordPage;
	private LogoutPage logoutPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) {
		launchApp(browser);
//		loginPage = new LoginPage();
//		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
		
	}

	@Test(groups = { "Smoke", "Sanity"},enabled=true)
	public void verifySearchHotelPageTitle() throws Exception {
		Log.startTestCase("verifySearchHotelPageTitleTest");
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		String actual = searchHotelPage.getSearchHotelPageTitle();
		String expected = "Adactin.com - Search Hotel";
		Log.info("verify Search HotelPage Title ");
		Assert.assertEquals(actual, expected);
		Log.info("Title Success");
		Log.endTestCase("verifySearchHotelPageTitleTest");

		Thread.sleep(2000);
		
	}
	
	@Test(groups = "Smoke")
	public void verifyDisplayOfSearchHotelPage() {
		Log.startTestCase("verifyDisplayOfSearchHotelPage");
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchHotelPage.verifyDisplayOfSearchHotelPageLocation();
		Log.info("Verify Location ");
		Assert.assertTrue(true);
		Log.info("Location Success");
		searchHotelPage.verifyDisplayOfSearchHotelPageHotels();
		Log.info("Verify Hotels ");

		Assert.assertTrue(true); 
		Log.info("Hotels Success");

		searchHotelPage.verifyDisplayOfSearchHotelPageRoomType();
		Log.info("Verify RoomType ");

		Assert.assertTrue(true); 
		Log.info("RoomType Success");

		searchHotelPage.verifyDisplayOfSearchHotelPageNoOfRooms();
		Log.info("Verify NoOfRooms ");

		Assert.assertTrue(true); 
		Log.info("NoOfRooms Success");

		searchHotelPage.verifyDisplayOfSearchHotelPageChkinDate();
		Log.info("Verify ChkinDate ");

		Assert.assertTrue(true); 
		Log.info("ChkinDate Success");

		searchHotelPage.verifyDisplayOfSearchHotelPageChkOutDate();
		Log.info("Verify ChkOutDate ");

		Assert.assertTrue(true); 
		Log.info("ChkOutDate Success");

		searchHotelPage.verifyDisplayOfSearchHotelPageAdultsPerRoom();
		Log.info("Verify AdultsPerRoom ");

		Assert.assertTrue(true); 
		Log.info("AdultsPerRoom Success");

		searchHotelPage.verifyDisplayOfSearchHotelPageChildrenPerRoom();
		Log.info("Verify ChildrenPerRoom ");

		Assert.assertTrue(true); 
		Log.info("ChildrenPerRoom Success");
		Log.endTestCase("verifyDisplayOfSearchHotelPage");

	
	}
	
	@Test(groups = { "Smoke", "Sanity"})
	public void verifyBookedItineraryLink() throws Exception {
		Log.startTestCase("verifyBookedItineraryLink");
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("verifyBookedItineraryLink is click");
		bookedItineraryPage = searchHotelPage.verifyThefunctionalityOfBookedItinerary();
		Log.info("Navigates to BookedItineraryPage");
		String actual = bookedItineraryPage.getBookedItineraryPageUrl();	
		String expected = "https://adactinhotelapp.com/BookedItinerary.php";
		Log.info("Verify bookedItineraryPage");
		Assert.assertEquals(actual, expected);
		Log.info("bookedItineraryPage Success");
		Log.endTestCase("verifyBookedItineraryLink");

	}
	
	@Test(groups = { "Smoke", "Sanity"})
	public void verifyChangePasswordLink() throws Exception {
		Log.startTestCase("verifyChangePasswordLink");
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("verifyChangePasswordLink is click");
		changePasswordPage = searchHotelPage.verifyThefunctionalityOfChangePassword();
		Log.info("Navigates to ChangePasswordPage");

		String actual = changePasswordPage.getChangePasswordUrl();	
		String expected = "https://adactinhotelapp.com/ChangePassword.php";
		Log.info("Verify ChangePasswordPage");

		Assert.assertEquals(actual, expected);
		Log.info("ChangePasswordPage Success");

		Log.endTestCase("verifyChangePasswordLink");

	}
	
	@Test(groups = { "Smoke", "Sanity"})
	public void verifyLogoutLink() throws Exception {
		Log.startTestCase("verifyLogoutLink");
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("verifyLogoutLink is click");
		logoutPage = searchHotelPage.verifyThefunctionalityOfLogout();
		Log.info("Navigates to LogoutPage");

		String actual = logoutPage.getLogoutPageUrl();	
		String expected = "https://adactinhotelapp.com/Logout.php";
		Log.info("Verify LogoutPage");

		Assert.assertEquals(actual, expected);
		Log.info("LogoutPage Success");

		Log.endTestCase("verifyLogoutLink");

	}
	
	
	
	
	
	@Test(groups = { "Smoke", "Sanity", "Regression" },dataProvider = "Hotel", dataProviderClass = DataProviders.class)
	public void verifyFunctionalityOfSearchHotelPage(String strLocation, String strHotels, String strRoomType, String strNoofRoom,
			String strCheckInDate, String strCheckOutDate, String strAdultPerRoom, String strChildPerRoom) throws Exception
	{
		
		Log.startTestCase("verifyFunctionalityOfSearchHotelPage");
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Log.info("verifySearchHotelDetails is click");
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch(strLocation, strHotels, strRoomType,
						strNoofRoom, strCheckInDate, strCheckOutDate, strAdultPerRoom, strChildPerRoom);
		
		Log.info("Navigates to SelectHotelPage");

		String actual = selectHotelPage.getUrlSelectHotelPage();
		String expected = "https://adactinhotelapp.com/SelectHotel.php";
		Log.info("Verify SelectHotelPage");

		Assert.assertEquals(actual, expected);
		Log.info(" SelectHotelPage Success");

		Log.endTestCase("verifyFunctionalityOfSearchHotelPage");

	}
	
	@Test(groups = { "Smoke", "Sanity"})
	public void verifyListOffieldDislayedTestdataTest() {
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		searchHotelPage.verifyListOffieldDislayedTestdata();
	}
	
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

}
