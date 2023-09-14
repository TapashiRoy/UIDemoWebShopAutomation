package com.qa.DemoWebShop.Tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.base.BaseClass;

public class GiftsCardsPageTest extends BaseClass {
	@BeforeClass
	public void setUpBooksPage() {
		gPage = lPage.doClickGiftCardsInTopMenu();
	}

	@Test
	public void valuesInSortingListTest() {

	}

}
