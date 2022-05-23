package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass {

		public static ChromeDriver driver = null;

		@SuppressWarnings("deprecation")
		public void test1() {
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("safebrowsing.enabled", "false"); 
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("disable-dev-shm-usage");
		options.addArguments("--ignore-certificate-errors");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.get("https://drinkprime.in/");

		String updatedByName = driver.getTitle();
		Assert.assertEquals("Water Purifier on Rent in Bangalore, Hyderabad & Delhi | DrinkPrime", updatedByName);
		

		}
		
	

}
