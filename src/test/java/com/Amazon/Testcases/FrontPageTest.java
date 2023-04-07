package com.Amazon.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObject.FrontPage;
import com.Amazon.PageObject.SearchResultPage;
import com.Amazon.PageObject.SignIn;

public class FrontPageTest extends BaseClass {
	FrontPage frontPage;
	SearchResultPage productPage;
	
	
	@BeforeMethod
	public void setup() {
		initiate();
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

	
@Test

public void searchProduct() {
	frontPage = new FrontPage();
	productPage = frontPage.searchProduct("T-Shirt");
}
	
@Test

public void verifySearchField(){
	frontPage = new FrontPage();
boolean result = frontPage.validateSearchField();
Assert.assertTrue(result);
}	
	
	

	
	
}

	
	

	
