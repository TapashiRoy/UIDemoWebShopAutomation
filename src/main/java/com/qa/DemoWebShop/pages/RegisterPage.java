package com.qa.DemoWebShop.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.Utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Register Page
	private By registerHeader = By.xpath("//h1[normalize-space()='Register']");
	private By headerAccountLink = By.xpath("//div[@class='header-links']//a[@class='account']");
	private By logOutLink = By.xpath("//a[@class='ico-logout']");
	private By registerLink = By.cssSelector("div.header-links a.ico-register");
	private By personalDetailsSubHeading = By.xpath("//div[@class='title']/strong[text()='Your Personal Details']");
	private By gender = By.cssSelector("div.gender");
	private By maleRadioButton = By.id("gender-male");
	private By femaleRadioButton = By.id("gender-female");
	private By firstName = By.id("FirstName");
	private By lastName = By.id("LastName");
	private By email = By.id("Email");
	private By password = By.id("Password");
	private By confirmPassword = By.id("ConfirmPassword");
	private By registerButton = By.id("register-button");
	private By continueButton = By.cssSelector("input.register-continue-button");
	private By successMessage = By.xpath("//div[@class='result']");
	private By firstNameErrorMessage = By.xpath("//span[@for='FirstName']");
	private By lastNameErrorMessage = By.xpath("//span[@for='LastName']");
	private By emailErrorMessage = By.xpath("//span[@for='Email']");
	private By passwordAndConfirmPasswordErrorMessage = By.xpath("//span[@for='Password']");

	// Register Page Actions
	public String getRegisterPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Register page is:" + title);
		return title;
	}

	public String getRegisterPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Register page is:" + url);
		return url;
	}

	public String verifyRegisterPageHeader() {
		String text = eleUtil.dogetText(registerHeader);
		return text;
	}

	public String verifyRegisterPageSubHeading() {
		String text = eleUtil.dogetText(personalDetailsSubHeading);
		return text;
	}

	public int verifyRadioButtonsCountInRegisterPage() {
		int count = eleUtil.getTotalElementsCount(gender);
		return count;
	}

	public boolean verifyMaleRadioButtonInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(maleRadioButton);
		return flag;
	}

	public boolean verifyFemaleRadioButtonInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(femaleRadioButton);
		return flag;
	}

	public boolean verifyFirstNameInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(firstName);
		return flag;
	}

	public boolean verifyLastNameInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(lastName);
		return flag;
	}

	public boolean verifyEmailInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(email);
		return flag;
	}

	public boolean verifyPasswordInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(password);
		return flag;
	}

	public boolean verifyConfirmPasswordInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(confirmPassword);
		return flag;
	}

	public boolean verifyRegisterButtonInRegisterPage() {
		boolean flag = eleUtil.isdisplayed(registerButton);
		return flag;
	}

	public String verifyErrorMessageFirstName() {
		String text = eleUtil.dogetText(firstNameErrorMessage);
		return text;
	}

	public String verifyErrorMessageLastName() {
		String text = eleUtil.dogetText(lastNameErrorMessage);
		return text;
	}

	public String verifyErrorMessageEmail() {
		String text = eleUtil.dogetText(emailErrorMessage);
		return text;
	}

	public String verifyErrorMessagePasswordAndConfirmPassword() {
		String text = eleUtil.dogetText(passwordAndConfirmPasswordErrorMessage);
		return text;
	}

	public void verifyMandatoryFieldsErrors(String fName, String lName, String emailID, String pwd) {
		eleUtil.waitVisibilityElement(registerHeader, AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.dosendKeys(firstName, fName);
		eleUtil.dosendKeys(firstName, fName);
		eleUtil.dosendKeys(lastName, lName);
		eleUtil.dosendKeys(email, emailID);
		eleUtil.dosendKeys(password, pwd);
		eleUtil.dosendKeys(confirmPassword, pwd);
		eleUtil.waitAndClick(registerButton, AppConstants.DEFAULT_SHORT_TIME_OUT);
	}

	public String verifyUserRegistration(String gender, String fName, String lName, String emailID, String pwd) {
		eleUtil.waitVisibilityElement(registerHeader, AppConstants.DEFAULT_SHORT_TIME_OUT);
		if (gender.equalsIgnoreCase("Male")) {
			eleUtil.doclick(maleRadioButton);
		} else {
			eleUtil.doclick(femaleRadioButton);
		}
		eleUtil.dosendKeys(firstName, fName);
		eleUtil.dosendKeys(firstName, fName);
		eleUtil.dosendKeys(lastName, lName);
		eleUtil.dosendKeys(email, emailID);
		eleUtil.dosendKeys(password, pwd);
		eleUtil.dosendKeys(confirmPassword, pwd);

		eleUtil.waitAndClick(registerButton, AppConstants.DEFAULT_SHORT_TIME_OUT);
		/**
		 * After successful completion of Registration, user will receive a "Your
		 * registration completed" message
		 */
		String text = eleUtil.waitVisibilityElement(successMessage, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		String accountHeader = eleUtil.waitVisibilityElement(headerAccountLink, AppConstants.DEFAULT_SHORT_TIME_OUT)
				.getText();

		eleUtil.doclick(continueButton);
		eleUtil.doclick(logOutLink);
		eleUtil.doclick(registerLink);
		List<String> registerdata = Arrays.asList(text, accountHeader);
		System.out.println("User Registration data is:" + registerdata);
		return text;

	}

}
