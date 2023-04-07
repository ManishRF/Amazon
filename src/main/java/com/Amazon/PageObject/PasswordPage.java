package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class PasswordPage extends BaseClass{
	
Action act = new Action();
	
	
	@FindBy(id="ap_password")
	WebElement pswrd;
	
	@FindBy(id="signInSubmit")
	WebElement signInBtn;
	
	@FindBy(name="rememberMe")
	WebElement rememberMe;
	
	
	public PasswordPage() {
		PageFactory.initElements(driver, this);
	}
	public HomePage SignIn(String Password) {
		act.type(pswrd, Password);
		act.click(driver, signInBtn);
		return new HomePage();
	}
		
		public HomePage KeepMeSignedIn(String Password) {
			act.type(pswrd, Password);
			act.click(driver, rememberMe);
			act.click(driver, signInBtn);
			return new HomePage();
		
	}
}
