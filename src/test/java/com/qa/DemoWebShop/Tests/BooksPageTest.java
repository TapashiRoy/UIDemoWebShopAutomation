package com.qa.DemoWebShop.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.base.BaseClass;

public class BooksPageTest extends BaseClass {
	@BeforeClass
	public void setUpBooksPage() {
		bPage = lPage.doClickBooksInTopMenu();
	}

	@Test(priority = 1)
	public void getbooksPageTitleTest() {
		String actualtitle = bPage.getBooksPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.BOOKS_PAGE_TITLE_VALUE);
	}

	@Test
	public void booksPageURLTest() {
		String actualURL = bPage.getBooksPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.BOOKS_PAGE_URL_FRACTION_VALUE));
	}

	@Test
	public void booksPageHeadersTest() {
		List<String> headerValues = bPage.verifyBooksPageHeaders();
		System.out.println("The header values are:" + headerValues);
		Assert.assertEquals(headerValues, AppConstants.PAGE_HEADERS_ACROSS_ALL_PAGES);
	}

	@Test
	public void booksPageBreadcrumbTest() {
		boolean flag = bPage.verifyBooksPageBreadcumbIsDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void booksPageTitleTest() {
		boolean flag = bPage.verifyBooksPageTitleIsDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void FilterLinksdisplayTest() {
		boolean flag = bPage.verifyFilterLinksAreDisplayed();
		Assert.assertTrue(flag);
	}

	@Test
	public void countFiltersTest() {
		int count = bPage.countFilterLinks();
		Assert.assertEquals(count, AppConstants.FILTER_LINKS_COUNT);
	}

	@Test
	public void booksPageTitleTextTest() {
		String text = bPage.verifyBooksPageTitleText();
		Assert.assertTrue(text.contains("Books"));
	}

	@Test
	public void valuesInSortingListTest() {
		List<String> ActualValues = bPage.verifyAllValuesInSortingList();
		System.out.println(ActualValues);
		Assert.assertEquals(ActualValues, AppConstants.PAGE_SORTING_LIST);
	}

	@Test
	public void countInSortingListTest() {
		int count = bPage.verifyCountInSortingList();
		Assert.assertEquals(count, AppConstants.PAGE_SORTING_LIST_COUNT);
	}

	@Test
	public void valuesInDisplayListTest() {
		List<String> ActualValues = bPage.verifyAllValuesInDisplayList();
		System.out.println(ActualValues);
		Assert.assertEquals(ActualValues, AppConstants.PAGE_DISPLAY_LIST);
	}

	@Test
	public void countInDisplayListTest() {
		int count = bPage.verifyCountInDisplayList();
		Assert.assertEquals(count, AppConstants.PAGE_DISPLAY_LIST_COUNT);
	}

	@Test
	public void valuesInViewListTest() {
		List<String> ActualValues = bPage.verifyAllValuesInViewList();
		System.out.println(ActualValues);
		Assert.assertEquals(ActualValues, AppConstants.PAGE_VIEW_LIST);
	}

	@Test
	public void countInViewListTest() {
		int count = bPage.verifyCountInViewList();
		Assert.assertEquals(count, AppConstants.PAGE_VIEW_LIST_COUNT);
	}

	@Test
	public void featuredBooksCountTest() {
		int count = bPage.verifyCountOfFeaturedBooks();
		Assert.assertEquals(count, 6);
	}

	@Test
	public void filterUnder25Test() {
		int count = bPage.filterActionUnder25();
		Assert.assertEquals(count, 5);
	}

}
