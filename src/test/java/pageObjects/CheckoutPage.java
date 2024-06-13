package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends SidebarMenuPage {
	
	// Elements
	@FindBy(css = "#first-name")
	WebElement firstNameField;

	@FindBy(css = "#last-name")
	WebElement lastNameField;

	@FindBy(css = "#postal-code")
	WebElement zipCodeField;

	@FindBy(css = "#continue")
	WebElement continueBtn;
	
	// Constructor
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void fillCheckoutForm(String firstName, String lastName, String zipCode) {
		fillText(firstNameField, firstName);

		fillText(lastNameField, lastName);

		fillText(zipCodeField, zipCode);

		click(continueBtn);
	}

}
