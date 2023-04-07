package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class Cart extends BaseClass {
	Action act = new Action();
	
	@FindBy(id ="sc-subtotal-amount-activecart")
	WebElement Total; 
	
	public Cart() {
		PageFactory.initElements(driver, this);
	}
	
	public double totalPrice() {
		act.fluentWait(driver, Total, 10);
		String total = Total.getText();
		System.out.println(total);
		String tot = total.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(tot);

		double totalPrice1 = Double.parseDouble(tot);
		System.out.println(totalPrice1);
		System.out.println(totalPrice1/100);

		
		return totalPrice1/100;
	}
	public boolean isDisplayedTotal() {
		act.fluentWait(driver, Total, 10);
		return Total.isDisplayed();
	}
	
 
}
