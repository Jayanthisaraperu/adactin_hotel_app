package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.dataprovider.DataProviders;
import com.adactin.pageobjects.BookAHotelPage;
import com.adactin.pageobjects.BookingConfirmationPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.SelectHotelPage;

public class BookAHotelPageTest extends BaseClass {
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;
	BookAHotelPage bookAHotelPage;
	BookingConfirmationPage bookingConfirmationPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) throws Exception {
		launchApp(browser);
//		loginPage = new LoginPage();
//		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch("Sydney", "Hotel Creek", "Standard", "1 - One",
//				"17-05-2025", "18-05-2025", "1 - One", "2 - Two");
//		bookAHotelPage = selectHotelPage.verifyFunctionalitySelectHotel();
	}

	@Test(groups = { "Smoke", "Sanity" }, dataProvider = "Hotel", dataProviderClass = DataProviders.class)
	public void verifyTitle(String strLocation, String strHotels, String strRoomType, String strNoofRoom,
			String strCheckInDate, String strCheckOutDate, String strAdultPerRoom, String strChildPerRoom)
			throws Exception {
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch(strLocation, strHotels, strRoomType, strNoofRoom,
				strCheckInDate, strCheckOutDate, strAdultPerRoom, strChildPerRoom);
		bookAHotelPage = selectHotelPage.verifyFunctionalitySelectHotel();
		String actual = bookAHotelPage.getTitleBookAHotel();
		String expected = "Adactin.com - Book A Hotel";
		Assert.assertEquals(actual, expected);

	}

	@Test(groups = { "Smoke", "Sanity",
			"Regression" }, dataProvider = "BookAHotel", dataProviderClass = DataProviders.class)
	public void verifyBookAHotelDetails(String strLocation, String strHotels, String strRoomType, String strNoofRoom,
			String strCheckInDate, String strCheckOutDate, String strAdultPerRoom, String strChildPerRoom,String firstName, String lastName, String address, String ccardno,
			String ccardtype, String month, String year, String cvv) throws Exception {
		
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch(strLocation, strHotels, strRoomType, strNoofRoom,
				strCheckInDate, strCheckOutDate, strAdultPerRoom, strChildPerRoom);
		bookAHotelPage = selectHotelPage.verifyFunctionalitySelectHotel();
		
		
		bookingConfirmationPage = bookAHotelPage.verifyFunctionalityBookHote(firstName, lastName, address, ccardno,
				ccardtype, month, year, cvv);
		
		
		
		String actual = bookingConfirmationPage.getBookingConfirmationPageUrl();
//		String expected = "https://adactinhotelapp.com/BookHotel.php";
		String expected = "https://adactinhotelapp.com/BookingConfirm.php";
		Assert.assertEquals(actual, expected);
		// https://adactinhotelapp.com/BookingConfirm.php
	}

	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

}
