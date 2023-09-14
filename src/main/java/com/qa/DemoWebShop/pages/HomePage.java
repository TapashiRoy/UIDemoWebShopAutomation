package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Utils.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Home Page after Login
	private By headerAccountLink = By.xpath("//div[@class='header-links']//a[@class='account']");
	private By logOutLink = By.xpath("//a[@class='ico-logout']");
	private By shoppingCartLink = By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']");
	private By wishlistLink = By.xpath("//div[@class='header-links']//a[@class='ico-wishlist']");
	private By searchTextField = By.id("small-searchterms");
	private By searchButton = By.cssSelector("input.search-box-button");

	// *****-----Locators for Manufacturer Section-------******
	private By manufacturerList = By.cssSelector("div.block-manufacturer-navigation div.title");
	private By tricentisLink = By.xpath("//a[normalize-space()='Tricentis']");

	// Home Page Actions

	public String getHomePageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Home page is:" + title);
		return title;
	}

	public String getHomePageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Home page is:" + url);
		return url;
	}

	public boolean isheaderAccountLinkExists() {
		boolean flag = eleUtil.isdisplayed(headerAccountLink);
		return flag;
	}

	public boolean islogOutLinkExists() {
		boolean flag = eleUtil.isdisplayed(logOutLink);
		return flag;
	}

	public boolean isshoppingCartLinkExists() {
		boolean flag = eleUtil.isdisplayed(shoppingCartLink);
		return flag;
	}

	public boolean iswishlistLinkExists() {
		boolean flag = eleUtil.isdisplayed(wishlistLink);
		return flag;
	}

	public boolean isSearchFieldExists() {
		boolean flag = eleUtil.isdisplayed(searchTextField);
		return flag;
	}

	public boolean isSearchButtonExists() {
		boolean flag = eleUtil.isdisplayed(searchButton);
		return flag;
	}

	public String getTextAttributeFromSearchField() {
		String text = eleUtil.getElementAttribute(searchTextField, "value");
		System.out.println("The value of the Search fields is:" + text);
		return text;
	}

	public SearchPage performSearch(String searchKey) {
		if (isSearchFieldExists()) {
			eleUtil.dosendKeys(searchTextField, searchKey);
			eleUtil.doclick(searchButton);
			return new SearchPage(driver);

		} else {
			System.out.println("The Search fields is not visible yet on the page");
			return null;
		}
	}

}
