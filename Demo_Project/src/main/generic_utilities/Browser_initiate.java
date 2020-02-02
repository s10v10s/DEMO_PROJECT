package generic_utilities;

import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import generic_utilities.Library;

public class Browser_initiate {

	public static WebDriver driver;

	static DesiredCapabilities capabilities;

	// Base class for launching the browsers
	
	public static WebDriver LaunchBrowser() {
		try {

			Properties prop = new Properties();
			String browsername = Library.propertyFile(prop).getProperty("browserName");

			// Launch chrome browser
			if (browsername.equals("chrome")) {
				System.setProperty(Library.propertyFile(prop).getProperty("CHROME_KEY"),
						Library.propertyFile(prop).getProperty("CHROME_VALUE"));
				driver = new ChromeDriver();
				driver.manage().window().maximize();

			}
			
			// Launch firefox browser
			
		}
		catch (Exception e) {
			
			System.out.println(e);
		
		}
		return driver;

	}

}
