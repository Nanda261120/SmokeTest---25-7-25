package Com.ACC.Test;



import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BeforeAndAfterMethods.BeforeRunAndAfterRun;
import Pages.Configuration;
import Pages.Login;
import Pages.Navigation;

public class TC_001_loginTest extends BeforeRunAndAfterRun {
	
	@BeforeTest
	public void Repoet_data() {
		
		
		testCaseName = "Login_Page";
		testDescription = "Login_to_Apploication";
		nodes = "Login";
		authors = "Mr.N";
		category = "Simple_ login";
		datasheet = "login";
		
	}
	
	@Test(dataProvider = "fetchdata")
	public void login_page(String Userid, String Password, int SeasonName) {
		
		Login lo = new Login();
		lo.verifyTheUserLanedOnTheOktaLogin();
		lo.clikcOnTheSignToLoginButton();
		lo.checkUserRedirectToTheLoginPage();
		lo.enterTheUserId(Userid);
		lo.clickOnTheNextButton();
		lo.enterThePassword(Password);
		lo.clickOnTheVerifyButton();
		
		Navigation Nv = new Navigation();
		Nv.verifyTheUserLandOnTheSummaryPage();
		Nv.verifyTheElementsInTheSummaryPage();
		Nv.verifyTheUserLandOnTheContractPage();
		Nv.verifyTheElementsInTheContractPage();
		Nv.verifyTheUserLandOnTheVariationPage();
		Nv.verifyTheElementsInTheVariationPage();
		Nv.verifyTheUserLandOnTheAdjustmentPage();
		Nv.verifyTheElementsInTheAdjustmentPage();
		Nv.verifyTheUserLandOnTheEntityPage();
		Nv.verifyTheElementsInTheEntityPage();
		Nv.verifyTheUserLandOnTheTerminationPage();
		Nv.verifyTheElementsInTheTerminationPage();
		Nv.verifyTheUserLandOnTheSignaturePage();
		Nv.verifyTheElementsInTheSignaturePage();
		
//		Configuration config = new Configuration();
//		config.verifyTheMoreButtonIsAvailableInTheHeader();
//		config.clickOnTheMoreButton();
//		config.userShouldBeDisplayedWithConfiguartionOption();
//		config.clickOnTheConfigurationOption();
//		config.userNavigatesToTheSeasonLisgingScreen();
//		config.verifyTheCreateButtonIsPresentInTheSeasonListing();
//		config.clickOnTheCreateButtoninListing();
//		config.inactiveTheStatus();
//		config.enterSeasonName(SeasonName);
//		config.selectTheStartDateAndEndDate();
//		config.clickOnTheCreateButton(999);
		
		driver.quit();
		
	}

}
