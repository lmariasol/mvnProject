package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SidebarMenuPage extends BasePage {

	// Elements
	@FindBy(css = "#react-burger-menu-btn") // Menu icon
	WebElement menuBtn;

	@FindBy(css = "#menu_button_container > div > div.bm-menu-wrap > div.bm-menu > nav > a") // Menu list
	List<WebElement> menu; // edited 
	
	@FindBy(css = ".bm-cross-button > #react-burger-cross-btn")
	WebElement closeMenuBtn; // x

	// Constructor
	public SidebarMenuPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void openSidebarMenu() {
		click(menuBtn);
		sleep(1000);
	}
	
	public void closeSidebarMenu() {
		click(closeMenuBtn);
	}

	public void selectMenuOptions(String name) {
		System.out.println("selectMenuOptions");
		for (WebElement el : menu) {
			if (getText(el).equalsIgnoreCase(name)) {
				click(el);
				break;
			}
		}
	}
}
