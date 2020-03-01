package stepdefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ithuba.skilrock.common.ConfigurationSetup;

public class HomePageSteps {

	private ConfigurationSetup setup = ConfigurationSetup.getInstance();
	private WebDriver driver = null;

	@Given("^User Open Browser any particuler browser$")
	public void user_Open_Browser_any_particuler_browser() throws Throwable {
		System.out.println("^User Open Browser any particuler browser$");
		driver = setup.getDriver();
	}

	@When("^Enter the Url of Website$")
	public void enter_the_Url_of_Website() throws Throwable {
		System.out.println("^Enter the Url of Website$");
		driver.get(setup.getProperty("URL"));
		Thread.sleep(3000);
	}

	@Then("^Title Of Website is Ithuba National Lottery | Home$")
	public void title_Of_Website_is_Ithuba_National_Lottery_Home() throws Throwable {
		System.out.println("title_Of_Website_is_Ithuba_National_Lottery_Home" + driver.getTitle());
		assertEquals(driver.getTitle(), "Ithuba National Lottery | Home");
		System.out.println("reached out");
	}

}
