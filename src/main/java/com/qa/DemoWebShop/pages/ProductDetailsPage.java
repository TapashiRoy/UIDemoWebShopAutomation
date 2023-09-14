package com.qa.DemoWebShop.pages;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.Utils.ElementUtil;

public class ProductDetailsPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String, String> productSpecification;

	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Product Details Page
	private By productHeader = By.cssSelector("div.product-name");
	private By addToCartButton = By.cssSelector("input.add-to-cart-button");
	private By wishlistItemButton = By.xpath("//input[contains(@value,'Add to wishlist')]");
	private By emailToAFriendButton = By.xpath("//input[contains(@value,'Email a friend')]");
	private By addToCompareList = By.xpath("//input[contains(@value,'Add to compare list')]");
	private By itemDescriptionText = By.cssSelector("div.full-description");
	private By productImage = By.cssSelector("div.gallery img");
	private By productShortDescription = By.xpath("//div[@class='overview']/div[@class='short-description']");
	private By productStockDescription = By.cssSelector("div.stock");
	private By productReviewDescription = By.cssSelector("div.product-review-links");
	private By productReviewLink = By.xpath("//div[@class='product-review-links']/a[contains (text(), 'review(s)')]");
	private By productAddReviewLink = By
			.xpath("//div[@class='product-review-links']/a[contains (text(), 'Add your review')]");
	private By productPrice = By.cssSelector("div.product-price");
	private By productQuantity = By.cssSelector("input.qty-input ");
	private By addToCartMessage = By.xpath("//div[@id='bar-notification']//p[@class='content']");
	private By productDescriptionParagraphText = By.xpath("//div[@class='full-description']/p");
	private By productTagsCount = By.xpath("//div[@class='product-tags-list']//li[@class='tag']");
	private By alsoPurchasedProductsGridheader = By
			.xpath("//strong[normalize-space()='Customers who bought this item also bought']");
	private By alsoPurchasedProductsList = By
			.xpath("//div[@class='also-purchased-products-grid product-grid']//div[@class='product-item']");
	private By productSpecificationDataTable = By.xpath("//table[@class='data-table']//tbody//tr");

	// Product Details Page Actions

	public boolean verifyProductHeaderExists() {
		boolean flag = eleUtil.isdisplayed(productHeader);
		return flag;
	}

	public String verifyProductHeaderText() {
		String text = eleUtil.dogetText(productHeader);
		System.out.println(text);
		return text;
	}

	public int verifyProductImageCount() {
		eleUtil.waitPresenceOfElement(productImage, AppConstants.DEFAULT_SHORT_TIME_OUT);
		int count = eleUtil.getTotalElementsCount(productImage);
		System.out.println("Total Image Count in Product Details Page is:" + count);
		return count;
	}

	public String getProductReviewCount() {
		eleUtil.waitPresenceOfElement(productReviewLink, AppConstants.DEFAULT_SHORT_TIME_OUT);
		String str = eleUtil.dogetText(productReviewLink);
		String[] splitString = str.split("\\s+");
		String getCount = splitString[0];
		System.out.println("Total Review count in the page is:" + getCount);
		return getCount;
	}

	public ProductReviewPage viewProductReview() {
		eleUtil.waitPresenceOfElement(productReviewLink, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(productReviewLink);
		return new ProductReviewPage(driver);
	}

	public ProductReviewPage addProductReview() {
		eleUtil.waitPresenceOfElement(productAddReviewLink, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.doclick(productAddReviewLink);
		return new ProductReviewPage(driver);
	}

	public String getProductDescriptionParagraph() {
		String text = eleUtil.dogetText(productDescriptionParagraphText);
		return text;
	}

	public Map<String, String> getProductSpecifications() {
		productSpecification = new LinkedHashMap<String, String>();

		// Verify Header of the Product
		productSpecification.put("productHeader", verifyProductHeaderText());
		getProductMetaData();
		getProductPriceData();
		getProductTagsData();
		System.out.println(productSpecification);
		return productSpecification;
	}

	private void getProductMetaData() {
		// get Product Short Description and store in the Map
		String prodShortDescription = eleUtil.dogetText(productShortDescription);
		productSpecification.put("productShortDescription", prodShortDescription);

		List<WebElement> stockMetaData = eleUtil.dofindElements(productStockDescription);
		for (WebElement e : stockMetaData) {
			String stockAvailabilitydata = e.getText();
			String stockInfo[] = stockAvailabilitydata.split(":");
			String key = stockInfo[0].trim();
			String value = stockInfo[1].trim();
			productSpecification.put(key, value);
		}

		String str = eleUtil.dogetText(productReviewLink);
		String[] splitString = str.split("\\s+");
		String reviewCount = splitString[0];
		System.out.println("Total Review count in the page is:" + reviewCount);
		productSpecification.put("ReviewCount", reviewCount);

	}

	private void getProductPriceData() {
		List<WebElement> productPriceData = eleUtil.dofindElements(productPrice);
		String price = productPriceData.get(0).getText();
		productSpecification.put("price", price);
	}

	private void getProductTagsData() {
		String tagName = eleUtil.getElementsText(productTagsCount).toString();
		productSpecification.put("Product Tags are", tagName);

	}

	public int countProductTags() {
		int count = eleUtil.getTotalElementsCount(productTagsCount);
		System.out.println("Total Product Tags Count in Product Details Page is:" + count);
		return count;
	}

	public void enterProductQuantity(int quantity) {
		System.out.println("Product Quantity is:" + quantity);
		eleUtil.dosendKeys(productQuantity, String.valueOf(quantity));
	}

	public String addProductToCart() {
		eleUtil.doclick(addToCartButton);
		String successMessage = eleUtil.waitVisibilityElement(addToCartMessage, AppConstants.DEFAULT_SHORT_TIME_OUT)
				.getText();
		System.out.println("The Success Message in after adding product in Product Details Page is:" + successMessage);
		return successMessage;
	}

	public String verifyPurchasedProductsGridheader() {
		String purchasedProductsGridheader = eleUtil.dogetText(alsoPurchasedProductsGridheader);
		System.out.println("Purchased Product Grid Header in Product Details Page is:" + purchasedProductsGridheader);
		return purchasedProductsGridheader;
	}

	public int getCountOfalsoPurchasedProductsList() {
		int countOfPurChasedProducts = eleUtil.getTotalElementsCount(alsoPurchasedProductsList);
		System.out.println(
				"Total count of also Purchase Products in Product Details Page is:" + countOfPurChasedProducts);
		return countOfPurChasedProducts;
	}

	public boolean ProductsSpecificationsdisplayed() {
		boolean flag = eleUtil.isdisplayed(productSpecificationDataTable);
		return flag;
	}

	public List<String> getProductsSpecificationsWebTableData() {
		List<WebElement> prodnames = eleUtil.dofindElements(productSpecificationDataTable);
		List<String> SpecList = new ArrayList<String>();
		for (WebElement e : prodnames) {
			String text = e.getText();
			SpecList.add(text);
		}
		System.out.println(SpecList);
		return SpecList;

	}

}
