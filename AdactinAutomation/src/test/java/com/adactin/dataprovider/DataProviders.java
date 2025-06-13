package com.adactin.dataprovider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.adactin.utility.ExcelLibrary;


public class DataProviders {

	ExcelLibrary obj = new ExcelLibrary();

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider(name = "credentials")
		public Object[][] getCredentials() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet1"); // SP Changed
			// Total Columns
			int column = obj.getColumnCount("Sheet1"); // SP Changed
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet1", j, i + 2);
//					System.out.println("Data="+data[i][j].toString());
				}
			}
			return data;
		}

	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "Hotel")
		public Object[][] getEmail() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet2");
			// Total Columns
			int column = obj.getColumnCount("Sheet2");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet2", j, i + 2);
				}
			}
			return data;
		}

		
		
		@DataProvider(name = "BookAHotel")
		public Object[][] getBookAHotel() {
			// Totals rows count
			int rows = obj.getRowCount("Sheet3");
			// Total Columns
			int column = obj.getColumnCount("Sheet3");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Sheet3", j, i + 2);
					System.out.println("data     "+data[i][j]);
				}
			}
			return data;
		}
	
}
