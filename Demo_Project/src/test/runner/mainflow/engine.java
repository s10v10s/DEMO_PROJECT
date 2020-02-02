package mainflow;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import signup_testcases.*;

public class SignUp {
	static ExtentReports extent = new ExtentReports();
	static ExtentHtmlReporter htmlReporter;
	static ExtentTest test;
	Click_on_Textfields_Without_Entering_Data textfieldWithoutData;

	@BeforeSuite
	public void setUp() {

		htmlReporter = new ExtentHtmlReporter("./Result/ExtentReport/testhtmlreport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@Test(priority = 0)
	public void click_on_Textfields_Without_Entering_Data() {

		textfieldWithoutData = new Click_on_Textfields_Without_Entering_Data();
		textfieldWithoutData.click_on_textfields_Without_entering_data(extent, htmlReporter, test);

	}

}
