package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutCompletePage;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import utils.ConfigurationReader;


public class BuyProductE2ETest extends BaseTest{

	@Test(description = "Buy Product E2E")
	public void tc01_BuyProduct() {
		// Find products
		ProductsPage products = new ProductsPage(driver);
		products.selectProduct("Sauce Labs Fleece Jacket");

		// Add product #1 to shopping cart
		ProductPage product = new ProductPage(driver);
		product.addToCart();

		// Open Shopping Cart page
		products = new ProductsPage(driver);
		products.goToShoppingCart();

		// Continue
		CartPage shoppingCartPage = new CartPage(driver);
		shoppingCartPage.proceedToCheckout();

		// Checkout: Your Information page
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		checkoutPage.fillCheckoutForm(
				ConfigurationReader.readProperty("CheckoutPage_firstName"),
				"CheckoutPage_lastName",
				"CheckoutPage_zipCode");

		// Checkout: Overview page
		CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);
		checkoutOverviewPage.completePurchaseProducts();

		// Checkout: Complete page
		CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
		String actual = checkoutCompletePage.getTitleText();
		String expected = "Checkout: Complete!";
		Assert.assertEquals(actual, expected);
	}
}