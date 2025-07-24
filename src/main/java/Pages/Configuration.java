package Pages;

import Com.ACC.selenium.BASE.BaseClass;
import Com.ACC.selenium.BASE.Locatername;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Configuration extends BaseClass {

	@Given("verify the more button is available in the header")
	public void verifyTheMoreButtonIsAvailableInTheHeader() {
		getTextFromApp(element(Locatername.xpath, prop.getProperty("ClickonMoreMenu.Xpath")));

	}

	@Given("click on the more button")
	public void clickOnTheMoreButton() {
		click(element(Locatername.xpath,prop.getProperty ("ClickonMoreMenu.Xpath")));



	}

	@When("User should be displayed with configuartion option.")
	public void userShouldBeDisplayedWithConfiguartionOption() {
		getTextFromApp(element(Locatername.xpath,prop.getProperty( "verifyConfiguration.xpath")));



	}

	@When("click on the configuration option")
	public void clickOnTheConfigurationOption() {
		click(element(Locatername.xpath,prop.getProperty( "ClickconfigurationButton.xpath")));


	}

	@When("user navigates to the season lisging screen")
	public void userNavigatesToTheSeasonLisgingScreen() {
		getTextFromApp(element(Locatername.xpath, prop.getProperty("verifyseason.xpath")));


	}

	@Then("verify the create button is present in the season listing")
	public void verifyTheCreateButtonIsPresentInTheSeasonListing() {
		getTextFromApp(element(Locatername.xpath,prop.getProperty( "verifycreatebutton.xpath")));

	}

	@Then("click on the create button in listing")
	public void  clickOnTheCreateButtoninListing() {
		click(element(Locatername.xpath,prop.getProperty( "clickCreateButton.xpath")));

	}
	@Then("inactive the status")
	public Configuration inactiveTheStatus() {
		click(element(Locatername.xpath,prop.getProperty("SeasonInactive.xpath")));
		return this;
	}


	@Then("Enter season name")
	public void  enterSeasonName(int  SeasonName) {
		intClearAndType(element(Locatername.xpath,prop.getProperty("Enterseason.xpath")), SeasonName );
	}

	@Then("select the start date and end date")
	public void  selectTheStartDateAndEndDate() {
		CurrentdatePicker(element(Locatername.xpath,prop.getProperty("StartSeason.xpath")));
		PlusOneyeardatepicker(element(Locatername.xpath,prop.getProperty("EndSeason.xpath")), 1);
		

	}

	@Then("select previous season")
	public void selectPreviousSeason(String data) {

		click(element(Locatername.xpath,prop.getProperty("SeasonInactive.xpath")));


	}

	@Then("click on the create button.")
	public void clickOnTheCreateButton( int excelFileName ) {
		click(element(Locatername.xpath,prop.getProperty("ClickCreateSeason.xpath")));
		DbAssert("seasons", "season", excelFileName);
	}
	

}
