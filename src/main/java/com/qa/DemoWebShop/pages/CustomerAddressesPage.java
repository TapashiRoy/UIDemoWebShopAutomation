package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Utils.ElementUtil;

public class CustomerAddressesPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public CustomerAddressesPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Customer AddressesPage Page
	private By headerAccountLink = By.xpath("//h1[normalize-space()='My account - Addresses']");
	private By editButton = By.xpath("//input[@value='Edit']");
	private By deleteButton = By.xpath("//input[@value='Delete']");
	private By addNewButton = By.xpath("//input[@value='Add new']");

}
