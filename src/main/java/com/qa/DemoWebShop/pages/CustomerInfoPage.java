package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.Utils.ElementUtil;

public class CustomerInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public CustomerInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Locators for CustomerInfo Page
	private By customerInfoPageHeader = By.cssSelector("div.page-title");
	private By formFields = By.cssSelector("div.form-fields >div.inputs");
	private By maleRadioButton = By.id("gender-male");
	private By femaleRadioButton = By.id("gender-female");
	private By firstNameField = By.id("FirstName");
	private By lastNameField = By.id("LastName");
	private By emailField = By.id("Email");
	private By saveButton = By.cssSelector("input[value='Save']");
	private By mandatoryFieldErrorMessage = By.xpath("//span[@class='field-validation-error']");

	// CustomerInfo Page Actions
	public String getCustomerInfoPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the CustomerInfo page is:" + title);
		return title;
	}

	public String getCustomerInfoPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the CustomerInfo page is:" + url);
		return url;
	}

	public String getCustomerInfoPageHeader() {
		String pageHeaderText = eleUtil.dogetText(customerInfoPageHeader);
		System.out.println("The Page Header of the CustomerInfo page is:" + pageHeaderText);
		return pageHeaderText;
	}

	public int getCountOfInputFieldsInCustomerInfoPage() {
		int count = eleUtil.getTotalElementsCount(formFields);
		System.out.println("The count of the Input Fields in the CustomerInfo page is:" + count);
		return count;
	}

	public String verifyErrorMessageForMandatoryFields(By field) {
		eleUtil.clearField(field);
		eleUtil.waitAndClick(saveButton, AppConstants.DEFAULT_SHORT_TIME_OUT);
		String text = eleUtil.dogetText(mandatoryFieldErrorMessage);
		return text;
	}

}
