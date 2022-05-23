package com.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class BaseConfigurations {

	public static WebDriver driver = null;
	
	public static void setupDriver(WebDriver setupDriver){
		driver =setupDriver;
	}
	public static void launchApplication(String URL){
		driver.get(URL);
	}
	
	public void selectValueByVisibleText(WebElement selectCustomer_dd,String dd_Value){
		Select objdd = new Select(selectCustomer_dd);
		
		objdd.selectByVisibleText(dd_Value);
		
	}
	
	public void acceptAllert(){
		
		driver.switchTo().alert().accept();
				
	}
}
