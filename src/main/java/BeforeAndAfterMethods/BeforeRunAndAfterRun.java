package BeforeAndAfterMethods;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import Com.ACC.selenium.BASE.BaseClass;
import Utils.Excel_Input;

public class BeforeRunAndAfterRun  extends BaseClass  {

	public String datasheet;

	@DataProvider(name = "fetchdata")
	public Object[][]getdata() throws IOException{

		return Excel_Input.importexcel(datasheet);

	}

	@BeforeMethod
	public void precondition() {

		driver = setup(prop.getProperty("Browser_run"),prop.getProperty("Appliocation.URL"));

	}

	@BeforeTest
	public void beforeTest() {
		loadobject();

	}

//	@AfterMethod
//	public void closebroswer() {
//		 quit();
//	}

}
