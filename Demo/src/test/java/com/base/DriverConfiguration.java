package com.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverConfiguration {

public static WebDriver driver = null;
	
	
	public static void driverInitilization(){
		System.setProperty("webdriver.chrome.driver", "C:/Users/Dell/OneDrive/Desktop/Newfolder/chromedriver.exe");
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("safebrowsing.enabled", "false"); 
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(false);
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--ignore-ssl-errors=yes");
		options.addArguments("disable-dev-shm-usage");
		options.addArguments("--ignore-certificate-errors");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
//		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().setSize(new Dimension(1920, 1080));
		BaseConfigurations.setupDriver(driver);
	}
	
	
}
