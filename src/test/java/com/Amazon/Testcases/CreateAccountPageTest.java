package com.Amazon.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Amazon.Base.BaseClass;
import com.Amazon.PageObject.CreateAccount;
import com.Amazon.PageObject.FrontPage;
import com.Amazon.PageObject.SignIn;

import testdata.ExcelSheet;

public class CreateAccountPageTest extends BaseClass{
	CreateAccount createAccount;
	FrontPage frontPage;
	SignIn signIn;
	
	
	@BeforeMethod
	public void setup() {
		initiate();
		
	}
	@AfterMethod
	
	public void tearDown() {
		driver.quit(); 
	}
	
@DataProvider 
public Object[][] verifyNameFieldData(){
	Object[][] result = ExcelSheet.readdata("Sheet1");
	return result;
	
}

@Test (dataProvider="verifyNameFieldData")
public void verifyYourNameField(String YourName ,String emailOrPhoneNo ,String Password ,String PasswordAgain) throws InterruptedException { 
	frontPage = new FrontPage();
    signIn = frontPage.clickOnAccount();
    createAccount = signIn.clickOnCreateNewAccountBtn();
	createAccount.login(YourName, emailOrPhoneNo, Password, PasswordAgain);
	boolean result = driver.findElement(By.xpath("//div[contains(text(),'Enter your name')]")).isDisplayed();
	Assert.assertTrue(result);	
}

@DataProvider
public Object[][] verifyEmailorPhoneNoData(){
	Object[][] result = ExcelSheet.readdata("Sheet2");
	return result;
}
@Test (dataProvider = "verifyEmailorPhoneNoData")
public void verifyEmailOrPhoneNo(String YourName ,String emailOrPhoneNo ,String Password ,String PasswordAgain) throws InterruptedException {
	frontPage = new FrontPage();
    signIn = frontPage.clickOnAccount();
    createAccount = signIn.clickOnCreateNewAccountBtn();
	createAccount.login(YourName, emailOrPhoneNo, Password, PasswordAgain);
	boolean result = driver.findElement(By.xpath("//div[contains(text(),'Enter your e-mail address or mobile phone number')]")).isDisplayed();
	Assert.assertTrue(result);	

}
@Test (dataProvider = "verifyEmailorPhoneNoData")
public void verifyPhoneNumberBtn(String YourName ,String emailOrPhoneNo ,String Password ,String PasswordAgain) throws InterruptedException {
	frontPage = new FrontPage();
    signIn = frontPage.clickOnAccount();
    createAccount = signIn.clickOnCreateNewAccountBtn();
	createAccount.login(YourName, emailOrPhoneNo, Password, PasswordAgain);
	String text = driver.findElement(By.xpath("//span[@class='phone-text']")).getText();
	System.out.println(text);
	Assert.assertEquals(text, "Verify mobile number");

}
@Test 
public void verifymessageReturningCustomer() throws InterruptedException {
	frontPage = new FrontPage();
    signIn = frontPage.clickOnAccount();
    createAccount = signIn.clickOnCreateNewAccountBtn();
	createAccount.login("Jerry", "mjrafaliya@gmail.com", "Abcdef", "Abcdef");
	String text = driver.findElement(By.xpath("//h4[contains(text(),'Are you a returning customer?')]")).getText();
	System.out.println(text);
	Assert.assertEquals(text, "Are you a returning customer");

}
}