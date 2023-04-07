package com.Amazon.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;
 
public class HomePage extends BaseClass{ 
	Action act = new Action();
	
	
	
	@FindBy(xpath="//span[contains(text(),'Cart')]") 
	WebElement cartBtn ;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") 
	WebElement searchBox ;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button'] ")  
	WebElement searchBtn ;
	
	@FindBy (css="#nav-link-accountList-nav-line-1")
	WebElement Account;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
		}
	
	

	
	public Cart clickOncartBtn() {
		act.click(driver,cartBtn);
		return new Cart();
	

}
	public SearchResultPage searchProduct(String ProductName) {
		
		act.type(searchBox,ProductName);
		act.click(driver, searchBtn);
		return new SearchResultPage();
		
	}
	public String GetText() {
		String text = Account.getText();
		return text;
		
		
	}


	public YourAccount clickOnYourAccount() {
		act.click(driver, Account);
		return new YourAccount();// TODO Auto-generated method stub
		
	}
	
}

