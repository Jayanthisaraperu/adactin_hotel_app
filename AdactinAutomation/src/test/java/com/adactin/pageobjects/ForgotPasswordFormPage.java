package com.adactin.pageobjects;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class ForgotPasswordFormPage extends BaseClass{
	
	Action action = new Action();
	
	public String getForgotPasswordFormPageUrl() {
		return action.getCurrentURL(driver);
	}

}
