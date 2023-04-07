package com.Amazon.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Amazon.Base.BaseClass;
import com.Amazon.actiondriver.Action;

public class FrontPage extends BaseClass{
	Action act= new Action(); 
	


	@FindBy(xpath="//a[@id='nav-link-accountList']")  
	WebElement accountBtn ;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']") 
	WebElement searchBox ;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']") 
	WebElement searchBtn ;
	
	@FindBy(xpath="//div[@id='nav-flyout-ya-newCust']//a[@class='nav-a'][contains(text(),'Start here.')]") 
	WebElement startHere ;
	
	public FrontPage() {
		PageFactory.initElements(driver, this);
		}
	
	
	public SignIn clickOnAccount() {
		accountBtn.click();
		return new SignIn(); 
	}
	
	public boolean validateSearchField() {
		return searchBox.isDisplayed();
	}
		
	public SearchResultPage searchProduct(String ProductName) {
			
			act.type(searchBox,ProductName);
			act.click(driver, searchBtn);
			return new SearchResultPage();
			
	
}
	public CreateAccount MouseHover() throws InterruptedException {
		
		act.mouseHoverByJavaScript(accountBtn);
		Thread.sleep(3000);

		act.selectByVisibleText("Start here", startHere);
		return new CreateAccount();
		
}
}
	
