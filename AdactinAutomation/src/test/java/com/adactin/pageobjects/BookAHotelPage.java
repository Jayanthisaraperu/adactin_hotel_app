package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class BookAHotelPage extends BaseClass{

	Action action = new Action(); 
	
	@FindBy (id="hotel_name_dis")
	WebElement hotelname;
	
	@FindBy (id="location_dis")
	WebElement location;
	
	@FindBy (id="room_type_dis")
	WebElement room_type;
	
	@FindBy (id="room_num_dis")
	WebElement nos_of_rooms;
	
	@FindBy (id="total_days_dis")
	WebElement total_days;
	
	@FindBy (id="price_night_dis")
	WebElement price_per_night;
	
	@FindBy (id="total_price_dis")
	WebElement total_price;
	
	@FindBy (id="gst_dis")
	WebElement gst;
	
	@FindBy (id="final_price_dis")
	WebElement final_billed_price;
	
	@FindBy (id="first_name")
	WebElement txt_firstname;
	
	@FindBy (id="last_name")
	WebElement txt_lastname;
	
	@FindBy (id="address")
	WebElement billing_address;
	
	@FindBy (id="cc_num")
	WebElement credit_card_no;
	
	@FindBy (id="cc_type")
	WebElement dropdown_credit_card_type;
	
	@FindBy (id="cc_exp_month")
	WebElement dropdown_expiry_date_month;
	
	@FindBy (id="cc_exp_year")
	WebElement dropdown_expiry_date_year;
	
	@FindBy (id="cc_cvv")
	WebElement cvv_no;
	
	@FindBy (id="book_now")
	WebElement button_book_now;
	
	@FindBy (id="cancel")
	WebElement button_cancel;
	
	public BookAHotelPage() {

		PageFactory.initElements(driver, this);
	}
	public void selectMonth(String month) {
		action.selectByVisibleText( month , dropdown_expiry_date_month);

	}
	public void selectCreditCardType(String cctype) {
		action.selectByVisibleText( cctype , dropdown_credit_card_type);

	}
	
	public void selectYear(String year) {
		action.selectByVisibleText( year , dropdown_expiry_date_year);

	}
	
	public String getUrlBookAHotel() {
		return action.getCurrentURL(driver);
	}
	
	public String getTitleBookAHotel() {
		return action.getTitle(driver);
	}
	
	
	public BookingConfirmationPage verifyFunctionalityBookHote(String firstName, String lastName, String address, String ccardno, String ccardtype,
			 			String monthh,  String year, String cvv ) throws Exception {
		action.type(txt_firstname, firstName);
		action.type(txt_lastname, lastName);
		action.type(billing_address, address);
		action.type(credit_card_no, ccardno);
		action.selectByVisibleText(ccardtype, dropdown_credit_card_type);
		action.selectByVisibleText(monthh, dropdown_expiry_date_month);
		Thread.sleep(2000);

		action.selectByVisibleText(year, dropdown_expiry_date_year);
		action.type(cvv_no, cvv);
		action.scrollByVisibilityOfElement(driver, button_book_now);
		action.click(driver, button_book_now);
		Thread.sleep(10000);
		return new BookingConfirmationPage();
		
//		action.selectByVisibleText(month, monthh);
	}
}
