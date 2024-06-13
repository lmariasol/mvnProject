package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends SidebarMenuPage {

	// Elements------------------------------------------------------------------
	@FindBy(css = ".inventory_item_label > a")
	List<WebElement> listOfProducts;

	@FindBy(css = "#shopping_cart_container")
	WebElement goToShoppingCartBtn;

	@FindBy(css = ".product_sort_container")
	WebElement sortBtn;

	@FindBy(css = ".inventory_item_description > .pricebar>  .inventory_item_price")
	List<WebElement> productPrice;

	@FindBy(css = ".header_secondary_container > .title")
	WebElement pageTitle;

	// Constructor---------------------------------------------------------------
	public ProductsPage(WebDriver driver) {
		super(driver);
	}

	// Methods-------------------------------------------------------------------
	public boolean isProductsPage() {
		String productsPageTitle = pageTitle.getText();
		if (productsPageTitle.equalsIgnoreCase("Products")) {
			return true;
		}
		return false;
	}

	public void selectProduct(String name) {
		// List of products
		for (WebElement element : listOfProducts) {
			sleep(300);
			System.out.println(element.getText());
			if (getText(element).equalsIgnoreCase(name)) {
				System.out.println("choosen product " + name);
				click(element);
				break;
			}
		}

	}

	public void goToShoppingCart() {
		click(goToShoppingCartBtn);
		sleep(1000);
	}

	// Select Sorting options ("az = a-to-z","za = z-to-a","lohi = low to high","hilo = hihg to low")
	public void sortProducts(String s) {
		click(sortBtn);
		Select dropdown = new Select(sortBtn);
		try {
			dropdown.selectByValue(s);
			// sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// System.out.println(products.getProductNames()); - to wright in the console
	// all the list
	public List<String> getListOfProductNames() {
		List<String> listOfProductNames = new ArrayList<String>();
		for (WebElement element : listOfProducts) {
			listOfProductNames.add(element.getText());
		}
		return listOfProductNames;
	}

	public List<Double> getListOfProductPrices() { // check this code
		double price = 0.0;
		List<Double> listOfProductsPrices = new ArrayList<Double>();
		for (WebElement element : productPrice) {
			// WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
			// w.until(ExpectedConditions.visibilityOf(productPrice));
			String priceText = getText(element);
			
			// Remove the dollar sign using substring manipulation
			String priceWithoutDollarSign = priceText.substring(1);
			
			// System.out.println("Extracted price: " + priceWithoutDollarSign);
			price = Double.parseDouble(priceWithoutDollarSign);
			listOfProductsPrices.add(price);
			sleep(300);
		}
		return listOfProductsPrices;
	}

	public boolean checkIfLowToHighPriceSorted(List<Double> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) <= list.get(i + 1))
				;
		}
		return true;
	}

	public boolean checkIfHighToLowPriceSorted(List<Double> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) >= list.get(i + 1))
				;
		}
		return true;
	}

	public boolean checkIfAtoZSorted(List<String> list) {
		// 1. Sort the list in ascending order (A-to-Z)
		Collections.sort(list);

		// 2. Check if the original and sorted list are the same
		// This ensures the entire list was sorted correctly
		return list.equals(new ArrayList<>(list)); // Create a copy to avoid modifying original list
	}

	public boolean checkIfZtoASorted(List<String> list) {
		// 1. Create a custom comparator for reverse alphabetical order
		Comparator<String> reverseComparator = Collections.reverseOrder();

		// 2. Sort the list using the custom comparator (Z-to-A)
		Collections.sort(list, reverseComparator);

		// 3. Check if the original and sorted list are the same
		// This ensures the entire list was sorted correctly (already in reverse order)
		return list.equals(new ArrayList<>(list));
	}
}