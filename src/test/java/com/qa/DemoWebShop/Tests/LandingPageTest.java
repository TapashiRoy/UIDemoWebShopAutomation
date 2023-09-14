package com.qa.DemoWebShop.Tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.base.BaseClass;

public class LandingPageTest extends BaseClass {

	@Test
	public void getLandingPageTitleTest() {
		String actualtitle = lPage.getLandingPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.HOME_PAGE__TITLE_VALUE);
	}

	@Test
	public void getLandingPageURLTest() {
		String actualURL = lPage.getLandingPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.HOME_PAGE_URL_FRACTION_VALUE));
	}

	@Test
	public void getLandingPageWelcomeMessageTest() {
		String actMsg = lPage.getWelcomeMessage();
		Assert.assertEquals(actMsg, AppConstants.WELCOME_TEXT_VALUE);

	}

	@Test
	public void footerMenuHeadersTest() {
		int count = lPage.getTotalFooterMenuItemsCount();
		List<String> footerLinksInformationSection = lPage.getFooterHeadersText();
		Assert.assertEquals(count, AppConstants.FOOTER_MENU_COUNT);
		Assert.assertEquals(footerLinksInformationSection, AppConstants.FOOTER_MENU_HEADERS);
	}

	@Test
	public void footerLinksInformationSectionTest() {
		int count = lPage.getInformationFooterSectionCount();
		List<String> footerLinksInformationSection = lPage.getInformationFooterSectionText();
		Assert.assertEquals(count, AppConstants.FOOTER_MENU_INFORMATION_COLUMN_COUNT);
		Assert.assertEquals(footerLinksInformationSection, AppConstants.FOOTER_MENU_LINKS_UNDER_INFORMATION_COLUMN);
	}

	@Test
	public void footerLinksCustomerServiceSectionTest() {
		int count = lPage.getCustomerServiceFooterSectionCount();
		List<String> footerLinksCustomerServiceSection = lPage.getCustomerServiceFooterSectionText();
		Assert.assertEquals(count, AppConstants.FOOTER_MENU_CUSTOMER_SERVICE_COLUMN_COUNT);
		Assert.assertEquals(footerLinksCustomerServiceSection,
				AppConstants.FOOTER_MENU_LINKS_UNDER_CUSTOMER_SERVICE_COLUMN);
	}

	@Test
	public void footerLinksMyAccountSectionTest() {
		int count = lPage.getMyAccountFooterSectionCount();
		List<String> footerLinksMyAccountSection = lPage.getMyAccountFooterSectionText();
		Assert.assertEquals(count, AppConstants.FOOTER_MENU_MY_ACCOUNT_COLUMN_COUNT);
		Assert.assertEquals(footerLinksMyAccountSection, AppConstants.FOOTER_MENU_LINKS_UNDER_MY_ACCOUNT_COLUMN);
	}

	@Test
	public void footerLinksFollowUsSectionTest() {
		int count = lPage.getFollowUsFooterSectionCount();
		List<String> footerLinksFollowUsSection = lPage.getFollowUsFooterSectionText();
		Assert.assertEquals(count, AppConstants.FOOTER_MENU_FOLLOW_US_COLUMN_COUNT);
		Assert.assertEquals(footerLinksFollowUsSection, AppConstants.FOOTER_MENU_LINKS_UNDER_FOLLOW_US_COLUMN);
	}

	@Test
	public void footerMenuDisclaimerTest() {
		String footerText = lPage.getFooterDisclaimerText();
		Assert.assertEquals(footerText, AppConstants.FOOTER_MENU_DISCLAIMER);
	}

	@Test
	public void verifyFooterLinksTest() {
		try {
			lPage.verifyFooterLinks();
		} catch (IOException e) {
			Assert.fail("The link is not working");
		}
	}

	@Test
	public void verifyPopularTagsTest() {
		try {
			lPage.verifyPopularTags();
		} catch (IOException e) {
			Assert.fail("The tag is not working");
		}
	}

	@Test
	public void popularTagsTest() {
		int count = lPage.countPopularTags();
		List<String> tagsText = lPage.getPopularTagsNames();
		Assert.assertEquals(count, AppConstants.POPULAR_TAGS_COUNT);
		Assert.assertEquals(tagsText, AppConstants.POPULAR_TAGS_TEXT);
	}

	@Test
	public void communityPollTest() {
		int count = lPage.verifyCommunityPollOptionsCount();
		List<String> pollText = lPage.verifyCommunityPollOptionsText();
		Assert.assertEquals(count, AppConstants.POLL_COUNT);
		Assert.assertEquals(pollText, AppConstants.POLL_OPTIONS);
	}

	@DataProvider
	public Object[][] communityPollData() {
		return new Object[][] { { "Please select an answer" } };
	}

	@Test(dataProvider = "communityPollData")
	public void communityPollErrorWhenNoPollOptionSelectedTest(String errorMsg) {
		String text = lPage.verifyErrorMessageWhenNoPollOptionIsSelected();
		Assert.assertEquals(text, errorMsg);
	}

	@Test
	public void verifySliderAction() {
		lPage.sliderAction();
	}

}
