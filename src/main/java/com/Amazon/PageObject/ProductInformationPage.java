package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class ProductInformationPage extends BaseClass {

	Action act =new Action();
	
	@FindBy(xpath ="//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']")
	WebElement unitPrice;
	
	//@FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@aria-hidden='true']//span[@class='a-price-fraction'][contains(text(),'79')]")
	//WebElement Fraction;
	
	@FindBy(id = "add-to-cart-button")
	WebElement AddToCartBtn;
	
	@FindBy(id ="quantity")
	 WebElement quantity;
	
public ProductInformationPage() {
	PageFactory.initElements(driver, this);
	}

public double priceOfProduct() {
	String UnitPrice = unitPrice.getText();
	System.out.println(UnitPrice);
	String UnitPrice1 = UnitPrice.replaceAll("[^a-zA-Z0-9]","");
	//String fraction = Fraction.getText();
	//String fraction1 = fraction.replaceAll("[^a-zA-Z0-9]","");
	double UnitPrice01 =Double.parseDouble(UnitPrice1);
	System.out.println(UnitPrice01);
	//double fraction01 =Double.parseDouble(fraction1);
	//System.out.println(fraction1);
	
	double finalUnitPrice = UnitPrice01/100;
	System.out.println(finalUnitPrice);
	
	return finalUnitPrice;
}

public void qauntityOfProduct(String Quantity) {
	act.selectByValue(quantity, Quantity);
	
}
public AddedToCartPage clickOnAddToCart() {
	 act.click(driver, AddToCartBtn);
	 return new AddedToCartPage();
}
}
