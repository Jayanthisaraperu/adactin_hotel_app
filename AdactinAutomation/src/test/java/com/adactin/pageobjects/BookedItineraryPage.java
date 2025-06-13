package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class BookedItineraryPage extends BaseClass{
	
	Action action = new Action();
	
	@FindBy (xpath="//a[contains(text(),'Search Hotel')]")
	WebElement link_search_hotel;
	
	@FindBy (xpath="//a[contains(text(),'Booked Itinerary')]")
	WebElement link_booked_itinerary;
	
	public BookedItineraryPage() {
	
		PageFactory.initElements(getDriver(), this);
	}
	
	//     //a[contains(text(),'Search Hotel')]
	
	public String getBookedItineraryPageUrl() {
		return action.getCurrentURL(getDriver());
	}
	
	public SearchHotelPage verifySearchHotelPage() throws Exception {
		link_search_hotel.click();
		Thread.sleep(2000);
		return new SearchHotelPage();
	}

	
}
