package com.qa.DemoWebShop.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.qa.DemoWebShop.Factory.DriverFactory;
import com.qa.DemoWebShop.pages.BooksPage;
import com.qa.DemoWebShop.pages.GiftCardsPage;
import com.qa.DemoWebShop.pages.HomePage;
import com.qa.DemoWebShop.pages.LandingPage;
import com.qa.DemoWebShop.pages.LoginPage;
import com.qa.DemoWebShop.pages.ProductDetailsPage;
import com.qa.DemoWebShop.pages.RegisterPage;
import com.qa.DemoWebShop.pages.SearchPage;
import com.qa.DemoWebShop.pages.ShoppingCartPage;

public class BaseClass {

	DriverFactory driverFactor;
	WebDriver driver;
	protected Properties prop;
	protected LandingPage lPage;
	protected LoginPage loginPage;
	protected RegisterPage rPage;
	protected HomePage homePage;
	protected BooksPage bPage;
	protected GiftCardsPage gPage;
	protected SearchPage sPage;
	protected ProductDetailsPage pdPage;
	protected ShoppingCartPage cartPage;
	protected SoftAssert softAssert;

	/**
	 * We are passing prop here, so that browser specific properties can be picked
	 * while execution
	 * 
	 * @throws IOException
	 */
	@BeforeTest
	public void setup() throws IOException {
		driverFactor = new DriverFactory();
		prop = driverFactor.initProperties();
		driver = driverFactor.initDriver(prop);
		lPage = new LandingPage(driver);
		softAssert = new SoftAssert();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
