package com.qa.DemoWebShop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

	private WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
	}

	By breadcrumbBooksPage = By.cssSelector("div.breadcrumb");
	By titleForgotPasswordPage = By.cssSelector("div.page-title");

	public String getBooksPageTitle() {
		String myupdatedtitle = driver.getTitle();
		System.out.println("The title of the ForgotPassword page is:" + myupdatedtitle);
		return mytitle;
	}

}
