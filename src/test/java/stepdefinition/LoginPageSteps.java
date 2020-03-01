package stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ithuba.skilrock.common.Locators;
import ithuba.skilrock.pages.LoginPage;

public class LoginPageSteps {

	private LoginPage loginPage = LoginPage.getInstance();

	@Given("^Navigate To LoginPage$")
	public void navigate_To_LoginPage() throws Throwable {
		System.out.println("navigate_To_LoginPage");
		loginPage.navigateLoginPage();
	}

	@When("^Enter Credentials (.*) (.*)$")
	public void enter_Credentials(String userName, String password) throws Throwable {
		System.out.println("enter_Credentials userName: " + userName + "Password: " + password);
		loginPage.enterCredentials(userName, password);
	}

	@When("^Submit Login Button$")
	public void submit_Login_Button() throws Throwable {
		System.out.println("submit_Login_Button");
		loginPage.loginClick();
	}

	@Then("^Get Logout Button$")
	public void get_Logout_Button() throws Throwable {
		System.out.println("get_Logout_Button");
	}

}
