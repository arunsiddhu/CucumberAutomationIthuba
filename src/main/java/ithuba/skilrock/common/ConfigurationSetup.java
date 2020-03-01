package ithuba.skilrock.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigurationSetup {

	private static Properties properties;
	protected static WebDriver driver;
	static WebDriverWait wait;
	private static Logger LOGGER = LoggerFactory.getLogger(ConfigurationSetup.class);
	private static ConfigurationSetup configurationSetup = null;

	private ConfigurationSetup() {
		/**
		 * private method to create a singleton class
		 */
	}

	public static ConfigurationSetup getInstance() {
		if (Objects.isNull(configurationSetup))
			configurationSetup = new ConfigurationSetup();
		return configurationSetup;
	}

	public WebDriver getDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeoptions);
		return driver;
	}

	public JavascriptExecutor getExecuter() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions chromeoptions = new ChromeOptions();
		chromeoptions.addArguments("--start-maximized");
		WebDriver driver = new ChromeDriver(chromeoptions);
		return (JavascriptExecutor) driver;
	}

	public static void loadConfig() {
		try {
			File file = new File("Config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			Properties properties = new Properties();
			properties.load(fileInput);
			ConfigurationSetup.properties = properties;

		} catch (Exception e) {
			System.out.println("Exception occurred while loading config.properties " + e.getMessage());
		}
	}

	public String getProperty(String key) {
		try {
			loadConfig();
			return properties.getProperty(key);
		} catch (Exception e) {
			return null;
		}
	}

	public boolean isElementPresent(By locator, int timeoutInSeconds) {
		try {
			wait = new WebDriverWait(driver, timeoutInSeconds);
			WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			if (elem != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
