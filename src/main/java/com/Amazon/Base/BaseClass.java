package com.Amazon.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.Amazon.Utility.ExtentManager;
import com.Amazon.actiondriver.Action;

import io.github.bonigarcia.wdm.WebDriverManager;





public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	
	
	@BeforeSuite
	
	public void loadConfig() {
		ExtentManager.setExtent();
		try {
			prop = new Properties();
			
		FileInputStream file = new FileInputStream("C:\\Users\\MANISH\\eclipse-workspace\\Amazon_Ecommerce\\src\\main\\java\\com\\Amazon\\EnvironmentVariable\\config.properties");
		prop.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public static void initiate() {
		
		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
			
		}
		else if(browsername.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions cOPT = new ChromeOptions();
			cOPT.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(cOPT);
			
		}
			Action act = new Action();
			act.implicitWait(driver, 10);
			act.pageLoadTimeOut(driver, 30);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));	
	}
	public static void screenshots(String Filename) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("C:\\Users\\MANISH\\eclipse-workspace\\HRManagement\\src\\test\\java\\screenshots\\Screenshots"+ Filename+".jpg"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		}
@AfterSuite
	
	public void afterSuite() {
		ExtentManager.endReport();
	}
}


