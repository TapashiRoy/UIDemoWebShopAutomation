package com.qa.DemoWebShop.Tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.base.BaseClass;

public class RegisterPageTest extends BaseClass {

	@BeforeClass
	public void setUpRegisterPage() {
		rPage = lPage.doClickRegisterLink();
	}

	@Test
	public void registerPageTitleTest() {
		String actualtitle = rPage.getRegisterPageTitle();
		Assert.assertEquals(actualtitle, AppConstants.REGISTER_PAGE_TITLE_VALUE);
	}

	@Test
	public void registerPageURLTest() {
		String actualURL = rPage.getRegisterPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.REGISTER_PAGE_URL_FRACTION_VALUE));
	}

	@Test
	public void headerInRegisterPageTest() {
		String header = rPage.verifyRegisterPageHeader();
		Assert.assertEquals(header, "Register");
	}

	@Test
	public void subHeadingInRegisterPageTest() {
		String subHeading = rPage.verifyRegisterPageSubHeading();
		Assert.assertEquals(subHeading, "Your Personal Details");
	}

	@Test
	public void countOfRadioButtonsInRegisterPageTest() {
		int count = rPage.verifyRadioButtonsCountInRegisterPage();
		Assert.assertEquals(count, 2);
	}

	@Test
	public void maleRadioButtonExistsInRegisterPageTest() {
		boolean flag = rPage.verifyMaleRadioButtonInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void femaleRadioButtonExistsInRegisterPageTest() {
		boolean flag = rPage.verifyFemaleRadioButtonInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void firstNameExistsInRegisterPageTest() {
		boolean flag = rPage.verifyFirstNameInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void lastNameExistsInRegisterPageTest() {
		boolean flag = rPage.verifyLastNameInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void emailExistsInRegisterPageTest() {
		boolean flag = rPage.verifyEmailInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void passwordExistsInRegisterPageTest() {
		boolean flag = rPage.verifyPasswordInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void confirmPasswordExistsInRegisterPageTest() {
		boolean flag = rPage.verifyConfirmPasswordInRegisterPage();
		Assert.assertTrue(flag);
	}

	@Test
	public void registerButtonExistsInRegisterPageTest() {
		boolean flag = rPage.verifyRegisterButtonInRegisterPage();
		Assert.assertTrue(flag);
	}

	public String getRandomEmail() {
		String email = "automationDemoWebShop" + System.currentTimeMillis() + "@gmail.com";
		return email;
	}

	@DataProvider
	public Object[][] getRegisterTestData() {
		return new Object[][] { { "Female", "Jhuma", "Roy", "Test@1234" }, { "Male", "Sanjay", "Roy", "Test@2311" } };
	}

//	@DataProvider
//	public Object[][] getExcelDataForRegistration() {
//		Object[][] regData = ExcelUtil.getSheetData(AppConstants.REGISTER_SHEET_NAME);
//		return regData;
//	}

	@Test(dataProvider = "getRegisterTestData")
	public void doRegisterTest(String gender, String firstName, String lastName, String password) {
		String actualMsg = rPage.verifyUserRegistration(gender, firstName, lastName, getRandomEmail(), password);
		Assert.assertEquals(actualMsg, AppConstants.USER_REGISTRATION_MESSAGE);
	}

	@DataProvider
	public Object[][] getMandatoryFieldsData() {
		return new Object[][] { { "", "", "", "" }, };
	}

	@Test(dataProvider = "getMandatoryFieldsData")
	public void doErrorMessagesForMandatoryFieldsTest(String firstName, String lastName, String email,
			String password) {
		rPage.verifyMandatoryFieldsErrors(firstName, lastName, email, password);
		String firstNameErrorMsg = rPage.verifyErrorMessageFirstName();
		String lastNameErrorMsg = rPage.verifyErrorMessageLastName();
		String emailErrorMsg = rPage.verifyErrorMessageEmail();
		String pwdErrorMsg = rPage.verifyErrorMessagePasswordAndConfirmPassword();
		String cpwdErrorMsg = rPage.verifyErrorMessagePasswordAndConfirmPassword();
		softAssert.assertEquals(firstNameErrorMsg, AppConstants.FIRST_NAME_ERROR_MESSAGE);
		softAssert.assertEquals(lastNameErrorMsg, AppConstants.lAST_NAME_ERROR_MESSAGE);
		softAssert.assertEquals(emailErrorMsg, AppConstants.EMAIL_ERROR_MESSAGE);
		softAssert.assertEquals(pwdErrorMsg, AppConstants.PASSWORD_ERROR_MESSAGE);
		softAssert.assertEquals(cpwdErrorMsg, AppConstants.CONFIRMPASSWORD_ERROR_MESSAGE);

		softAssert.assertAll();

	}

}
