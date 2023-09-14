package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Utils.ElementUtil;

public class GiftCardsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public GiftCardsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Gift Cards Page
	By breadcrumbGiftCardsPage = By.cssSelector("div.breadcrumb");
	By titleGiftCardsPage = By.cssSelector("div.page-title");
	By featuredGiftCardsList = By.xpath("//div[@class='product-grid']/div[@class='item-box']");

	// Gift Cards Page Actions
	public String getGiftCardsTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Gift Cards page is:" + title);
		return title;
	}

	public String getGiftCardsPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Gift Cards page is:" + url);
		return url;
	}

	public boolean verifyGiftCardsPageBreadcumbIsDisplayed() {
		boolean flag = eleUtil.isdisplayed(breadcrumbGiftCardsPage);
		return flag;
	}

	public String verifyBooksPageTitleText() {
		String text = eleUtil.dogetText(titleGiftCardsPage);
		return text;
	}

//	public void verifySortingList() {
//
//	}

}
