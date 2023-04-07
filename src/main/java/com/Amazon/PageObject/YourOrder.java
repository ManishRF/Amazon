package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class YourOrder extends BaseClass {
	
	Action act =new Action();
	
	@FindBy(linkText="Orders") 
	WebElement Order;
	
	@FindBy(linkText="Buy Again")
	WebElement BuyAgain;
	
	@FindBy(linkText="Not Yet Shipped") 
	WebElement NotYetShipped;
	 
	@FindBy(linkText="Cancelled Orders")
	WebElement CancelledOrder;
	
	public YourOrder() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateBuyAgain() {
		return act.isDisplayed(driver, BuyAgain);
		
	}
	public boolean validateNotYetShipped() {
		return act.isDisplayed(driver, NotYetShipped);
	}
	public boolean validateCancelledOrder() {
		return act.isDisplayed(driver, CancelledOrder);
	}
	

}
