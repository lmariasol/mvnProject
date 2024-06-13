package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import utils.ConfigurationReader;

public class LoginTestSuccess extends BaseTest {
	
	@Override
	public void setupLogin() {
		
	}

	@Test
	public void tc01_Login_Success() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm(ConfigurationReader.readProperty("user1"), ConfigurationReader.readProperty("password1"));
		ProductsPage products = new ProductsPage(driver);
		// Assert
		String expected = "Swag Labs";
		String actual = products.getPageTitle();
		Assert.assertEquals(actual, expected);
	}
	
	@Test
	public void tc02_Login_Success() {
		// Login
		LoginPage lp = new LoginPage(driver);
		lp.loginForm(ConfigurationReader.readProperty("user3"), ConfigurationReader.readProperty("password3"));
		ProductsPage products = new ProductsPage(driver);
		// Assert
		String expected = "Swag Labs";
		String actual = products.getPageTitle();
		Assert.assertEquals(actual, expected);
	}
}