package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// Elements
	@FindBy (css="#user-name")
	WebElement userNameField;

	@FindBy (css="#password")
	WebElement passwordField;

	@FindBy (css="#login-button")
	WebElement loginBtn;
	
	@FindBy (css=".error-message-container.error > h3")
	WebElement errorMsgLabel;


	// Constructor
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void loginForm(String username, String password) {
		fillText(userNameField, username);

		fillText(passwordField, password);

		click(loginBtn);
	}
	
	public String getErrorMsg() {
		return getText(errorMsgLabel);
	}
	
	public String getloginBtnText() {
		return getText(loginBtn);
	}
}
