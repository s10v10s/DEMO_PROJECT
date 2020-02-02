package generic_utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Library {

	static WebDriver driver;
	
	// Giving path of the properties file

	static Properties prop = new Properties();
	private static String propFilepath = System.getProperty("user.dir")
			+ "\\ConfigFile\\environment.properties";

	public static Properties propertyFile(Properties property) {

		try {

			 prop.load(new FileInputStream(propFilepath));

		} catch (Exception e) 
		{
           e.printStackTrace();
		}
		return prop;

	}

	public static void getReports(ExtentTest test, String actual, String expected, String tcname) throws IOException{
		// Fetch Result of Test Case

		try {
			Assert.assertEquals(actual, expected);
			// Log pass results
			test.log(Status.PASS, "Expected title :" + expected + " : : Current title :" + actual);
			
			CSVLib.writeDataToCsv(tcname, "Pass");

		} catch (Error e) {
			// Log fail results along with error
			
			test.log(Status.FAIL,
					"Expected title :" + expected + " : : Current title :" + actual + " : : " + e.toString());
			CSVLib.writeDataToCsv(tcname, "Fail");

		}
	}

}
