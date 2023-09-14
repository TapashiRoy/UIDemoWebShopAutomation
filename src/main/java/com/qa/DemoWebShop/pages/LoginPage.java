package com.qa.DemoWebShop.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.DemoWebShop.Utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for Login Page
	private By loginPageHeaders = By.cssSelector("div.title");
	private By returningCustomerHeading = By.xpath("//strong[normalize-space()='Returning Customer']");
	private By emailId = By.id("Email");
	private By password = By.id("Password");
	private By rememberMeCheckbox = By.id("RememberMe");
	private By forgotPasswordLink = By.xpath("//a[normalize-space()='Forgot password?']");
	private By loginButton = By.xpath("//input[@value='Log in']");
	private By registerButton = By.xpath("//input[@value='Register']");
	private By errorMessageInvalidPassword = By.cssSelector("div.message-error");
	private By errorMessageInvalidEmail = By.cssSelector("div.validation-summary-errors");
	private By errorMessageEmailWithoutFormat = By
			.xpath("//span[@for='Email' and text()='Please enter a valid email address.']");

	// **************-----Locators for NewsLetter
	// Section-------**************************
	private By newsletterText = By.xpath("//span[normalize-space()='Sign up for our newsletter:']");
	private By newsletterBlock = By.cssSelector("div.block-newsletter");
	private By newsletterSignUpField = By.id("newsletter-email");
	private By newsletterSignUpButton = By.id("newsletter-subscribe-button");
	private By subscribeErrorMessage = By.cssSelector("div.newsletter-result-block");

	// Login Page Actions
	public String getLoginPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Login page is:" + title);
		return title;
	}

	public String getLoginPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Login page is:" + url);
		return url;
	}

	public int verifyLoginPageHeaders() {
		int headerCount = eleUtil.getTotalElementsCount(loginPageHeaders);
		System.out.println("The header count of the Login page is:" + headerCount);
		return headerCount;
	}

	public List<String> verifyLoginPageHeaderText() {
		List<String> eTextList = new ArrayList<String>();
		List<WebElement> headers = eleUtil.dofindElements(loginPageHeaders);
		for (WebElement e : headers) {
			String text = e.getText();
			eTextList.add(text);
		}
		return eTextList;
	}

	public boolean isForgotPasswordLinkExists() {
		boolean flag = eleUtil.isdisplayed(forgotPasswordLink);
		return flag;
	}

	public void sendKeysAndClickLoginPage(String emailid, String pwd) {
		eleUtil.dosendKeys(emailId, emailid);
		eleUtil.dosendKeys(password, pwd);
		eleUtil.doclick(loginButton);
	}

	@Step("login Test with email:{0} and password:{1}")
	// This Method will return the Homepage after user clicks on Login Button
	public HomePage doLogin(String emailid, String pwd) {
		sendKeysAndClickLoginPage(emailid, pwd);
		return new HomePage(driver);
	}

	// Login was unsuccessful. Please correct the errors and try again.The
	// credentials provided are incorrect
	public String doLoginIncorrectPassword(String emailid, String pwd) {
		sendKeysAndClickLoginPage(emailid, pwd);
		String text = eleUtil.dogetText(errorMessageInvalidPassword);
		return text;
	}

	// Error Message - Login was unsuccessful. Please correct the errors and try
	// again.
	public String doLoginIncorrectEmail(String emailid, String pwd) {
		sendKeysAndClickLoginPage(emailid, pwd);
		String text = eleUtil.dogetText(errorMessageInvalidEmail);
		return text;
	}

	// Both Incorrect credentials - Login was unsuccessful. Please correct the
	// errors and try again.No customer account found
	public void doLoginIncorrectCredentials(String emailid, String pwd) {
		doLoginIncorrectEmail(emailid, pwd);
	}

	// Email without .com - Please enter a valid email address
	public String doLoginEmailFormatWithoutDotCom(String emailid) {
		eleUtil.dosendKeys(emailId, emailid);
		eleUtil.dosendKeysTAB(emailId);
		String text = eleUtil.dogetText(errorMessageEmailWithoutFormat);
		return text;
	}

	// Email without @ - Please enter a valid email address
	public String doLoginEMailFormatissue(String emailid) {
		eleUtil.dosendKeys(emailId, emailid);
		eleUtil.dosendKeysTAB(emailId);
		String text = eleUtil.dogetText(errorMessageEmailWithoutFormat);
		return text;
	}

	public boolean isRegisterButtonExists() {
		boolean flag = eleUtil.isdisplayed(registerButton);
		return flag;
	}

	public boolean isRememberMeCheckboxState() {
		boolean flag = eleUtil.isSelected(rememberMeCheckbox);
		return flag;
	}

	public boolean isreturningCustomerHeadingExists() {
		boolean flag = eleUtil.isdisplayed(returningCustomerHeading);
		return flag;
	}

	public String getNewsLetterText() {
		String text = eleUtil.dogetText(newsletterText);
		return text;

	}

	public void doSubscribeInLoginPage(String email) {
		eleUtil.dosendKeys(newsletterSignUpField, email);
		eleUtil.doclick(newsletterSignUpButton);

	}

	// Error Message when we don't enter Email and click on Subsribe button
	public String doSubsribeWithoutEmail() {
		eleUtil.doclick(newsletterSignUpButton);
		String text = eleUtil.dogetText(subscribeErrorMessage);
		return text;
	}

}
