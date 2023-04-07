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
import com.Amazon.PageObject.YourAddresses;
import com.Amazon.PageObject.YourOrder;

public class YourAddressPageTest extends BaseClass {
	FrontPage frontPage;
	SignIn signIn;
	PasswordPage passwordPage;
	HomePage homePage;
	YourAccount yourAccount;
	YourOrder yourOrder;
	YourAddresses yourAddress;
	
	@BeforeMethod
	public void setup() { 
		initiate();
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}
	
@Test
public void addAddressNavigationVerification() {
frontPage = new FrontPage();
signIn = frontPage.clickOnAccount();
passwordPage = signIn.clickOnContinue(prop.getProperty("username"));
homePage = passwordPage.SignIn(prop.getProperty("password"));
yourAccount = homePage.clickOnYourAccount();
yourAddress = yourAccount.clickOnUrAddress();
boolean result = yourAddress.validateAddAddressOption();
Assert.assertTrue(result);

}
}
