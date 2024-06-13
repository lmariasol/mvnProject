package pageObjects;

import org.openqa.selenium.WebDriver;

public class Saucelabs_Page extends BasePage {

	// Elements	
	String titleText = (driver.getTitle());

	// Container
	public Saucelabs_Page(WebDriver driver) {
		super(driver);
	}

	// Methods
}