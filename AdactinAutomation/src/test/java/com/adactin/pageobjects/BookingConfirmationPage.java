package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class BookingConfirmationPage extends BaseClass{

	Action action = new Action();
	@FindBy (id="order_no")
	WebElement order_no;
	
	@FindBy (id="search_hotel")
	WebElement button_search_hotel;
	
	@FindBy (id="my_itinerary")
	WebElement button_my_itinerary;
	
	@FindBy (id="logout")
	WebElement button_logout;
	
	public BookingConfirmationPage() {

		PageFactory.initElements(driver, this);
	}
	
	public String getBookingConfirmationPageUrl() {
		return action.getCurrentURL(driver);
	}
	
	public boolean verifyBookingConfirmationPage() {
		return action.isDisplayed(driver, order_no);
		
	}
}
