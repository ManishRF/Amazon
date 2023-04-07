package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class AddedToCartPage extends BaseClass{
	Action act = new Action();
	
	 
	@FindBy(id = "sw-gtc")
	WebElement goToCart;

	public AddedToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public Cart clickOnGoToCart() {
		
		act.click(driver, goToCart);
		return new Cart();
	}
	public boolean isDisplayedTotal() {
		
		return goToCart.isDisplayed();
}
}