package com.adactin.pageobjects;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class SearchHotelPage extends BaseClass {

	Action action = new Action();

	@FindBy(xpath = "//a[contains(text(),'Search Hotel')]")
	WebElement link_search_hotel;

	@FindBy(xpath = "//a[contains(text(),'Booked Itinerary')]")
	WebElement link_booked_itinerary;

	@FindBy(xpath = "//a[contains(text(),'Change Password')]")
	WebElement link_change_password;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement link_logout;

	@FindBy(id = "location")
	WebElement dropdown_location;

	@FindBy(id = "hotels")
	WebElement dropdown_hotels;

	@FindBy(id = "room_type")
	WebElement dropdown_roomtype;

	@FindBy(id = "room_nos")
	WebElement dropdown_nos_of_rooms;

	@FindBy(id = "datepick_in")
	WebElement txt_check_in_date;

	@FindBy(id = "datepick_out")
	WebElement txt_check_out_date;

	@FindBy(id = "adult_room")
	WebElement dropdown_adults_per_room;

	@FindBy(id = "child_room")
	WebElement dropdown_children_per_room;

	@FindBy(id = "Submit")
	WebElement button_search;

	@FindBy(id = "Reset")
	WebElement button_reset;

//	@FindBy (xpath="//table[@class='login']//td[2]")
//	WebElement search_hotel_table;

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	public String getSearchHotelPageTitle() {
		return driver.getTitle();
	}

	public void select_Location(String selectlocation) {
		action.selectByVisibleText(selectlocation, dropdown_location);

	}

	public void select_Hotels(String selecthotels) {
		action.selectByVisibleText(selecthotels, dropdown_hotels);

	}

	public void select_Room_Type(String selectroomtype) {
		action.selectByVisibleText(selectroomtype, dropdown_roomtype);

	}

	public void select_No_Of_Rooms(String selectnoofrooms) {
		action.selectByVisibleText(selectnoofrooms, dropdown_nos_of_rooms);

	}

	public void select_Adults_Per_Room(String selectadults) {
		action.selectByVisibleText(selectadults, dropdown_adults_per_room);

	}

	public void select_Children_Per_Room(String selectchildren) {
		action.selectByVisibleText(selectchildren, dropdown_children_per_room);

	}

	public void enter_Check_In_Date(String chkInDate) {
//		 
//		String current =  action.getCurrentTime();
//		if(chkInDate.equals(current))
//		{
		action.type(txt_check_in_date, chkInDate);
//		}
	}

	public void enter_Check_Out_Date(String chkOutDate) {
		action.type(txt_check_out_date, chkOutDate);
	}

//	public SelectHotelPage clickSearchButton() {
//		action.click(driver, button_search);
//		return new SelectHotelPage();
//	}

	public void clickReset() {
		action.click(driver, button_reset);
	}

	public String getCurrUrlSearchHotelPage() {
		String searchHotelPageUrl = driver.getCurrentUrl();
		return searchHotelPageUrl;
	}

	public SelectHotelPage verifyFunctionalityOfSearch(String strLocation, String strHotels, String strRoomType,
			String strNoofRoom, String strCheckInDate, String strCheckOutDate, String strAdultPerRoom,
			String strChildPerRoom) throws Exception {
		action.selectByVisibleText(strLocation, dropdown_location);
		action.selectByVisibleText(strHotels, dropdown_hotels);
		action.selectByVisibleText(strRoomType, dropdown_roomtype);
		action.selectByVisibleText(strNoofRoom, dropdown_nos_of_rooms);

//        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
//        String  enteredDate = strCheckInDate;
//        System.out.println("enteredDate  "+enteredDate);
//        String current =  action.getCurrentTime();
//        System.out.println("current  "+current);
//        Date a = sd.parse(enteredDate);
//        Date b = sd.parse(current);
//        
		// Checking for equal case
//        if (a.equals(b))
//            System.out.println("Both dates are of same day");
//        String enterCurrentDate = a.toString();
//		action.type(txt_check_in_date, enterCurrentDate);

//		System.out.println("Current Date"+ current);
//		if(strCheckInDate.equals(current)){
//		
		action.type(txt_check_in_date, strCheckInDate);
//		}
//		else {
//			System.out.println("Enter Current Date");
//		}
		action.type(txt_check_out_date, strCheckOutDate);
		action.selectByVisibleText(strAdultPerRoom, dropdown_adults_per_room);
		action.selectByVisibleText(strChildPerRoom, dropdown_children_per_room);
		action.click(driver, button_search);
		Thread.sleep(5000);
		return new SelectHotelPage();

	}

	public boolean verifyDisplayOfSearchHotelPageLocation() {
		return dropdown_location.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageHotels() {
		return dropdown_hotels.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageRoomType() {
		return dropdown_roomtype.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageNoOfRooms() {
		return dropdown_nos_of_rooms.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageChkinDate() {
		return txt_check_in_date.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageChkOutDate() {
		return txt_check_out_date.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageAdultsPerRoom() {
		return dropdown_adults_per_room.isDisplayed();

	}

	public boolean verifyDisplayOfSearchHotelPageChildrenPerRoom() {
		return dropdown_children_per_room.isDisplayed();

	}

	public BookedItineraryPage verifyThefunctionalityOfBookedItinerary() throws Exception {
		link_booked_itinerary.click();
		Thread.sleep(5000);
		return new BookedItineraryPage();

	}

	public ChangePasswordPage verifyThefunctionalityOfChangePassword() throws Exception {
		link_change_password.click();
		Thread.sleep(2000);
		return new ChangePasswordPage();

	}

	public LogoutPage verifyThefunctionalityOfLogout() throws Exception {
		link_logout.click();
		Thread.sleep(2000);
		return new LogoutPage();

	}

	public void verifyListOffieldDislayedTestdata() {
		List<WebElement> searchhotelfields = driver.findElements(By.xpath("//table[@class='login']//td[2]"));
		System.out.println(searchhotelfields.size());

		for (WebElement searchhotelfield : searchhotelfields) {
			String field = searchhotelfield.getText();
			System.out.println(field);
			
		}
	}

}
