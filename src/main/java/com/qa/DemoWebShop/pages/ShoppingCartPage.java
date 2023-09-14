package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Utils.ElementUtil;

public class ShoppingCartPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Shopping Cart Page
	private By shoppingPageHeader = By.cssSelector("div[class='page-title'] h1");
	private By shoppingCartTableData = By.xpath("//table[@class='cart']//tr/td");
	private By removeFromCartCheckbox = By.xpath("//input[@name='removefromcart']");
	private By productQuantiryField = By.cssSelector("input.qty-input");
	private By updateCartButton = By.cssSelector("input.update-cart-button");
	private By continueShoppingButton = By.cssSelector("input.continue-shopping-button");
	private By discountCouponField = By.cssSelector("input.discount-coupon-code");
	private By applyCouponButton = By.cssSelector("input.apply-discount-coupon-code-button");
	private By giftCardField = By.cssSelector("input.gift-card-coupon-code");
	private By applyGiftCardButton = By.cssSelector("input.apply-gift-card-coupon-code-button");
	private By selectCountryList = By.id("CountryId");
	private By stateProvinceField = By.id("StateProvinceId");
	private By zipField = By.id("ZipPostalCode");
	private By estimateShoppingButton = By.cssSelector("input.estimate-shipping-button");
	private By cartFields = By.xpath("//table[@class='cart-total']//tr");
	private By termsOfServiceCheckBox = By.id("termsofservice");
	private By checkoutButton = By.id("checkout");

	// Shopping Cart Page Actions
	public String getShoppingCartTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Home page is:" + title);
		return title;
	}

	public String getShoppingCartURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Home page is:" + url);
		return url;
	}

}
