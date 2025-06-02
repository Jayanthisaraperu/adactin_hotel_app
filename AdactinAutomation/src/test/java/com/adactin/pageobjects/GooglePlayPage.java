package com.adactin.pageobjects;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class GooglePlayPage extends BaseClass{
	
	Action action = new Action();
	
	public String  getGooglePlayPageUrl() {
		return action.getCurrentURL(driver);
	}

}
