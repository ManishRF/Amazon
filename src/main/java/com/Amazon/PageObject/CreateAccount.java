package com.Amazon.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class CreateAccount extends BaseClass{

	Action act = new Action();
	
	@FindBy(id="ap_customer_name") 
	WebElement YourName;
	
	@FindBy(xpath="//input[@id='ap_email']")
	WebElement MobileOrEmail; 
	
	@FindBy(xpath="//input[@id='ap_password']")
	WebElement Password;
	
	@FindBy(xpath="//input[@id='ap_password_check']")
	WebElement PasswordAgain;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement ContinueBtn;
	
	@FindBy(xpath= "//div[contains(text(),'Enter your name')]")
	WebElement errorMessageYourName;
	
	@FindBy(xpath= "//div[contains(text(),'Enter your e-mail address or mobile phone number')]")
	WebElement errorMessageEmailOrPhoneNo;
	
	@FindBy(xpath= "//div[contains(text(),'Enter your e-mail address or mobile phone number')]")
	WebElement verifyMobileNumberText;
	
	@FindBy(css= "#auth-password-missing-alert > div > div")
	WebElement errorMessagePassword;
	
	public CreateAccount() {
		PageFactory.initElements(driver, this);
		}
	
	public void login(String uname,String emailOrMobileNo,String password, String passwordAgn) throws InterruptedException {
		act.type(YourName, uname);
		act.type(MobileOrEmail, emailOrMobileNo);
		act.type(Password, password);
		act.type(PasswordAgain, passwordAgn);
	    act.click(driver, ContinueBtn);
	} 
	

	public void verifyMobileNumber(String Uname, String phoneNo) {
		
		act.type(YourName, Uname);
		act.type(MobileOrEmail, phoneNo);
		act.click(driver,Password );	
	}
}
