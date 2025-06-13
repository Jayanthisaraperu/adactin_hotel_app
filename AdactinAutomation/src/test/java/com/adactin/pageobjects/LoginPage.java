package com.adactin.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.adactin.actiondriver.Action;
import com.adactin.base.BaseClass;

public class LoginPage extends BaseClass  {

	Action action= new Action();
	
	@FindBy (id="username")
	private WebElement txt_username;
	
	@FindBy (id="password")
	private WebElement txt_password;
	
	@FindBy (xpath="//img[@class='logo']")
	private WebElement logo;
	
	@FindBy (id="login")
	private WebElement button_login;
	
	@FindBy (xpath="//a[contains(text(),'Forgot Password?')]")
	private WebElement link_forgot_password;
	
	@FindBy (xpath="//a[contains(text(),'New User Register Here')]")
	private WebElement new_user_register_here;
	
	@FindBy (xpath="//a[contains(text(),'info@adactin.com')]")
	private WebElement for_any_queries;
	
	@FindBy (xpath="//img[@src='img/ios-button.png']")
	private WebElement for_iOS;
	
	@FindBy (xpath="//img[@src='img/google-play.png']")
	private WebElement google_play;
	
	@FindBy (id="//a[contains(text(),'Adactin.com')]")
	private WebElement footer;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public String verifyTitle() {
		return getDriver().getTitle();
	}
	
	public boolean verifyForiOS() {
		return action.isDisplayed(getDriver(), for_iOS);
	}
	
	public TestingAppsWithTestFlightPage verifyFunctionalityForiOS() throws Exception {
		action.click(getDriver(), for_iOS);
		Thread.sleep(5000);
		return new TestingAppsWithTestFlightPage();
		
	}
	
	public boolean verifyGooglePlay() {
		return action.isDisplayed(getDriver(), google_play);
	}
	
	public GooglePlayPage verifyFunctionalityGooglePlay() throws Exception {
		action.click(getDriver(), google_play);
		Thread.sleep(2000);
		

		return new GooglePlayPage();
		
	}
	
	public boolean verifyForgotPassword() {
		return action.isDisplayed(getDriver(), link_forgot_password);
	}
	
	public ForgotPasswordFormPage verifyFunctionalityForgotPassword() {
		action.click(getDriver(), link_forgot_password);
		return new ForgotPasswordFormPage();
		
	}
	
	public boolean verifyLogo() {
		
		return action.isDisplayed(getDriver(), logo);
	}
	
	public boolean displayOfNewUserRegisterHere() {
		return action.isDisplayed(getDriver(), new_user_register_here);
	}
	public NewUserRegistrationFormPage verifyNewUserRegisterHere() {
		action.click(getDriver(), new_user_register_here);
		

		return new NewUserRegistrationFormPage();

	}
	
	public SearchHotelPage doLogin(String username, String password) {
		action.type(txt_username, username);
		action.type(txt_password, password);
		action.click(getDriver(),button_login);
		return new SearchHotelPage();
	}
	
	
}
