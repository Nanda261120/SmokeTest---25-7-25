package Com.ACC.selenium.BASE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.management.RuntimeErrorException;

import org.apache.commons.io.FileUtils;
import org.bson.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import Com.ACC.selenium.Interface.Interface;
import Utils.Report;


public class BaseClass extends Report implements Interface {
	public static RemoteWebDriver driver = null;
	public WebDriverWait wait = null ;
	protected static Properties prop;

	long implecitTimeout = 10;
	long webTimeOut = 10;
	
	public void setup(String URL) {
	
	System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	// options.addArguments("--disable-gpu");              // Disables GPU, which often causes crashes in VMs or low-resource environments
	// options.addArguments("--no-sandbox");               // Bypasses the security model, necessary for some environments
	// options.addArguments("--disable-dev-shm-usage");    // Overcomes limited resource problems
	// options.addArguments("--remote-debugging-port=9222"); // Avoids potential DevTools port conflict
	// options.addArguments("user-data-dir=C:/temp/chrome-profile"); // Specify a valid directory path 
	ChromeOptions options1 = new ChromeOptions();
	driver = new ChromeDriver(options1);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(implecitTimeout, TimeUnit.SECONDS);
	driver.get(URL);


}

public RemoteWebDriver setup(String browser, String URL) {
	try {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-gpu");              // Disables GPU, which often causes crashes in VMs or low-resource environments
			chromeOptions.addArguments("--no-sandbox");               // Bypasses the security model, necessary for some environments
			chromeOptions.addArguments("--disable-dev-shm-usage");    // Overcomes limited resource problems
			chromeOptions.addArguments("--remote-debugging-port=9222"); // Avoids potential DevTools port conflict
			chromeOptions.addArguments("user-data-dir=C:/temp/chrome-profile"); // Specify a valid directory path
			driver = new ChromeDriver(chromeOptions);
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver","drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "firefox":
			//			FirefoxOptions op2 = new FirefoxOptions();
			//			op2.setBrowserVersion();
			// Need to add a path for webdriver.
			driver = new FirefoxDriver();
			break;
		case "safari":
			//			SafariOptions op3 = new SafariOptions();
			//			op3.setBrowserVersion("128");
			// Need to add a path for wedriver.
			driver = new SafariDriver();
			break;
		default:
			System.err.println("Driver is not defined");
			break;	
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.manage().window().maximize();
	} catch (Exception e) {
		reportStep("Unable to locate the element", "fail");
		throw new RuntimeException();
	}
	return driver;
}

	

public void close() {
	driver.close();

}

public void quit() {
	driver.quit();

}


public WebElement element(Locatername type, String value) {

	try {
		switch (type) {
		case Id :
			return driver.findElement(By.id(value));

		case classname:
			return driver.findElement(By.className(value));

		case css:
			return driver.findElement(By.cssSelector(value));

		case name:
			return driver.findElement(By.linkText(value));

		case xpath:
			return driver.findElement(By.xpath(value));

		default:
			System.err.println("webelement is not defined");
			break;


		}
	} catch (Exception e) {
		reportStep("Unable to locate the element, So can't able to proceed the testing", "fail");
		throw new Error();		
	}
	return null;
}

public void type(WebElement ele, String testdata) {


}

public void appendText(WebElement ele, String testdata) {


}

public void click(WebElement ele) {
	String text = "";
	try {
		wait = new WebDriverWait(driver,webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		text = ele.getText();
		ele.click();	
		System.out.println("The Element is " + text + "is clicked successfully");
		reportStep("The Element  " + text + " is clicked successfully", "pass");
	} catch (Exception e) {
		reportStep("The Element  " + text + " is not clickable", "fail");
		throw new RuntimeException();
	}

}

public void Clear(WebElement ele) {
	String text = "";
	try {
		wait = new WebDriverWait(driver,webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		text = ele.getText();
		ele.clear();
		System.out.println("The text " + text + "is cleared successfully");
		reportStep("The text is " + text + " is cleared successfully", "pass");
	} catch (Exception e) {
		reportStep("The text " + text + " is not cleared successfully", "fail");

	}

}

public void switchtoWindow(int i) {



}

public void switchtoframe(int i) {


}

public void selectvalue(WebElement ele, String value) {


}

public void selectText(WebElement ele, String text) {


}

public void selectindex(WebElement ele, int position) {


}

public String getTitle() {

	return null;
}

public String getURL() {
	return driver.getCurrentUrl();


}

public boolean isDisplayed(WebElement ele) {
	

	return false;
}

public boolean isSelected(WebElement ele) {

	return false;
}

public boolean isEnabled(WebElement ele) {

	return false;
}

public void loadobject() {

	prop = new Properties();
	try {
		prop.load(new FileInputStream(new File("src/main/java/Contracts.Properties")));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}


public String getTextFromApp(WebElement ele) {
	String text = "" ;
	try {
		wait = new WebDriverWait(driver,webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		text=ele.getText();
		System.out.println("The Captured values is---" + text);
		reportStep("The Captured values is---" + text, "pass");
	} catch (Exception e) {
		reportStep("Unable to interact with element"+ ele, "fail");
		System.err.println("Element not found! Reason: " + e.getMessage());
	}
	return text;



}


public void ClearAndType(WebElement ele, String Data) {
	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.clear();
		ele.sendKeys(Data);
		reportStep("The given values " + Data + " is entered successfully", "pass");
	} catch (Exception e) {
		reportStep("Unable to interact with element"+ ele, "fail");
		throw new RuntimeException();
	}
}


public long takeSnap() {
	long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
	try {
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
				new File("./reports/images/" + number + ".jpg"));
		//System.out.println("take snap functionis working");
	} catch (WebDriverException e) {
		System.out.println("The browser has been closed.");
	} 
	catch (IOException e) {
		System.out.println("The snapshot could not be taken");
	}
	return number;
}


public void CurrentdatePicker(WebElement ele) {
	wait = new WebDriverWait(driver,webTimeOut);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	ele.click();
	LocalDate currentDate = LocalDate.now();
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 String formattedDate = currentDate.format(formatter);
	 ele.sendKeys(formattedDate);
}

public void PlusOneyeardatepicker(WebElement ele, int Year) {
	wait = new WebDriverWait(driver,webTimeOut);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	ele.click();
	LocalDate currentDate = LocalDate.now().plusYears(Year);;
	 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	 String formattedDate = currentDate.format(formatter);
	 ele.sendKeys(formattedDate);
	
}


public void selectDropdownUsingText(WebElement ele, String text) {
	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		new Select(ele).selectByVisibleText(text);
		System.out.println("The element " + ele + "is intractable.");
		reportStep("The dropdown value " + text + " is visible and clickable.", "PASS");
	} catch (NoSuchElementException e) {
		reportStep("The dropdown value " + text + " is not visible, So We can't able to Non- functional Testing", "FAIL");
	}
	
}



public void selectDropdownUsingvalue(WebElement ele, String value) {
	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		new Select(ele).selectByValue(value);
		System.out.println("The element " + ele + "is intractable.");
		reportStep("The dropdown value " + value + " is visible and clickable", "PASS");
	} catch (NoSuchElementException e) {
		reportStep("The dropdown value is " + value + " notvisible, So We can't able to Non- functional Testing", "fail");
	}
	
}


public void selectDropdownUsingindex(WebElement ele, int index) {

	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		new Select(ele).selectByIndex(index);
		System.out.println("The element " + ele + "is intractable.");
		reportStep("The Dropdown value  " + index + "is visible and clickable", "pass");
	} catch (NoSuchElementException e) {
		reportStep("The dropdown value is " + index + " notvisible, So We can't able to Non- functional Testing", "fail");
		
	}
}


public void intClearAndType(WebElement ele, int Data) {
	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.clear();
		ele.sendKeys(String.valueOf(Data));
	} catch (Exception e) {
		reportStep("Unable to interact with element, So We can't able to Non- functional Testing"+ ele, "fail");
		throw new RuntimeException();
	}
	
}

public void scrollToElement( String xpath) {
	try {
		WebElement element = new WebDriverWait(driver, 80)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
	} catch (Exception e) {
		throw new RuntimeException();
	} 
}


public void clickUsingMouse( WebElement ele ) {
	
	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		Actions ac = new Actions(driver);
		ac.moveToElement(ele).click().build().perform();
	}
catch (Exception e) {
		reportStep("Unable to interact with element"+ ele, "fail");
		throw new RuntimeException();
		
	}


	
}

public void doubleClickUsingMouse(WebElement ele) {
	
	wait = new WebDriverWait(driver, webTimeOut);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	Actions ac = new Actions(driver);
	ac.doubleClick(ele).click().perform();
}

public String getEntredTEXT(WebElement ele, String data) {

wait = new WebDriverWait(driver, webTimeOut);
wait.until(ExpectedConditions.elementToBeClickable(ele));
ele.clear();
ele.sendKeys(data);
return data;
}


public String asserts(WebElement ele, String ModuleName) {
	String ActualText = "";
	try {
		wait = new WebDriverWait(driver, webTimeOut);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		 ActualText = ele.getText();
		String ExpectedText = ModuleName;
		Assert.assertEquals(ActualText, ExpectedText, "Unable to locate the header");
		reportStep("The user landed on" + ActualText + " screen.", "PASS");
	} catch (Exception e) {
		reportStep("Unable to interact with element, So We can't able to Non- functional Testing"+ ele, "fail");
		throw new Error();
		
	}
	return ActualText;
}

public void ScrolldownAndUp(WebElement ele) {
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", ele); // Scroll to bottom of div
		reportStep("The web page scroll to bottom", "PASS");
	} catch (Exception e) {
		reportStep("Can't able to scroll the web page, So We can't able to Non- functional Testing", "fail");
		throw new Error();
		
	}
	
	
	
}


public Boolean DbAssert(String Collection, String key, int VerifyDAta) {
	
	 
        try {
			try (MongoClient mongoClient = MongoClients.create("mongodb://contractsdemouser:Xu7rayarI3ijAzUs@13.72.245.197:27017/AFL_CONTRACTS_DEMO")) {
				MongoDatabase database = mongoClient.getDatabase("AFL_CONTRACTS_DEMO");
				MongoCollection<Document> collection = database.getCollection(Collection);
				Document query = new Document(key, VerifyDAta);
				Document result = collection.find(query).first();
				 System.out.println("This data is present in the database");
				 return result != null;
				 
			} 
		} catch (Exception e) {
			System.out.println("This data is not present in the  database");
			throw new RuntimeException ();
		}
        
       
    }


	
}













	
	
	




