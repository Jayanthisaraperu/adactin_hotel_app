package com.adactin.pageobjects;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class LogoutPage extends BaseClass{
	
	Action action = new Action();
	
	public String getLogoutPageUrl() {
		return action.getCurrentURL(driver);
	}

}
