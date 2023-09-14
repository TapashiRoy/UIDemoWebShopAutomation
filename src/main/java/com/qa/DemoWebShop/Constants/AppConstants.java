package com.qa.DemoWebShop.Constants;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	public static final int DEFAULT_MEDIUM_TIME_OUT = 5;
	public static final int DEFAULT_SHORT_TIME_OUT = 2;
	public static final int DEFAULT_LONG_TIME_OUT = 12;

	// ********SHEET NAMES********************

	public static final String REGISTER_SHEET_NAME = "register";

	public static final String SEARCH_TEXT_VALUE = "Search store";
	public static final String WELCOME_TEXT_VALUE = "Welcome to the new Tricentis store!" + '\n'
			+ "Feel free to shop around and explore everything.";

	public static final String USER_REGISTRATION_MESSAGE = "Your registration completed";

	public static final int POPULAR_TAGS_COUNT = 15;
	public static final List<String> POPULAR_TAGS_TEXT = Arrays.asList("apparel", "awesome", "book", "camera", "cell",
			"compact", "computer", "cool", "digital", "gift", "jewelry", "nice", "shirt", "shoes", "TCP");
	public static final int POLL_COUNT = 4;
	public static final List<String> POLL_OPTIONS = Arrays.asList("Excellent", "Good", "Poor", "Very bad");

	public static final int FOOTER_MENU_COUNT = 22;
	public static final List<String> FOOTER_MENU_HEADERS = Arrays.asList("INFORMATION", "CUSTOMER SERVICE",
			"MY ACCOUNT", "FOLLOW US");

	public static final int FOOTER_MENU_INFORMATION_COLUMN_COUNT = 6;
	public static final List<String> FOOTER_MENU_LINKS_UNDER_INFORMATION_COLUMN = Arrays.asList("Sitemap",
			"Shipping & Returns", "Privacy Notice", "Conditions of Use", "About us", "Contact us");

	public static final int FOOTER_MENU_CUSTOMER_SERVICE_COLUMN_COUNT = 6;
	public static final List<String> FOOTER_MENU_LINKS_UNDER_CUSTOMER_SERVICE_COLUMN = Arrays.asList("Search", "News",
			"Blog", "Recently viewed products", "Compare products list", "New products");

	public static final int FOOTER_MENU_MY_ACCOUNT_COLUMN_COUNT = 5;
	public static final List<String> FOOTER_MENU_LINKS_UNDER_MY_ACCOUNT_COLUMN = Arrays.asList("My account", "Orders",
			"Addresses", "Shopping cart", "Wishlist");

	public static final int FOOTER_MENU_FOLLOW_US_COLUMN_COUNT = 5;
	public static final List<String> FOOTER_MENU_LINKS_UNDER_FOLLOW_US_COLUMN = Arrays.asList("Facebook", "Twitter",
			"RSS", "YouTube", "Google+");

	public static final String FOOTER_MENU_DISCLAIMER = "Copyright © 2023 Tricentis Demo Web Shop. All rights reserved.";

	public static final String HOME_PAGE__TITLE_VALUE = "Demo Web Shop";
	public static final String HOME_PAGE_URL_FRACTION_VALUE = "demowebshop";

	public static final String REGISTER_PAGE_TITLE_VALUE = "Demo Web Shop. Register";
	public static final String REGISTER_PAGE_URL_FRACTION_VALUE = "register";

	public static final String BOOKS_PAGE_TITLE_VALUE = "Demo Web Shop. Books111";
	public static final String BOOKS_PAGE_URL_FRACTION_VALUE = "books";

	public static final String LOGIN_PAGE_TITLE_VALUE = "Demo Web Shop. Login";
	public static final String LOGIN_PAGE_URL_FRACTION_VALUE = "login";

	public static final List<String> PAGE_HEADERS_ACROSS_ALL_PAGES = Arrays.asList("BOOKS", "COMPUTERS", "ELECTRONICS",
			"APPAREL & SHOES", "DIGITAL DOWNLOADS", "JEWELRY", "GIFT CARDS");

	public static final List<String> PAGE_SORTING_LIST = Arrays.asList("Position", "Name: A to Z", "Name: Z to A",
			"Price: Low to High", "Price: High to Low", "Created on");
	public static final int PAGE_SORTING_LIST_COUNT = 6;

	public static final List<String> PAGE_DISPLAY_LIST = Arrays.asList("4", "8", "12");
	public static final int PAGE_DISPLAY_LIST_COUNT = 3;

	public static final List<String> PAGE_VIEW_LIST = Arrays.asList("Grid", "List");
	public static final int PAGE_VIEW_LIST_COUNT = 2;

	public static final int FILTER_LINKS_COUNT = 3;

	public static final String PURCHASED_PRODUCT_GRID_HEADER_TITLE = "Customers who bought this item also bought";

	// ********ERROR MESSAGES********************
	public static final String FIRST_NAME_ERROR_MESSAGE = "First name is required.";
	public static final String lAST_NAME_ERROR_MESSAGE = "Last name is required.";
	public static final String EMAIL_ERROR_MESSAGE = "Email is required.";
	public static final String PASSWORD_ERROR_MESSAGE = "Password is required.";
	public static final String CONFIRMPASSWORD_ERROR_MESSAGE = "Password is required.";

}
