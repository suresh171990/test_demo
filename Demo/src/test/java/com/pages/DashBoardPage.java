package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.base.BaseConfigurations;

public class DashBoardPage extends BaseConfigurations {

	By addCustomer_tab = By.xpath("//button[contains(text(),'Add Customer')]");
	
	By submitAddCustomer_btn = By.xpath("//button[contains(text(),'Add Customer') and @type = 'submit']");
	
	By postalCode_input = By.xpath("//input[@placeholder='Post Code']");
	
	By lastName_input = By.xpath("//input[@placeholder='Last Name']");
	
	By FirstName_input = By.xpath("//input[@placeholder='First Name']");
	
	By openAccount_btn = By.xpath("//button[contains(text(),'Open Account')]");
	
	By selectCustomer_dd = By.xpath("//select[@id='userSelect']");
	
	By selectCurrency_dd = By.xpath("//select[@id='currency']");
	
	By process_btn = By.xpath("//button[text()='Process']");
	
	By customers_tab = By.xpath("//button[contains(text(),'Customers')]");
	
	By searchCustomer_input = By.xpath("//input[@placeholder='Search Customer']");
	
	By firstName_ele = By.xpath("//table/tbody/tr/td[1]"); 
	
	
	
	
	public void addCustomer(String firstName, String lastName, String postalCode){
		driver.findElement(addCustomer_tab).click();
		driver.findElement(FirstName_input).sendKeys(firstName);
		driver.findElement(lastName_input).sendKeys(lastName);
		driver.findElement(postalCode_input).sendKeys(postalCode);
		driver.findElement(submitAddCustomer_btn).click();
	}
		
	public void openAccount(String firstName, String currency){
		driver.findElement(openAccount_btn).click();
		selectValueByVisibleText(driver.findElement(selectCustomer_dd),firstName);
		selectValueByVisibleText(driver.findElement(selectCurrency_dd),currency);
		driver.findElement(process_btn).click();
	}
	
	public void searchCustomers(String firstName){
		driver.findElement(customers_tab).click();
		driver.findElement(searchCustomer_input).sendKeys(firstName);
	}
	
	public boolean verifyCustomer(String customerName){
		boolean flag = true;
		List<WebElement> firstNames = driver.findElements(firstName_ele);
		
		for(WebElement firstName :firstNames){
			
			if(!firstName.getText().equals(customerName)){
				flag = false;
				break;
			}
		}
		return flag;
		
		
	}
}
