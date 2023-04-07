package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class YourAccount extends BaseClass {
	Action act = new Action();
	
	
	@FindBy(xpath="//h2[contains(text(),'Your Orders')]")
	WebElement urOrder;
	
	@FindBy(xpath="//h2[contains(text(),'Your Addresses')]")
	WebElement urAddress;
	
	@FindBy(xpath="//h2[contains(text(),'Login & security')]")
	WebElement LginAndScrty;
	
	@FindBy(xpath="//h2[contains(text(),'Your Payments')]")
	WebElement urPayment;
	  
	
	public YourAccount() {
		PageFactory.initElements(driver, this);
		
	}
	
	public YourOrder clickOnUrOrder() {
		act.click(driver, urOrder);
		return new YourOrder();
		
	}
	public YourAddresses clickOnUrAddress() {
		act.click(driver,urAddress);
		return new YourAddresses();
	}
		
		
	
	
		

}

