package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.pageobjects.BookedItineraryPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;

public class BookedItineraryPageTest extends BaseClass {
	
	LoginPage loginPage;
	BookedItineraryPage bookedItineraryPage;
	SearchHotelPage searchHotelPage;
	
	@BeforeMethod
	public void setUp() throws Exception {
		launchApp();
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		bookedItineraryPage = searchHotelPage.verifyThefunctionalityOfBookedItinerary();

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verifySearchHotel() throws Exception {

		System.out.println("Inside bookedItineraryPage");
		searchHotelPage = 	bookedItineraryPage.verifySearchHotelPage();
		String actual = searchHotelPage.getCurrUrlSearchHotelPage();
		String expected = "https://adactinhotelapp.com/SearchHotel.php";
		Assert.assertEquals(actual, expected);
	}
	

}
