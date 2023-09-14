package com.qa.DemoWebShop.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.base.BaseClass;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC - DemoWebShop Login")
@Story("US-Login Page Features for Login Feature")
public class LoginPageTest extends BaseClass {

	@BeforeClass
	public void setUploginPage() {
		loginPage = lPage.doClickLoginLink();
	}

	@Severity(SeverityLevel.TRIVIAL)
	@Description("This method will get Title of the Page")
	@Test
	public void loginPageTitleTest() {
		String actualtitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}

	@Severity(SeverityLevel.NORMAL)
	@Test
	public void loginPageURLTest() {
		String actualURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}

	@Severity(SeverityLevel.BLOCKER)
	@Test
	public void loginPageForgotPasswordLinkExistsTest() {
		boolean flag = loginPage.isForgotPasswordLinkExists();
		Assert.assertTrue(flag);
	}

	@Severity(SeverityLevel.CRITICAL)
	@Test
	public void loginTest() {
		homePage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(homePage.islogOutLinkExists());
	}

	@Test
	public void loginPageRegisterButtonExistsTest() {
		boolean flag = loginPage.isRegisterButtonExists();
		Assert.assertTrue(flag);
	}

	@Test
	public void loginPageRememberMeCheckBoxExistsTest() {
		boolean flag = loginPage.isRememberMeCheckboxState();
		Assert.assertFalse(flag);
	}

	@Test
	public void loginPagereturningCustomerHeadingExistsTest() {
		boolean flag = loginPage.isreturningCustomerHeadingExists();
		Assert.assertTrue(flag);
	}

}
