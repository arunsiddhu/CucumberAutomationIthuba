package ithuba.skilrock.pages;

import java.util.Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ithuba.skilrock.common.CommonMethods;
import ithuba.skilrock.common.ConfigurationSetup;
import ithuba.skilrock.common.Locators;

public class LoginPage {

	private Locators.Login locatorsLogin = Locators.getLoginInstance();
	private ConfigurationSetup setup = ConfigurationSetup.getInstance();
	private CommonMethods common = CommonMethods.getInstance();
	private static LoginPage loginPage = null;
	private WebDriver driver = null;
	private JavascriptExecutor executor = null;

	private LoginPage() {
		driver = setup.getDriver();
		executor = setup.getExecuter();
		/**
		 * private method to create a singleton class
		 */
	}

	public static LoginPage getInstance() {
		if (Objects.isNull(loginPage))
			loginPage = new LoginPage();
		return loginPage;
	}

	public void navigateLoginPage() {
		try {
			common.buttonClick(locatorsLogin.welcomePopup);
		} catch (Exception e) {
			System.err.println("Welcome PopUp Not Found!!");
			e.printStackTrace();
		}
	}

	public void enterCredentials(String userName, String password) {
		common.sendInput(locatorsLogin.userName, userName);
		common.sendInput(locatorsLogin.passWord, password);
	}

	public void loginClick() throws InterruptedException {
		WebElement login = driver.findElement(By.xpath(locatorsLogin.loggging));
		Object object = executor.executeScript("arguments[0].click();", login);
		System.out.println("object: " + object);
		Thread.sleep(3000);
	}

}
