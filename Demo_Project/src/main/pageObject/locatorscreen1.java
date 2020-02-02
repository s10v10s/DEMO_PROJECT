package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// Locators for signup page
public class Signup_locators {

	public static WebDriver driver;

	By submit_buttton = By.xpath("//a[contains(text(),'Submit')]");

	// constructor for signup locators page

	public modalpage(WebDriver driver)
	{

		this.driver= driver;
	}

	public By getsubmit_Button() {

		return submit_buttton;

	}

}
