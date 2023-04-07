package com.Amazon.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
		
		htmlReporter= new ExtentHtmlReporter("C:\\Users\\MANISH\\eclipse-workspace\\Amazon_Ecommerce\\extent-config.xml");
		htmlReporter.loadXMLConfig("C:\\Users\\MANISH\\eclipse-workspace\\Amazon_Ecommerce\\test-output\\extent report");
	
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		
		extent.setSystemInfo("ProjectName", "Amazon ECommerceProject");
		extent.setSystemInfo("Tester", "Manish");
		extent.setSystemInfo("OS", "Win11");
		extent.setSystemInfo("Browser", "FireFox");
	}
	public static void endReport() {
		extent.flush();
	}
}