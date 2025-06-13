package com.adactin.pageobjects;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class TestingAppsWithTestFlightPage extends BaseClass{
	
	Action action = new Action();
	
	public String getTestingAppsWithTestFlightPageUrl() {
		return action.getCurrentURL(getDriver());
	}

}
