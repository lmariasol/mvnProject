package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage {

	// Elements
	@FindBy(css = "#checkout")
	WebElement checkoutBtn;

	@FindBy(css = ".cart_button")
	WebElement removeBtn;

	@FindBy(css = "#continue-shopping")
	WebElement continueShoppingBtn;

	@FindBy(css = ".cart_item_label")
	List<WebElement> listOfProductsInCart;

	// Constructor
	public CartPage(WebDriver driver) {
		super(driver);
	}

	// Methods
	public void proceedToCheckout() {
		click(checkoutBtn);
		// sleep(2000);
	}

	public void removeProduct(String name) {
		for (WebElement element : listOfProductsInCart) {
			// sleep(2000);
			WebElement productToRemove = element.findElement(By.cssSelector(".inventory_item_name"));
			if (getText(productToRemove).equalsIgnoreCase(name)) {
				// WebElement removeBtn = element.findElement(By.cssSelector(".cart_button"));
				click(removeBtn);
				break;
			}
			// sleep(1000);

		}
	}

	public void continueShopping() {
		click(continueShoppingBtn);
	}

}
