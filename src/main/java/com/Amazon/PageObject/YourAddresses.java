package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class YourAddresses extends BaseClass {
	Action act = new Action();
	
	
	@FindBy(id="ya-myab-plus-address-icon")
	WebElement AddAddress;
	
	public YourAddresses() {
		PageFactory.initElements(driver, this);
	} 
	 
	
	public boolean validateAddAddressOption() {
		return AddAddress.isDisplayed();
		
	}

}
 