package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.pageobjects.BookedItineraryPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;

public class BookedItineraryPageTest extends BaseClass {
	
	LoginPage loginPage;
	BookedItineraryPage bookedItineraryPage;
	SearchHotelPage searchHotelPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) throws Exception {
		launchApp(browser);
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		bookedItineraryPage = searchHotelPage.verifyThefunctionalityOfBookedItinerary();

	}
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups = {"Smoke", "Sanity"})
	public void verifySearchHotel() throws Exception {

		System.out.println("Inside bookedItineraryPage");
		searchHotelPage = 	bookedItineraryPage.verifySearchHotelPage();
		String actual = searchHotelPage.getCurrUrlSearchHotelPage();
		String expected = "https://adactinhotelapp.com/SearchHotel.php";
		Assert.assertEquals(actual, expected);
	}
	

}
