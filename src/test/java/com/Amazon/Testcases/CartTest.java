package com.Amazon.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObject.AddedToCartPage;
import com.Amazon.PageObject.Cart;
import com.Amazon.PageObject.FrontPage;
import com.Amazon.PageObject.ProductInformationPage;
import com.Amazon.PageObject.SearchResultPage;

public class CartTest extends BaseClass{
	
	FrontPage frontPage;
	SearchResultPage searchResult;
	ProductInformationPage productInformation;
	AddedToCartPage addedToCart;
	Cart cart;
	@BeforeMethod
	public void setup() {
		initiate();
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void priceTest() throws InterruptedException {
		frontPage = new FrontPage();
		searchResult = frontPage.searchProduct("Water Bottles");
		productInformation = searchResult.clickOnProduct();
		double UnitPrice = productInformation.priceOfProduct();
		productInformation.qauntityOfProduct("3");
		addedToCart = productInformation.clickOnAddToCart();
		
		cart = addedToCart.clickOnGoToCart();
		double tot = cart.totalPrice();
		double finalTotalPrice = UnitPrice*3;
		Assert.assertEquals(tot, finalTotalPrice);
	
	}

	
}
