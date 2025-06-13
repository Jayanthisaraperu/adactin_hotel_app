package com.adactin.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.pageobjects.BookAHotelPage;
import com.adactin.pageobjects.BookingConfirmationPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.SelectHotelPage;

public class BookingConfirmationPageTest extends BaseClass{
	
	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;
	BookAHotelPage bookAHotelPage;
	BookingConfirmationPage bookingConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void setUp(String browser) throws Exception {
		launchApp(browser);
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch("Sydney","Hotel Creek","Standard","1 - One","17-05-2025","18-05-2025","1 - One",
				"2 - Two");
		bookAHotelPage = selectHotelPage.verifyFunctionalitySelectHotel(); 
		bookingConfirmationPage = bookAHotelPage.verifyFunctionalityBookHote("test", "test", "test", "1234342345654320", "VISA", "December", "2027", "777"  );
	}
	
	@Test(groups = "Smoke")
	public void verifyverifyBookingConfirmationPageTest() {
		bookingConfirmationPage.verifyBookingConfirmationPage();
		Assert.assertTrue(true);
	}
	
	
	@AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
	public void tearDown() {
		getDriver().quit();
	}

}
