package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class SearchResultPage extends BaseClass {
	    Action act = new Action();
	
	 @FindBy(xpath = "//span[@class='a-size-base-plus a-color-base a-text-normal'][contains(text(),'Simple Modern Water Bottle with Straw and Chug Lid')]")
	 WebElement product;
	 
	 
	 public SearchResultPage() {
			PageFactory.initElements(driver, this);
			}
		
	
	 public ProductInformationPage clickOnProduct() {
		 act.fluentWait(driver, product, 10);
	 act.click(driver, product);
	 return new ProductInformationPage();
	 }
}
