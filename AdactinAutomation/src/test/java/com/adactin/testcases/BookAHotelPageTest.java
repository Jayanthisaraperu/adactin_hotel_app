package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

	@BeforeMethod
	public void setUp() throws Exception {
		launchApp();
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch("Sydney","Hotel Creek","Standard","1 - One","17-05-2025","18-05-2025","1 - One",
				"2 - Two");
		bookAHotelPage = selectHotelPage.verifyFunctionalitySelectHotel(); 
	}
	
	@Test
	public void verifyTitle() {
		String actual = bookAHotelPage.getTitleBookAHotel();
		String expected = "Adactin.com - Book A Hotel";
		Assert.assertEquals(actual, expected);
		
	}
	
	
	@Test(dataProvider = "BookAHotel", dataProviderClass = DataProviders.class)
	public void verifyBookAHotelDetails(String firstName, String lastName, String address, String  ccardno, String ccardtype,
 										String month,  String year, String cvv) throws Exception {
		bookingConfirmationPage = bookAHotelPage.verifyFunctionalityBookHote(firstName, lastName, address, ccardno, ccardtype, month, year, cvv  );
		String actual = bookingConfirmationPage.getBookingConfirmationPageUrl();
//		String expected = "https://adactinhotelapp.com/BookHotel.php";
		String expected = "https://adactinhotelapp.com/BookingConfirm.php";
		Assert.assertEquals(actual, expected);
		//   https://adactinhotelapp.com/BookingConfirm.php
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
