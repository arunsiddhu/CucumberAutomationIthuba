package ithuba.skilrock.common;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonMethods {

	private static CommonMethods commonMethods;
	private ConfigurationSetup setup = ConfigurationSetup.getInstance();
	private WebDriver driver = null;

	private CommonMethods() {
		driver = setup.getDriver();
	}

	public static CommonMethods getInstance() {
		if (Objects.isNull(commonMethods))
			commonMethods = new CommonMethods();
		return commonMethods;
	}

	public void buttonClick(String xPath) {
		driver.findElement(By.xpath(xPath)).click();
	}

	public void sendInput(String xPath, String input) {
		driver.findElement(By.xpath(xPath)).sendKeys(input);
	}

}
