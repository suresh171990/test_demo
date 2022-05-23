package com.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.testng.Assert;

import com.base.DriverConfiguration;
import com.pages.DashBoardPage;
import com.pages.LandingPage;

public class Test1 {
	
	@BeforeClass
	public static void DriverConfiguration(){
		DriverConfiguration.driverInitilization();
		LandingPage.launchApplication("https://www.way2automation.com/angularjs-protractor/banking/#/login");
	}

	@Test
	public void addNewCustomer(){
		LandingPage landingPage = new LandingPage();
		DashBoardPage dashBoardPage = new DashBoardPage();
		
		String firstName = "Suresh";
		String lastName = "s";
		String postalCode = "560037";
		String currency = "Rupee";
		String processName = firstName+" "+lastName;
		
//		landingPage.driverInitilization();
		
		landingPage.navigateManagerDasboard();
		dashBoardPage.addCustomer(firstName,lastName,postalCode);
		dashBoardPage.acceptAllert();
		dashBoardPage.openAccount(processName, currency);
		dashBoardPage.acceptAllert();
		dashBoardPage.searchCustomers(firstName);
		Assert.assertTrue(dashBoardPage.verifyCustomer(firstName), "Customer not created successfully");
	}
}
