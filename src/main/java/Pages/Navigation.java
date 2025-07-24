package Pages;

import Com.ACC.selenium.BASE.BaseClass;
import Com.ACC.selenium.BASE.Locatername;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Navigation extends BaseClass {

	@Given("Verify the user land on the summary page")
	public void verifyTheUserLandOnTheSummaryPage() {

		asserts(element(Locatername.xpath,prop.getProperty("VerifySummary.xpath")), "Summary");

	}

	@Given("Verify the elements in the summary page")
	public void verifyTheElementsInTheSummaryPage() {

		// verify the search and filter is intractable
		click(element(Locatername.xpath,prop.getProperty("ClickSearch.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickonFilter.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ApplyFilter.xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("RecordCount.xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("ScrolltoDown.xpath")));

		}


	}

	@Then("Verify the user land on the Contract page")
	public void verifyTheUserLandOnTheContractPage() {
		click(element(Locatername.xpath,prop.getProperty("Click&VerifyContract.Xpath")));
		asserts(element(Locatername.xpath,prop.getProperty("Click&VerifyContract.Xpath")), "Contracts");

	}

	@Then("Verify the elements in the contract page")
	public void verifyTheElementsInTheContractPage() {

		// verify the search and filter is intractable
		click(element(Locatername.xpath,prop.getProperty("ClickSearchInContract.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickFilterIncontract.Xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickSaveInContractFilter.Xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("ConRecordCount.Xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("ContractScroll.Xpath")));

		}


	}

	@Then("Verify the user land on the variation page")
	public void verifyTheUserLandOnTheVariationPage() {
		click(element(Locatername.xpath,prop.getProperty("Click&VerifyVariation.Xpath")));
		asserts(element(Locatername.xpath,prop.getProperty("Click&VerifyVariation.Xpath")), "Variations");

	}

	@Then("Verify the elements in the variation page")
	public void verifyTheElementsInTheVariationPage() {
		// verify the search and filter is intractable
		click(element(Locatername.xpath,prop.getProperty("ClickSearchInVariation.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickFilterInVariation.Xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickSaveInVariationFilter.Xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("VarRecordCount.Xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("VariationScroll.Xpath")));

		}

	}

	@Then("Verify the user land on the Adjustment page")
	public void verifyTheUserLandOnTheAdjustmentPage() {
		click(element(Locatername.xpath,prop.getProperty("Click&VerifyAdjustment.Xpath")));
		asserts(element(Locatername.xpath,prop.getProperty("Click&VerifyAdjustment.Xpath")), "Adjustments");

	}

	@Then("Verify the elements in the Adjustment page")
	public void verifyTheElementsInTheAdjustmentPage() {
		// verify the search and filter is intractable
		click(element(Locatername.xpath,prop.getProperty("ClickSearchInAdjustment.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickFilterInAdjustment.Xpath")));
		//SaveFilter
		click(element(Locatername.xpath,prop.getProperty("ClickSaveInAdjustmentFilter.Xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("AdjRecordCount.Xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("AdjustmentScroll.Xpath")));

		}



	}

	@Then("Verify the user land on the Entity page")
	public void verifyTheUserLandOnTheEntityPage() {
		click(element(Locatername.xpath,prop.getProperty("Click&VerifyEntity.Xpath")));
		asserts(element(Locatername.xpath,prop.getProperty("Click&VerifyEntity.Xpath")), "Entities");

	}

	@Then("Verify the elements in the Entity page")
	public void verifyTheElementsInTheEntityPage() {
		// verify the search and filter is intractable
		click(element(Locatername.xpath,prop.getProperty("ClickSearchInEntity.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickFilterInEntity.Xpath")));
		//SaveFilter
		click(element(Locatername.xpath,prop.getProperty("ClickSaveInEntityFilter.Xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("EntRecordCount.Xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("EntityScroll.Xpath")));

		}


	}

	@Then("Verify the user land on the Termination page")
	public void verifyTheUserLandOnTheTerminationPage() {

		//Click on more menu
		click(element(Locatername.xpath,prop.getProperty("ClickonMoreMenu.Xpath")));
		//click on Termination option
		click(element(Locatername.xpath,prop.getProperty("ClickTermination.xpath")));
		asserts(element(Locatername.xpath,prop.getProperty("VerifyTerminationPage")), "Terminations");

	}

	@Then("Verify the elements in the Termination page")
	public void verifyTheElementsInTheTerminationPage() {
		click(element(Locatername.xpath,prop.getProperty("ClickSearchInTermination.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickFilterInTermination.Xpath")));
		//SaveFilter
		click(element(Locatername.xpath,prop.getProperty("ClickSaveInTermination.Xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("TerRecordCount.Xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("TerminationScroll.Xpath")));

		}
	}

	@Then("Verify the user land on the Signature page")
	public void verifyTheUserLandOnTheSignaturePage() {
		//Click on more menu
		click(element(Locatername.xpath,prop.getProperty("ClickonMoreMenu.Xpath")));
		//click on Termination option
		click(element(Locatername.xpath,prop.getProperty("ClickSignature.xpath")));
		asserts(element(Locatername.xpath,prop.getProperty("VerifySignaturePage")), "Signatures");


	}

	@Then("Verify the elements in the Signature page")
	public void verifyTheElementsInTheSignaturePage() {
		click(element(Locatername.xpath,prop.getProperty("ClickSearchInSignature.Xpath")));
		//click(element(Locatername.xpath,prop.getProperty("ClicksearchClear.xpath")));
		click(element(Locatername.xpath,prop.getProperty("ClickFilterInSignature.Xpath")));
		//SaveFilter
		click(element(Locatername.xpath,prop.getProperty("ClickSaveInSignature.Xpath")));

		//Scroll
		String recordCount = getTextFromApp(element(Locatername.xpath,prop.getProperty("SigRecordCount.Xpath")));
		String numberonly = recordCount.replaceAll("\\D+", "");
		int number = Integer.parseInt(numberonly);

		if(number > 20) {

			ScrolldownAndUp(element(Locatername.xpath,prop.getProperty("SignatureScroll.Xpath")));

		}


	}

}
