package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class LoginPage extends BaseClass  {

	Action action= new Action();
	
	@FindBy (id="username")
	WebElement txt_username;
	
	@FindBy (id="password")
	WebElement txt_password;
	
	@FindBy (xpath="//img[@class='logo']")
	WebElement logo;
	
	@FindBy (id="login")
	WebElement button_login;
	
	@FindBy (xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement link_forgot_password;
	
	@FindBy (xpath="//a[contains(text(),'New User Register Here')]")
	WebElement new_user_register_here;
	
	@FindBy (xpath="//a[contains(text(),'info@adactin.com')]")
	WebElement for_any_queries;
	
	@FindBy (xpath="//img[@src='img/ios-button.png']")
	WebElement for_iOS;
	
	@FindBy (xpath="//img[@src='img/google-play.png']")
	WebElement google_play;
	
	@FindBy (id="//a[contains(text(),'Adactin.com')]")
	WebElement footer;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyForiOS() {
		return action.isDisplayed(driver, for_iOS);
	}
	
	public TestingAppsWithTestFlightPage verifyFunctionalityForiOS() throws Exception {
		action.click(driver, for_iOS);
		Thread.sleep(5000);
		return new TestingAppsWithTestFlightPage();
		
	}
	
	public boolean verifyGooglePlay() {
		return action.isDisplayed(driver, google_play);
	}
	
	public GooglePlayPage verifyFunctionalityGooglePlay() throws Exception {
		action.click(driver, google_play);
		Thread.sleep(2000);
		action.screenShot(driver, "GooglePlayPage");

		return new GooglePlayPage();
		
	}
	
	public boolean verifyForgotPassword() {
		return action.isDisplayed(driver, link_forgot_password);
	}
	
	public ForgotPasswordFormPage verifyFunctionalityForgotPassword() {
		action.click(driver, link_forgot_password);
		return new ForgotPasswordFormPage();
		
	}
	
	public boolean verifyLogo() {
		
		return action.isDisplayed(driver, logo);
	}
	
	public boolean displayOfNewUserRegisterHere() {
		return action.isDisplayed(driver, new_user_register_here);
	}
	public NewUserRegistrationFormPage verifyNewUserRegisterHere() {
		action.click(driver, new_user_register_here);
		action.screenShot(driver, "NewUserRegistrationFormPage");

		return new NewUserRegistrationFormPage();

	}
	
	public SearchHotelPage doLogin(String username, String password) {
		action.type(txt_username, username);
		action.type(txt_password, password);
		action.click(driver,button_login);
		return new SearchHotelPage();
	}
	
	
}
