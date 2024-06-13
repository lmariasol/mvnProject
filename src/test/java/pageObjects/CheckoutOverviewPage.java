package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage {
	
	// Elements
	@FindBy (css="#finish")
	WebElement finishBtn;
	
	// Constructor
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void completePurchaseProducts() {
		// Click on Finish button
		click(finishBtn);
		//sleep(2000);
	}

}
