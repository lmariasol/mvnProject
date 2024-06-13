package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	WebDriver driver;
	//WebDriverWait wait;

	// Constructor
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	// Fill text into field
	public void fillText(WebElement el, String text) {
		el.clear();
		el.sendKeys(text);
	}

	// Clicking on
	public void click(WebElement el) {
		el.click();
	}

	// Getting text
	public String getText(WebElement el) {
		return el.getText();
	}

	// Wait
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public void waitForElement(WebElement e) {
//		wait.until(ExpectedConditions.elementToBeClickable(e));
//	}

	// Print page title
	public void printPageTitle(WebElement el) {
		System.out.println(driver.getTitle());
	}

	// Get page title
	public String getPageTitle() {
		String titleText = driver.getTitle();
		//System.out.println("String titleText = driver.getTitle() is " + driver.getTitle());
		return titleText;
	}

	// Get the attribute of the element
	public void getAttribute(WebElement el) {
		System.out.println(el.getAttribute(null));
	}

	// Opens a new tab and switches to new tab
	public void switchToNewTab() {
		driver.switchTo().newWindow(WindowType.TAB);	
	}

	//Check if element displayed yes or no
	public boolean isElementDisplayed(WebElement el) {
		try {
			if(el.isDisplayed()) {
				System.out.println("this element " + el + " is displays");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("this element " + el + " is NOT displays");
		}
		return false;
	}

	// Go back to the previous page
	public void back() {
		driver.navigate().back();
	}
}
