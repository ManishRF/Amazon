package com.Amazon.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObject.FrontPage;
import com.Amazon.PageObject.HomePage;
import com.Amazon.PageObject.PasswordPage;
import com.Amazon.PageObject.SignIn;

public class SignInTest extends BaseClass {
	FrontPage frontPage;
	SignIn signIn;
	PasswordPage password;
	HomePage homePage;
	
	@BeforeMethod
	public void setup() {
		initiate();
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit();
	}

	@Test 
	public void verifySignInModule() {
		frontPage = new FrontPage();
		signIn = frontPage.clickOnAccount();
		password = signIn.clickOnContinue(prop.getProperty("username"));
		homePage = password.SignIn(prop.getProperty("password"));
		boolean element =driver.findElement(By.id("nav-link-accountList-nav-line-1")).isDisplayed();
		Assert.assertTrue(element);	
		}
	
	
	@Test
	public void verifyGreetingMessaage() {
		frontPage = new FrontPage();
		signIn = frontPage.clickOnAccount();
		password = signIn.clickOnContinue(prop.getProperty("username"));
		homePage = password.SignIn(prop.getProperty("password"));
		String result =homePage.GetText();
		//String result =driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
		System.out.println(result);
		Assert.assertEquals(result, "Hello, Poonam");

}
}
