package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.Utils.ElementUtil;

public class SearchPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Search Page
	By searchPageTitle = By.cssSelector("div.page-title");
	By searchKeywordText = By.id("Q");
	By adVancedSearchCheckbox = By.id("As");
	By adVancedSearchButton = By.cssSelector("input.search-button");
	By productDetailsGrid = By.xpath("//div[@class='product-grid']/div[@class='item-box']");
	By productNotFoundErrorMessage = By.xpath("//strong[@class='result']");
	By productAddToCartButton = By.xpath("//input[@value='Add to cart']");

	// Search Page Actions
	public ProductDetailsPage selectProduct(String productName) {
		By productLocator = By.linkText(productName);
		eleUtil.waitVisibilityElement(productLocator, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
		return new ProductDetailsPage(driver);
	}

	public int getProductSearchResultsCount() {
		int count = eleUtil.getTotalElementsCount(productDetailsGrid);
		if (count > 0) {
			System.out.println("The search is successful and the count is:" + count);
		} else {
			eleUtil.dofindElement(productNotFoundErrorMessage).isDisplayed();
			String text = eleUtil.dofindElement(productNotFoundErrorMessage).getText();
			System.out.println(text);
		}
		return count;
	}

	public ShoppingCartPage productAddToCart(String productName) {
		By productLocator = By.linkText(productName);
		eleUtil.waitVisibilityElement(productAddToCartButton, AppConstants.DEFAULT_SHORT_TIME_OUT).click();
		return new ShoppingCartPage(driver);
	}

}
