package signup_testcases;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import generic_utilities.Browser_initiate;
import generic_utilities.Library;
import generic_utilities.Screenshot;
import pageObject.locatorscreen1;

public class Click_on_Textfields_Without_Entering_Data extends Browser_initiate {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	public ExtentTest test;
	WebDriverWait wait;
	locatorscreen1 button;

	public void click_on_textfields_Without_entering_data(ExtentReports extent, ExtentHtmlReporter htmlReporter,
			ExtentTest test) throws Exception {
		String tcname = "Click on textfields without entering data";
		try {
			test = extent.createTest(tcname);
			// launch browser
			driver = LaunchBrowser();
			// fetching URL from property file
			driver.get(Library.propertyFile(prop).getProperty("URL"));

			wait = new WebDriverWait(driver, 10);
			button = new locatorscreen1(driver);
			// click on join button
			wait.until(ExpectedConditions.elementToBeClickable(button.getsubmit_Button())).click();
			test.log(Status.INFO, "Click on Join button");

		} catch (Exception e) {
			String exceptionAsString = e.toString();
			Library.getReports(test, "exception", exceptionAsString, tcname);
			test.log(Status.FAIL, "Click on submit Button :" + e);
			Screenshot.getScreenshot(driver, tcname);

		} finally {
			extent.flush();
			driver.quit();
		}
	}
}
