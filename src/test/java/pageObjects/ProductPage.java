package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends SidebarMenuPage {

	// Elements
	@FindBy(css = ".btn.btn_primary")
	WebElement addToCartBtn;

	@FindBy(css = ".inventory_details_back_button")
	WebElement backBtn;

	@FindBy(css = "#shopping_cart_container")
	WebElement goToShoppingCartBtn;

	// Constructor
	public ProductPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void addToCart() {
		click(addToCartBtn);
		//sleep(3000);
	}

	public void back() {
		click(backBtn);
		//sleep(3000);
	}

	public void goToShoppingCart() {
		click(goToShoppingCartBtn);
		sleep(1000);
	}
}
