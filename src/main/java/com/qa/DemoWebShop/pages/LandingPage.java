package com.qa.DemoWebShop.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.DemoWebShop.Constants.AppConstants;
import com.qa.DemoWebShop.Utils.ElementUtil;

public class LandingPage {
	private WebDriver driver;
	private ElementUtil eleUtil;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// *****--Locator for Welcome Message and logo when we land on Demo Web Shop
	private By welcomeMessage = By.cssSelector(".topic-html-content-body");
	private By demoWebShopLogo = By.xpath("//a/img[@alt='Tricentis Demo Web Shop']");
	private By slider = By.id("nivo-slider");
	private By prevSlide = By.xpath("//a[normalize-space()='Prev']");
	private By afterSlide = By.xpath("//a[normalize-space()='Next']");

	// *********--Locator for Popular Tags Section--*******
	private By allTags = By.xpath("//div[@class='tags']//a");
	private By viewAllLink = By.xpath("//div[@class='view-all']//a[text()='View all']");

	// *********--Locator for Community Poll Section--*******
	private By pollOptions = By.xpath("//label[normalize-space()='Excellent']");
	private By pollMessage = By.cssSelector("div.poll strong.poll-display-text");
	private By voteButton = By.id("vote-poll-1");

	// *********--Locators for Landing Page header Menu Items********
	private By registerLink = By.cssSelector("div.header-links a.ico-register");
	private By loginLink = By.cssSelector("div.header-links a.ico-login");
	private By shoppingCartLink = By.cssSelector("div.header-links a.ico-cart");
	private By wishListLink = By.cssSelector("div.header-links a.ico-wishlist");

	// *********--Locators for Top-Menu Menu and SubMenu Items********
	private By booksTopMenuLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Books']");
	private By electronicsTopMenuLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']");
	private By computersTopMenuLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Computers']");
	private By apparelShoesTopMenuLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Apparel & Shoes']");
	private By digitalDownloadsTopMenuLink = By
			.xpath("//ul[@class='top-menu']//a[normalize-space()='Digital downloads']");
	private By jewelryTopMenuLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Jewelry']");
	private By giftCardsTopMenuLink = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Gift Cards']");

	// **********************--Sub-Menu Items*****************
	private By desktopSubMenuLink = By.xpath("//a[@class='hover'][normalize-space()='Desktops']");
	private By notebooksSubMenuLink = By.xpath("//a[@class='hover'][normalize-space()='Notebooks']");
	private By accessoriesSubMenuLink = By.xpath("//a[@class='hover'][normalize-space()='Accessories']");
	private By cameraPhotoSubMenuLink = By.xpath("//a[@class='hover'][normalize-space()='Camera, photo']");
	private By cellPhonesSubMenuLink = By
			.xpath("//ul[@class='sublist firstLevel active']//li[normalize-space()='Cell phones']");

	// ******-----Locators for list Categories-------*******

	private By categoriesListMenu = By.xpath("//strong[normalize-space()='Categories']");
	private By booksListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Books']");
	private By computersListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Computers']");
	private By electronicsListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Electronics']");
	private By apparelShoesListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Apparel & Shoes']");
	private By digitalDownloadsListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Digital downloads']");
	private By jewelryListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Jewelry']");
	private By giftCardsListMenuItem = By.xpath("//ul[@class='list']//a[normalize-space()='Gift Cards']");

	// **********************--Sub-Menu Items*****************
	private By desktopListSubMenuItem = By.xpath("//li[@class='inactive']//a[normalize-space()='Desktops']");
	private By notebooksListSubMenuItem = By.xpath("//li[@class='inactive']//a[normalize-space()='Notebooks']");
	private By accessoriesListSubMenuItem = By.xpath("//li[@class='inactive']//a[normalize-space()='Accessories']");
	private By cameraPhotoListSubMenuItem = By.xpath("//li[@class='inactive']//a[normalize-space()='Camera, photo']");
	private By cellPhonesListSubMenuItem = By.xpath("//li[@class='inactive']//a[normalize-space()='Cell phones']");

	// *******-----Locators for Featured Products Section-------********
	private By featuredProductsSection = By.cssSelector("div.home-page-product-grid>div.item-box");
	private By productsList = By.xpath("//div[@class='product-grid home-page-product-grid']//h2");

	// *******-----Locators for Footer Section-------********
	private By footerMenu = By.xpath("//div[@class='footer']//a");
	private By footerMenuHeaders = By.xpath("//div[@class='footer-menu-wrapper']//h3");
	private By informationFooterSection = By.xpath("//div[@class='column information']//li");
	private By customerServiceFooterSection = By.xpath("//div[@class='column customer-service']//li");
	private By myAccountFooterSection = By.xpath("//div[@class='column my-account']//li");
	private By followUsFooterSection = By.xpath("//div[@class='column follow-us']//li");
	private By footerCopyrightDescription = By.cssSelector("div.footer-disclaimer");

	// **************-----Landing Page Actions**************************

	public String getLandingPageTitle() {
		String title = driver.getTitle();
		System.out.println("The title of the Landing page is:" + title);
		return title;
	}

	public String getLandingPageURL() {
		String url = driver.getCurrentUrl();
		System.out.println("The URL of the Login page is:" + url);
		return url;
	}

	public String getWelcomeMessage() {
		String text = driver.findElement(welcomeMessage).getText();
		return text;
	}

	public boolean isDemoWebShopLogoExists() {
		boolean flag = driver.findElement(demoWebShopLogo).isDisplayed();
		return flag;
	}

	public void sliderAction() {
		eleUtil.doActionsClick(prevSlide);
		eleUtil.doActionsClick(afterSlide);
	}

	public boolean isRegisterLinkExits() {
		boolean flag = driver.findElement(registerLink).isDisplayed();
		return flag;
	}

	public RegisterPage doClickRegisterLink() {
		driver.findElement(registerLink).click();
		return new RegisterPage(driver);
	}

	public LoginPage doClickLoginLink() {
		driver.findElement(loginLink).click();
		return new LoginPage(driver);

	}

	public boolean isBooksInTopMenuDisplayed() {
		boolean flag = driver.findElement(booksTopMenuLink).isDisplayed();
		return flag;
	}

	public BooksPage doClickBooksInTopMenu() {
		driver.findElement(booksTopMenuLink).click();
		return new BooksPage(driver);
	}

	public boolean isComputersInTopMenuDisplayed() {
		boolean flag = driver.findElement(computersTopMenuLink).isDisplayed();
		return flag;
	}

	public ComputersPage doClickComputersInTopMenu() {
		driver.findElement(computersTopMenuLink).click();
		return new ComputersPage(driver);
	}

	public boolean isElectronicsInTopMenuDisplayed() {
		boolean flag = driver.findElement(electronicsTopMenuLink).isDisplayed();
		return flag;
	}

	public ElectronicsPage doClickElectronicsInTopMenu() {
		driver.findElement(electronicsTopMenuLink).click();
		return new ElectronicsPage(driver);
	}

	public boolean isApparelsAndShoesInTopMenuDisplayed() {
		boolean flag = driver.findElement(apparelShoesTopMenuLink).isDisplayed();
		return flag;
	}

	public ApparelsAndShoesPage doClickApparelsAndShoesInTopMenu() {
		driver.findElement(apparelShoesTopMenuLink).click();
		return new ApparelsAndShoesPage(driver);

	}

	public boolean isDigitalDownloadsInTopMenuLinkTopMenuDisplayed() {
		boolean flag = driver.findElement(digitalDownloadsTopMenuLink).isDisplayed();
		return flag;
	}

	public DigitalDownloadsPage doClickDigitalDownloadsInTopMenu() {
		driver.findElement(digitalDownloadsTopMenuLink).click();
		return new DigitalDownloadsPage(driver);
	}

	public boolean isJewelryInTopMenuLinkTopMenuDisplayed() {
		boolean flag = driver.findElement(jewelryTopMenuLink).isDisplayed();
		return flag;
	}

	public JewelryPage doClickJewelryInTopMenu() {
		driver.findElement(jewelryTopMenuLink).click();
		return new JewelryPage(driver);
	}

	public boolean isGiftCardsInTopMenuLinkTopMenuDisplayed() {
		boolean flag = driver.findElement(giftCardsTopMenuLink).isDisplayed();
		return flag;
	}

	public GiftCardsPage doClickGiftCardsInTopMenu() {
		driver.findElement(giftCardsTopMenuLink).click();
		return new GiftCardsPage(driver);
	}

	public boolean isCategoriesInLeftMenuDisplayed() {
		boolean flag = driver.findElement(categoriesListMenu).isDisplayed();
		return flag;
	}

	public boolean isBooksInLeftMenuDisplayed() {
		boolean flag = driver.findElement(booksListMenuItem).isDisplayed();
		return flag;
	}

	public BooksPage doClickBooksInLeftMenu() {
		driver.findElement(booksListMenuItem).click();
		return new BooksPage(driver);
	}

	public boolean isComputersInLeftMenuDisplayed() {
		boolean flag = driver.findElement(computersListMenuItem).isDisplayed();
		return flag;
	}

	public ComputersPage doClickComputersInLeftMenu() {
		driver.findElement(computersListMenuItem).click();
		return new ComputersPage(driver);
	}

	public boolean isElectronicsInLeftMenuDisplayed() {
		boolean flag = driver.findElement(electronicsListMenuItem).isDisplayed();
		return flag;
	}

	public ElectronicsPage doClickElectronicsInLeftMenu() {
		driver.findElement(electronicsListMenuItem).click();
		return new ElectronicsPage(driver);
	}

	public boolean isApparelsAndShoesInLeftMenuDisplayed() {
		boolean flag = driver.findElement(apparelShoesListMenuItem).isDisplayed();
		return flag;
	}

	public ApparelsAndShoesPage doClickApparelsAndShoesInLeftMenu() {
		driver.findElement(apparelShoesListMenuItem).click();
		return new ApparelsAndShoesPage(driver);

	}

	public boolean isDigitalDownloadsInTopMenuLinkLeftMenuDisplayed() {
		boolean flag = driver.findElement(digitalDownloadsListMenuItem).isDisplayed();
		return flag;
	}

	public DigitalDownloadsPage doClickDigitalDownloadsInLeftMenu() {
		driver.findElement(digitalDownloadsListMenuItem).click();
		return new DigitalDownloadsPage(driver);
	}

	public boolean isJewelryInTopMenuLinkLeftMenuDisplayed() {
		boolean flag = driver.findElement(jewelryListMenuItem).isDisplayed();
		return flag;
	}

	public JewelryPage doClickJewelryInLeftMenu() {
		driver.findElement(jewelryListMenuItem).click();
		return new JewelryPage(driver);
	}

	public boolean isGiftCardsInTopMenuLinkLeftMenuDisplayed() {
		boolean flag = driver.findElement(giftCardsListMenuItem).isDisplayed();
		return flag;
	}

	public GiftCardsPage doClickGiftCardsInLeftMenu() {
		driver.findElement(giftCardsListMenuItem).click();
		return new GiftCardsPage(driver);
	}

	public int getNumberOfTagsInLandingPage() {
		int tagsCount = driver.findElements(allTags).size();
		return tagsCount;

	}

	public int getNumberOfFeaturedProducts() {
		int productCount = driver.findElements(productsList).size();
		return productCount;
	}

	public int getNumberOfPollOptions() {
		int pollCount = driver.findElements(pollOptions).size();
		return pollCount;
	}

	public String getCommunityPollText() {
		String text = driver.findElement(pollMessage).getText();
		return text;
	}

	public boolean isDisclaimerExists() {
		boolean flag = eleUtil.isdisplayed(footerCopyrightDescription);
		return flag;
	}

	public int getTotalFooterMenuItemsCount() {
		int footerMenuCount = eleUtil.getTotalElementsCount(footerMenu);
		return footerMenuCount;
	}

	public List<String> getFooterHeadersText() {
		List<String> footerHeaders = eleUtil.getElementsText(footerMenuHeaders);
		System.out.println("The Footer headers are:" + footerHeaders);
		return footerHeaders;
	}

	public int getInformationFooterSectionCount() {
		int inforMationFooterCount = eleUtil.getTotalElementsCount(informationFooterSection);
		System.out.println("Footer elements count under Information Column is:" + inforMationFooterCount);
		return inforMationFooterCount;
	}

	public List<String> getInformationFooterSectionText() {
		List<String> informationSectionText = eleUtil.getElementsText(informationFooterSection);
		System.out.println("Footer elements text under Information Column is:" + informationSectionText);
		return informationSectionText;
	}

	public int getCustomerServiceFooterSectionCount() {
		int customerServiceFooterCount = eleUtil.getTotalElementsCount(customerServiceFooterSection);
		System.out.println("Footer Links count under Customer Service Column is:" + customerServiceFooterCount);
		return customerServiceFooterCount;
	}

	public List<String> getCustomerServiceFooterSectionText() {
		List<String> customerServiceText = eleUtil.getElementsText(customerServiceFooterSection);
		System.out.println("Footer elements text under Information Column is:" + customerServiceText);
		return customerServiceText;
	}

	public int getMyAccountFooterSectionCount() {
		int myAccountFooterCount = eleUtil.getTotalElementsCount(myAccountFooterSection);
		System.out.println("Footer elements count under My Account Column is:" + myAccountFooterCount);
		return myAccountFooterCount;
	}

	public List<String> getMyAccountFooterSectionText() {
		List<String> myAccountText = eleUtil.getElementsText(myAccountFooterSection);
		System.out.println("Footer elements text under My Account Column is:" + myAccountText);
		return myAccountText;
	}

	public int getFollowUsFooterSectionCount() {
		int followUsFooterCount = eleUtil.getTotalElementsCount(followUsFooterSection);
		System.out.println("Footer elements count under Follow Us Column is:" + followUsFooterCount);
		return followUsFooterCount;
	}

	public List<String> getFollowUsFooterSectionText() {
		List<String> followUsText = eleUtil.getElementsText(followUsFooterSection);
		System.out.println("Footer elements text under Follow Us Column is:" + followUsText);
		return followUsText;
	}

	public String getFooterDisclaimerText() {
		String footerDescription = eleUtil.dogetText(footerCopyrightDescription);
		System.out.println("The Footer Disclaimer is:" + footerDescription);
		return footerDescription;
	}

	public void verifyFooterLinks() throws IOException {
		HttpURLConnection.setFollowRedirects(false);
		List<WebElement> footerSection = eleUtil.dofindElements(footerMenu);
		for (int i = 0; i < footerSection.size(); i++) {

			WebElement element = footerSection.get(i);
			String url = element.getAttribute("href");

			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.connect();
			int code = httpConn.getResponseCode();
			if (code >= 400) {
				System.out.println("Broken Link: " + url);
			} else {
				System.out.println("Valid Link: " + url);
			}
		}

	}

	public void verifyPopularTags() throws IOException {
		HttpURLConnection.setFollowRedirects(false);
		List<WebElement> tagsSection = eleUtil.dofindElements(allTags);
		for (int i = 0; i < tagsSection.size(); i++) {
			WebElement element = tagsSection.get(i);
			String url = element.getAttribute("href");

			URL link = new URL(url);
			HttpURLConnection httpConn = (HttpURLConnection) link.openConnection();
			httpConn.connect();
			int code = httpConn.getResponseCode();
			if (code >= 400) {
				System.out.println("Broken Link: " + url);
			} else {
				System.out.println("Valid Link: " + url);
			}
		}

	}

	public List<String> getPopularTagsNames() {
		List<String> tagsText = eleUtil.getElementsText(allTags);
		System.out.println("The Tag names are :" + tagsText);
		return tagsText;
	}

	public int countPopularTags() {
		int count = eleUtil.getTotalElementsCount(allTags);
		System.out.println("The count of tags are :" + count);
		return count;
	}

	public AllProductsTagsPage popularTagsViewAllOption() {
		eleUtil.doclick(viewAllLink);
		return new AllProductsTagsPage(driver);
	}

	public int verifyCommunityPollOptionsCount() {
		int count = eleUtil.getTotalElementsCount(pollOptions);
		System.out.println("The count of Poll Options is :" + count);
		return count;
	}

	public List<String> verifyCommunityPollOptionsText() {
		List<String> pollText = eleUtil.getElementsText(pollOptions);
		System.out.println("The names of Poll Options are :" + pollText);
		return pollText;
	}

	public String verifyErrorMessageWhenNoPollOptionIsSelected() {
		eleUtil.doclick(voteButton);
		String text = eleUtil.getAlertText(AppConstants.DEFAULT_SHORT_TIME_OUT);
		eleUtil.alertAccept(AppConstants.DEFAULT_SHORT_TIME_OUT);
		System.out.println("The message in the Demo Web Shop Alert is:" + text);
		return text;
	}

}
