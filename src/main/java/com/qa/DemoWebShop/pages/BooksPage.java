package com.qa.DemoWebShop.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.Utils.ElementUtil;

public class BooksPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public BooksPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Books Page
	By breadcrumbBooksPage = By.cssSelector("div.breadcrumb");
	By titleBooksPage = By.cssSelector("div.page-title");
	By headers = By.xpath("//ul[@class='top-menu']/li/a");
	By sortingList = By.id("products-orderby");
	By allValuesInSortByList = By.xpath("//select[@id='products-orderby']/option");
	By displayList = By.id("products-pagesize");
	By allValuesInDisplayList = By.xpath("//select[@id='products-pagesize']/option");
	By viewList = By.id("products-viewmode");
	By allValuesInviewList = By.xpath("//select[@id='products-viewmode']/option");
	By booksFeaturedList = By.xpath("//div[@class='product-grid']/div[@class='item-box']");
	By filterLinks = By.xpath("//ul[@class='price-range-selector']/li");
	By filerUnder25 = By.xpath("(//span[@class='PriceRange' and text()=25.00])[1]");
	By ItemsUnder25 = By.xpath("//div[@class='product-grid']/div[@class='item-box']");

	By filterBetween25and50 = By.xpath("(//span[@class='PriceRange' and text()=50.00])[2]");
	By removeFilterLink = By.cssSelector("div.remove-filter");

	// Books Page Actions
	public String getBooksPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Books page is:" + title);
		return title;
	}

	public String getBooksPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Books page is:" + url);
		return url;
	}

	public List<String> verifyBooksPageHeaders() {
		List<String> values = eleUtil.getElementsText(headers);
		return values;
	}

	public boolean verifyBooksPageBreadcumbIsDisplayed() {
		boolean flag = eleUtil.isdisplayed(breadcrumbBooksPage);
		return flag;
	}

	public boolean verifyBooksPageTitleIsDisplayed() {
		boolean flag = eleUtil.isdisplayed(titleBooksPage);
		return flag;
	}

	public boolean verifyFilterLinksAreDisplayed() {
		boolean flag = eleUtil.isdisplayed(filterLinks);
		return flag;
	}

	public int countFilterLinks() {
		int count = eleUtil.getTotalElementsCount(filterLinks);
		System.out.println("Total count of Filters is:" + count);
		return count;
	}

	public String verifyBooksPageTitleText() {
		String text = eleUtil.dogetText(titleBooksPage);
		return text;
	}

	public List<String> verifyAllValuesInSortingList() {
		eleUtil.waitVisibilityElement(sortingList, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(sortingList);

		List<String> values = eleUtil.getElementsText(allValuesInSortByList);
		return values;
	}

	public int verifyCountInSortingList() {
		eleUtil.waitVisibilityElement(sortingList, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(sortingList);

		int count = eleUtil.getTotalElementsCount(allValuesInSortByList);
		System.out.println("Total count in the Sorting dropdown list is:" + count);
		return count;
	}

	public List<String> verifyAllValuesInDisplayList() {
		eleUtil.waitVisibilityElement(displayList, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(displayList);

		List<String> values = eleUtil.getElementsText(allValuesInDisplayList);
		return values;
	}

	public int verifyCountInDisplayList() {
		eleUtil.waitVisibilityElement(displayList, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(displayList);

		int count = eleUtil.getTotalElementsCount(allValuesInDisplayList);
		System.out.println("Total count in the Sorting dropdown list is:" + count);
		return count;
	}

	public List<String> verifyAllValuesInViewList() {
		eleUtil.waitVisibilityElement(viewList, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(viewList);

		List<String> values = eleUtil.getElementsText(allValuesInviewList);
		return values;

	}

	public int verifyCountInViewList() {
		eleUtil.waitVisibilityElement(viewList, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(viewList);

		int count = eleUtil.getTotalElementsCount(allValuesInviewList);
		System.out.println("Total count in the View dropdown list is:" + count);
		return count;
	}

	public int verifyCountOfFeaturedBooks() {
		int count = eleUtil.getTotalElementsCount(booksFeaturedList);
		return count;
	}

	public int filterActionUnder25() {
		eleUtil.waitVisibilityElement(filerUnder25, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(filerUnder25);
		int count = eleUtil.getTotalElementsCount(ItemsUnder25);
		eleUtil.doclick(removeFilterLink);
		return count;
	}

}
