package com.qa.DemoWebShop.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.base.BaseClass;

public class HomePageTest extends BaseClass {

	@BeforeClass
	public void setUpHomePage() {
		loginPage = lPage.doClickLoginLink();
		homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}

	@Test
	public void homePageTitleTest() {
		String actualtitle = homePage.getHomePageTitle();
		Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE__TITLE_VALUE);
	}

	@Test
	public void homePageURLTest() {
		String actualURL = homePage.getHomePageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.HOME_PAGE_URL_FRACTION_VALUE));
	}

	@Test
	public void homePageAccountHeaderExistsTest() {
		boolean flag = homePage.isheaderAccountLinkExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void homePageLogoutLinkExistsTest() {
		boolean flag = homePage.islogOutLinkExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void homePageShoppingCartLinkExistsTest() {
		boolean flag = homePage.isshoppingCartLinkExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void homePagewishlistLinkExistsTest() {
		boolean flag = homePage.iswishlistLinkExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void searchFieldExistsTest() {
		boolean flag = homePage.isSearchFieldExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void searchButtonExistsTest() {
		boolean flag = homePage.isSearchButtonExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void getSearchFieldTextTest() {
		String text = homePage.getTextAttributeFromSearchField();
		Assert.assertEquals(text, AppConstants.SEARCH_TEXT_VALUE);
	}

	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] { { "jewelry" }, { "computer" } };
	}

	@Test(dataProvider = "getProductData")
	public void productSearchCountTest(String productKey) {
		sPage = homePage.performSearch(productKey);
		Assert.assertTrue(sPage.getProductSearchResultsCount() > 0);
	}

	@DataProvider
	public Object[][] getProductDetails() {
		return new Object[][] { { "jewelry", "Create Your Own Jewelry", "Create Your Own Jewelry" },
				{ "computer", "Build your own computer", "Build your own computer" } };
	}

	@Test(dataProvider = "getProductDetails")
	public void selectProductTest(String ProductKey, String productLink, String ProductHeaderText) {
		sPage = homePage.performSearch(ProductKey);
		if (sPage.getProductSearchResultsCount() > 0) {
			pdPage = sPage.selectProduct(productLink);
			String productHeaderValue = pdPage.verifyProductHeaderText();
			Assert.assertEquals(productHeaderValue, ProductHeaderText);
		}
	}

}
