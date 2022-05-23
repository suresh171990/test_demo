package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseConfigurations;

public class LandingPage extends BaseConfigurations{

	By managerLogin = By.xpath("//button[text()='Bank Manager Login']");
	
public void navigateManagerDasboard(){
	driver.findElement(managerLogin).click();
	}
}
