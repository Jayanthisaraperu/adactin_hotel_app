package com.adactin.pageobjects;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class NewUserRegistrationFormPage extends BaseClass{

	Action action = new Action();
	
	public String getNewUserRegistrationFormPageUrl() {
		return action.getCurrentURL(driver);
	}
}
