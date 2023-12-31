package com.qa.DemoWebShop.Factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private EdgeOptions eo;

	public OptionsManager(Properties prop) {
		this.prop = prop;
	}

	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		// co.addArguments("--remote-allow-origins=*");
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setBrowserVersion(prop.getProperty("browserversion").trim());
			co.setCapability("browsername", "chrome");
			co.setCapability("enableVNC", true);
		}

		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			co.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			co.addArguments("--incognito");
		}
		return co;
	}

	public EdgeOptions getEdgeOptions() {
		eo = new EdgeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless").trim())) {
			eo.addArguments("--headless");
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito").trim())) {
			eo.addArguments("--incognito");
		}
		return eo;
	}

}
