package com.adactin.pageobjects;

import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class SelectHotelPage extends BaseClass{

	Action action = new Action();
	
	@FindBy (id="radiobutton_0")
	WebElement radiobutton;
	
	@FindBy (id="continue")
	WebElement button_continue;
	
	@FindBy (id="cancel")
	WebElement button_cancel;
	
	@FindBy (xpath="(//form[@name='select_form']/table//tr) [position()>3]")
	WebElement table;
	
	@FindBy (id="price_night_0")
	WebElement pricenight;
	
	// 		(//form[@name='select_form']/table//tr) [position()>3]
	public SelectHotelPage() {

		PageFactory.initElements(driver, this);
		
	}
	
	public String getUrlSelectHotelPage() {
	return 	driver.getCurrentUrl();
		
	}
	
	public String getSelectHotelPagetitle() {
		 return action.getTitle(driver);
	}
	
	public BookAHotelPage verifyFunctionalitySelectHotel() throws Exception {
		action.getRowCount(table);
		action.click(driver, radiobutton);
		
		action.click(driver, button_continue);
		Thread.sleep(2000);
		return new BookAHotelPage();
		
//		List<WebElement> ele = driver.findElements(By.xpath("(//form[@name='select_form']/table//tr) [position()>3]"));
		
	}
	
	public float verifyTotalPrice() {
		
		float pricepernight=0,totalprice=0;
		int noofrooms=0,noofdays=0;
		System.out.println(pricenight.getText());
		 totalprice = (pricepernight)*(noofrooms)*(noofdays);
		 return totalprice;
	}
}
