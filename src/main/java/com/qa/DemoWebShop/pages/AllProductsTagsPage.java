package com.qa.DemoWebShop.pages;

import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Utils.ElementUtil;

public class AllProductsTagsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public AllProductsTagsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

}
