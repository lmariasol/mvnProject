package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.ProductPage;
import pageObjects.ProductsPage;
import pageObjects.Saucelabs_Page;

public class SidebarMenuTest extends BaseTest {

	@Test
	public void tc01_openSideMenu() {
		ProductsPage products = new ProductsPage(driver);
		products.openSidebarMenu();
		// Assert
		WebElement closeMenuBtn = driver.findElement(By.cssSelector(".bm-cross-button > #react-burger-cross-btn"));
		boolean checkLogoutLinkPresence = closeMenuBtn.isDisplayed();
		Assert.assertTrue(checkLogoutLinkPresence);
		products.closeSidebarMenu();
	}

	@Test
	public void tc02_Menu_About() {
		ProductsPage products = new ProductsPage(driver);
		products.openSidebarMenu();
		products.selectMenuOptions("About");
		Saucelabs_Page slp = new Saucelabs_Page(driver);
		String actual = slp.getPageTitle();
		String expected = "Sauce Labs: Cross Browser Testing, Selenium Testing & Mobile Testing";
		Assert.assertEquals(actual, expected);
		slp.back();
	}

	@Test
	public void tc03_AllItems() {
		ProductsPage products = new ProductsPage(driver);
		products.selectProduct("Sauce Labs Fleece Jacket");
		ProductPage product = new ProductPage(driver);
		product.openSidebarMenu();
		product.selectMenuOptions("All Items");
		products = new ProductsPage(driver);
		products.sleep(500);
		Assert.assertTrue(products.isProductsPage());
	}

	@Test
	public void tc04_Logout() {
		ProductsPage products = new ProductsPage(driver);
		products.openSidebarMenu();
		products.selectMenuOptions("Logout");
		LoginPage lp = new LoginPage(driver);
		lp.sleep(3000);
		WebElement loginBtn = driver.findElement(By.cssSelector("#login-button"));
		Assert.assertTrue(loginBtn.isDisplayed());
	}
}
