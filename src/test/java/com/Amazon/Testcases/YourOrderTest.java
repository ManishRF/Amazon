package com.Amazon.Testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObject.FrontPage;
import com.Amazon.PageObject.HomePage;
import com.Amazon.PageObject.PasswordPage;
import com.Amazon.PageObject.SignIn;
import com.Amazon.PageObject.YourAccount;
import com.Amazon.PageObject.YourOrder;

public class YourOrderTest extends BaseClass {
	
	FrontPage frontPage;
	SignIn signIn;
	PasswordPage passwordPage;
	HomePage homePage;
	YourAccount yourAccount;
	YourOrder yourOrder;
	
	@BeforeMethod
	public void setup() {
		initiate();
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	
	public void verifyBuyAgainOption() {
		frontPage = new FrontPage();
		signIn = frontPage.clickOnAccount();
		passwordPage = signIn.clickOnContinue(prop.getProperty("username"));
		homePage = passwordPage.SignIn(prop.getProperty("password"));
		yourAccount = homePage.clickOnYourAccount();
		yourOrder =yourAccount.clickOnUrOrder();
		boolean result = yourOrder.validateBuyAgain();
		Assert.assertTrue(result);
				
		
	}
	@Test
	public void verifyNotYetShippedOption() {
		frontPage = new FrontPage();
		signIn = frontPage.clickOnAccount();
		passwordPage = signIn.clickOnContinue(prop.getProperty("username"));
		homePage = passwordPage.SignIn(prop.getProperty("password"));
		yourAccount = homePage.clickOnYourAccount();
		yourOrder =yourAccount.clickOnUrOrder();
		boolean result = yourOrder.validateNotYetShipped();
		Assert.assertTrue(result);
					
	}
	@Test
	public void verifyCancelledOrdersOption() {
		frontPage = new FrontPage();
		signIn = frontPage.clickOnAccount();
		passwordPage = signIn.clickOnContinue(prop.getProperty("username"));
		homePage = passwordPage.SignIn(prop.getProperty("password"));
		yourAccount = homePage.clickOnYourAccount();
		yourOrder =yourAccount.clickOnUrOrder();
		boolean result = yourOrder.validateCancelledOrder();
		Assert.assertTrue(result);
					
	}
}
