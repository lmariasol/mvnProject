package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage {

	// Elements
	@FindBy (css = ".title")
	WebElement checkoutCompletePageTitleLabel;

	@FindBy (css = ".checkout_complete_container > h2")
	WebElement ErrorMsgCompleteHeader;

	@FindBy (css = ".checkout_complete_container > div")
	WebElement ErrorMsgCompleteText;

	@FindBy (css = "#back-to-products")
	WebElement BackHomeBtn;

	// Constructor
	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void backHome() {
		click(BackHomeBtn);
	}

	public String getTitleText() {
		String titleText = checkoutCompletePageTitleLabel.getText();
		return titleText;
	}
}