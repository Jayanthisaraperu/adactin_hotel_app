package com.adactin.pageobjects;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class ChangePasswordPage  extends BaseClass{
	
	Action action =  new Action();
	
	public String getChangePasswordUrl() {
		return action.getCurrentURL(getDriver());
		 }
}
