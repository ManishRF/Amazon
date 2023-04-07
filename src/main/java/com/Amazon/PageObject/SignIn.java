package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class SignIn extends BaseClass {
	Action act = new Action();
	
	
	@FindBy(id="ap_email")
	WebElement EmailOrPhoneNumberBox;
	
	@FindBy(id="continue")
	WebElement ContinueBtn; 
	
	@FindBy(id="createAccountSubmit")
	WebElement CreateNewAcntBtn; 



public SignIn() {
	PageFactory.initElements(driver, this);
}

public PasswordPage clickOnContinue(String emailOrPhoneNo) {
	act.type(EmailOrPhoneNumberBox, emailOrPhoneNo);
	act.click(driver, ContinueBtn);
	return new PasswordPage();
	
}
public CreateAccount clickOnCreateNewAccountBtn() {
	act.click(driver, CreateNewAcntBtn);
	return new CreateAccount();
}
}
