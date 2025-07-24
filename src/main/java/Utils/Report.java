package Utils;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import cucumber.api.testng.AbstractTestNGCucumberTests;

public  abstract class Report extends AbstractTestNGCucumberTests {

    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;
    public static ExtentTest test, node;

    public String testCaseName, testDescription, nodes, authors, category;
    public String excelFileName;

    @BeforeSuite
    public void startReport() {
        reporter = new ExtentSparkReporter("./reports/result.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);
    }

    @BeforeClass
    public void report() throws IOException {
        test = extent.createTest(testCaseName, testDescription);
        test.assignAuthor(authors);
        test.assignCategory(category);
        node = test.createNode("Step Node");
    }

    public abstract long takeSnap();

    public void reportStep(String dec, String status, boolean bSnap) {
        Media img = null;
        if (bSnap && !status.equalsIgnoreCase("INFO")) {
            long snapNumber = 100000L;
            snapNumber = takeSnap();
            try {
                img = MediaEntityBuilder.createScreenCaptureFromPath("./../reports/images/" + snapNumber + ".jpg")
                        .build();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (status.equalsIgnoreCase("pass")) {
            node.pass(dec, img);
        } else if (status.equalsIgnoreCase("fail")) {
            node.fail(dec, img);
            
        }
    }

    public void reportStep(String desc, String status) {
        reportStep(desc, status, true);
    }

    @AfterSuite
    public void stopReport() throws IOException {
        extent.flush();
        Desktop.getDesktop().browse(new File("D:\\smoketest\\Contracts_SmokeTest\\reports\\result.html").toURI());
        
    }

	public void scrollToElement(WebElement ele, String xpath) {
		
	}
}
