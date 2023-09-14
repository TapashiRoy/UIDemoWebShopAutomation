package com.qa.DemoWebShop.Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.base.BaseClass;

public class ProductDetailsPageTest extends BaseClass {

	@BeforeClass
	public void setUpProductDetailsPage() {
		loginPage = lPage.doClickLoginLink();
		homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@DataProvider
	public Object[][] getProductImageDetails() {
		return new Object[][] { { "jewelry", "Create Your Own Jewelry", 1 }, { "computer", "Simple Computer", 4 } };
	}

	@Test(dataProvider = "getProductImageDetails")
	public void productImageCountTest(String productKey, String productLink, int countofImages) {
		sPage = homePage.performSearch(productKey);
		if (sPage.getProductSearchResultsCount() > 0) {
			pdPage = sPage.selectProduct(productLink);
			int actualcount = pdPage.verifyProductImageCount();
			Assert.assertEquals(actualcount, countofImages);
		}

	}

	@DataProvider
	public Object[][] getProductSpecificationDataTest() {
		return new Object[][] { { "Laptop", "14.1-inch Laptop", "14.1-inch Laptop", "In stock", "1590.00", "839",
				"[nice (6), computer (10), compact (3)]" } };
	}

	@Test(dataProvider = "getProductSpecificationDataTest")
	public void productSpecificationTest(String productKey, String productLink, String productHeader,
			String stockAvailability, String price, String reviewCount, String productTags) {
		System.out.println(productKey + productLink);
		sPage = homePage.performSearch(productKey);
		pdPage = sPage.selectProduct(productLink);
		Map<String, String> productInformationMap = pdPage.getProductSpecifications();
		softAssert.assertEquals(productInformationMap.get("productHeader"), productHeader);
		softAssert.assertEquals(productInformationMap.get("Availability"), stockAvailability);
		softAssert.assertEquals(productInformationMap.get("price"), price);
		softAssert.assertEquals(productInformationMap.get("ReviewCount"), reviewCount);
		softAssert.assertEquals(productInformationMap.get("Product Tags are"), productTags);

		softAssert.assertAll();
	}

	@DataProvider
	public Object[][] getTagCountData() {
		return new Object[][] { { "computer", "Build your own computer", 2 } };
	}

	@Test(dataProvider = "getTagCountData")
	public void productTagsCountTest(String productKey, String productLink, int count) {
		sPage = homePage.performSearch(productKey);
		if (sPage.getProductSearchResultsCount() > 0) {
			pdPage = sPage.selectProduct(productLink);
			int tagsCount = pdPage.countProductTags();
			Assert.assertEquals(tagsCount, count);
		}
	}

	@DataProvider
	public Object[][] getProductGridData() {
		return new Object[][] { { "computer", "Build your own computer" } };
	}

	@Test(dataProvider = "getProductGridData")
	public void purchasedProductsGridheaderTitleTest(String productKey, String productLink) {
		sPage = homePage.performSearch(productKey);
		if (sPage.getProductSearchResultsCount() > 0) {
			pdPage = sPage.selectProduct(productLink);
			String headerTitle = pdPage.verifyPurchasedProductsGridheader();
			Assert.assertEquals(headerTitle, AppConstants.PURCHASED_PRODUCT_GRID_HEADER_TITLE);
		}
	}

	@DataProvider
	public Object[][] getPurchasedProductsListData() {
		return new Object[][] { { "computer", "Build your own computer", 3 } };
	}

	@Test(dataProvider = "getPurchasedProductsListData")
	public void purchasedProductsListTest(String productKey, String productLink, int count) {
		sPage = homePage.performSearch(productKey);
		if (sPage.getProductSearchResultsCount() > 0) {
			pdPage = sPage.selectProduct(productLink);
			int prodCount = pdPage.getCountOfalsoPurchasedProductsList();
			Assert.assertEquals(prodCount, count);
		}
	}

	@DataProvider
	public Object[][] getproductsSpecificationData() {
		return new Object[][] { { "laptop", "14.1-inch Laptop", "Screensize 14.1''", "CPU Type Intel", "Memory 3 GB",
				"Hardrive 250 GB" } };
	}

	@Test(dataProvider = "getproductsSpecificationData")
	public void productsSpecificationTest(String productKey, String productLink, String specScreen,
			String specProcessor, String specMemory, String specDrive) {
		sPage = homePage.performSearch(productKey);
		pdPage = sPage.selectProduct(productLink);
		List<String> expectedProdSpecList = new ArrayList<>(Arrays.asList("" + specScreen + "", "" + specProcessor + "",
				"" + specMemory + "", "" + specDrive + ""));
		if (pdPage.ProductsSpecificationsdisplayed()) {
			List<String> actualProductSpecList = pdPage.getProductsSpecificationsWebTableData();
			Assert.assertEquals(actualProductSpecList, expectedProdSpecList);
		}
	}

	@DataProvider
	public Object[][] getAddToCartData() {
		return new Object[][] {
				{ "laptop", "14.1-inch Laptop", 2, "The product has been added to your shopping cart" } };
	}

	@Test(dataProvider = "getAddToCartData")
	public void addToCartTest(String productKey, String productLink, int quantity, String successMsg) {
		sPage = homePage.performSearch(productKey);
		if (sPage.getProductSearchResultsCount() > 0) {
			pdPage = sPage.selectProduct(productLink);
			pdPage.enterProductQuantity(quantity);
			String expectedSuccessMessage = pdPage.addProductToCart();
			Assert.assertEquals(expectedSuccessMessage, successMsg);
		}

	}

}
