package com.qa.DemoWebShop.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.DemoWebShop.Exceptions.FrameworkExceptions;

public class DriverFactory {
	public WebDriver driver;
	public Properties prop;
	public OptionsManager op;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * This method is initializing the browser based on the browser parameter we are
	 * passing * @param browserName * @return
	 */

	public WebDriver initDriver(Properties prop) {
		String browserName = prop.getProperty("browser").toLowerCase().trim();
		op = new OptionsManager(prop);
		System.out.println("Browser Name is:" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				// run at the remote machine/Selenium grid
				init_remoteDriver("chrome");
			} else {
				tlDriver.set(new ChromeDriver(op.getChromeOptions()));
				op.getChromeOptions();
			}

		} else if (browserName.equalsIgnoreCase("edge")) {
			if (Boolean.parseBoolean(prop.getProperty("remote"))) {
				init_remoteDriver("edge");
			} else {
				tlDriver.set(new EdgeDriver(op.getEdgeOptions()));
			}
		} else {
			System.out.println("Browser not specified, Please specify correct browser Name" + browserName);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}

	private void init_remoteDriver(String browserName) {

		System.out.println("Running tests on Selenim GRID with browser: " + browserName);

		try {
			switch (browserName) {
			case "chrome":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), op.getChromeOptions()));
				break;
			case "edge":
				tlDriver.set(new RemoteWebDriver(new URL(prop.getProperty("huburl")), op.getEdgeOptions()));
				break;

			default:
				System.out.println("Wrong browser info....can not run on grid remote machine....");
				break;
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	/*
	 * It will get the local Thread copy of the driver
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProperties() throws IOException {
		prop = new Properties();
		FileInputStream fstream = null;
		String envName = System.getProperty("env");
		System.out.println("Running TCs in Environment:" + envName);
		try {
			if (envName == null) {
				System.out.println(
						"No environment is passed, Please pass the environment. By default, TCs will run on QA environment");
				fstream = new FileInputStream("./src/test/resources/Config/qa.config.properties");
				prop.load(fstream);
			} else {
				switch (envName.trim()) {
				case "QA":
					fstream = new FileInputStream("./src/test/resources/Config/qa.config.properties");
					System.out.println("TCs will run on QA environment");
					break;
				case "DEV":
					fstream = new FileInputStream("./src/test/resources/Config/dev.config.properties");
					System.out.println("TCs will run on DEV environment");
					break;
				case "STAGE":
					fstream = new FileInputStream("./src/test/resources/Config/Stage.config.properties");
					System.out.println("TCs will run on STAGE environment");
					break;
				case "PROD BETA":
					fstream = new FileInputStream("./src/test/resources/Config/ProdBeta.config.properties");
					System.out.println("TCs will run on PROD BETA environment");
					break;
				case "PROD":
					fstream = new FileInputStream("./src/test/resources/Config/Prod.config.properties");
					System.out.println("TCs will run on PROD environment");
					break;
				default:
					System.out.println("Wrong environment is passed, Please pass the correct environment");
					throw new FrameworkExceptions("WRONG ENVIRONMENT DETAILS PASSED");
				}
			}

		} catch (FileNotFoundException e) {

		}
		prop.load(fstream);
		return prop;
	}

	/*
	 * This method will capture screenshot when a Test fails while execution
	 */

	public String getScreenshot() {
		File src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtil.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
