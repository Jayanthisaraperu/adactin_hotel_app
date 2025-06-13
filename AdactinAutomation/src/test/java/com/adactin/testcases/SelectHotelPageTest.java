package com.adactin.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.adactin.base.BaseClass;
import com.adactin.dataprovider.DataProviders;
import com.adactin.pageobjects.BookAHotelPage;
import com.adactin.pageobjects.LoginPage;
import com.adactin.pageobjects.SearchHotelPage;
import com.adactin.pageobjects.SelectHotelPage;

public class SelectHotelPageTest extends BaseClass{

	LoginPage loginPage;
	SearchHotelPage searchHotelPage;
	SelectHotelPage selectHotelPage;
	BookAHotelPage bookAHotelPage;

	@Parameters("browser")
	@BeforeMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void setUp(String browser) throws Exception {
		launchApp(browser);
//		loginPage = new LoginPage();
//		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch("Sydney","Hotel Creek","Standard","1 - One","17-05-2025","18-05-2025","1 - One",
//				"2 - Two");
	}
	
	@Test(groups = { "Smoke", "Sanity"},dataProvider = "Hotel", dataProviderClass = DataProviders.class)
	public void verifyTitle(String strLocation, String strHotels, String strRoomType, String strNoofRoom,
			String strCheckInDate, String strCheckOutDate, String strAdultPerRoom, String strChildPerRoom) throws Exception {
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch(strLocation,strHotels,strRoomType,strNoofRoom,
				strCheckInDate,strCheckOutDate,strAdultPerRoom,strChildPerRoom);
		String actual = selectHotelPage.getSelectHotelPagetitle();
		String expected = "Adactin.com - Select Hotel";
		Assert.assertEquals(actual, expected);
		Thread.sleep(2000);
	}
	
	@Test(groups = { "Smoke", "Sanity"},dataProvider = "Hotel", dataProviderClass = DataProviders.class)
	public void verifySelectHotelDetails(String strLocation, String strHotels, String strRoomType, String strNoofRoom,
			String strCheckInDate, String strCheckOutDate, String strAdultPerRoom, String strChildPerRoom) throws Exception {
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch(strLocation,strHotels,strRoomType,strNoofRoom,
				strCheckInDate,strCheckOutDate,strAdultPerRoom,strChildPerRoom);

		bookAHotelPage = selectHotelPage.verifyFunctionalitySelectHotel(); 
		String actual = bookAHotelPage.getUrlBookAHotel();
		String expected = "https://adactinhotelapp.com/BookHotel.php";
		Assert.assertEquals(actual, expected);
		
	}
	
	@Test(groups = { "Smoke", "Sanity", "Regression" },dataProvider = "Hotel", dataProviderClass = DataProviders.class)
	public void verifyTotalPriceTest(String strLocation, String strHotels, String strRoomType, String strNoofRoom,
			String strCheckInDate, String strCheckOutDate, String strAdultPerRoom, String strChildPerRoom) throws Exception {
		loginPage = new LoginPage();
		searchHotelPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		selectHotelPage = searchHotelPage.verifyFunctionalityOfSearch(strLocation,strHotels,strRoomType,strNoofRoom,
				strCheckInDate,strCheckOutDate,strAdultPerRoom,strChildPerRoom);
		
//		List<WebElement> table = driver.findElements(By.xpath("(//*[table])[4]//tbody//tr[2]"));
//		System.out.println("table size  "+ table.size());
//		for (WebElement tab : table) {
//			System.out.println( " table  text "+tab.getText());
//			
////			for (WebElement webElement : table) {
////				
////			}
//
//		}
//		
		//(//*[table])[4]//tbody//tr[2]      (//*[table])[4]//tbody//tr[position() >1]
		
		
//		selectHotelPage.verifyTotalPrice();   //  (//*[table])[4]
		//  //form[@id='select_form']/table/tbody/tr[2]/td
		WebElement table = getDriver().findElement(By.xpath("(//*[table])[4]//tbody"));
		List <WebElement> rows = table.findElements(By.tagName("tr"));	
		System.out.print("Total Rows="+rows.size());
		
		for (WebElement row : rows) {
		
			List <WebElement> cols = row.findElements(By.tagName("td"));	
			System.out.print("\nToatal Cols  ="+cols.size());

			for (WebElement col : cols) {
					System.out.print("Column Value="+col.getText());
					System.out.println();
					String cellText = col.getText();
	             
					
				}
				System.out.println();
		}
	}
	
	
	@AfterMethod(groups = { "Smoke", "Sanity", "Regression" })
	public void tearDown() {
		getDriver().quit();
	}

}
