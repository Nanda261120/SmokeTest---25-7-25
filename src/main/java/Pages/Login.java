package Pages;

import BeforeAndAfterMethods.BeforeRunAndAfterRun;
import Com.ACC.selenium.BASE.Locatername;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Login extends  BeforeRunAndAfterRun{

	@Given("Verify the user laned on the okta login.")
	public Login verifyTheUserLanedOnTheOktaLogin() {
		getTextFromApp(element(Locatername.xpath,prop.getProperty("VerifyOktaLogin.xpath")));
		return this;

	}

	@Given("click on the sign to login button.")
	public Login clikcOnTheSignToLoginButton() {
		click( element(Locatername.xpath,prop.getProperty("Signin_with_okta")));
		return this;

	}

	@Then("check user redirect to the login page.")
	public Login checkUserRedirectToTheLoginPage() {
		getTextFromApp(element(Locatername.xpath,prop.getProperty("Verifylogin.xpath")));
		return this;


	}

	@Then("Enter the UserId")
	public Login enterTheUserId(String Data) {
		ClearAndType(element(Locatername.xpath,prop.getProperty("UserId.Xpath")),Data);
		return this;


	}

	@Then("click on the next button.")
	public void clickOnTheNextButton() {
	  click(element(Locatername.xpath,prop.getProperty("NextButton.xpath")));
	}



	@Then("Enter the Password")
	public Login enterThePassword(String Data) {
		ClearAndType(element(Locatername.xpath,prop.getProperty("Password.Xpath")),Data);
		return this;


	}

	@Then("click on the verify button.")
	public void clickOnTheVerifyButton() {
		click(element(Locatername.xpath,prop.getProperty("VerifyButton.xpath")));

	}


}




