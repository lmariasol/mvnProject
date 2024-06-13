package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ProductsPage;

public class SortingProductsTest extends BaseTest{

	@Test
	public void tc_01_LowToHighPrice() {
		// Products Page
		ProductsPage products = new ProductsPage(driver);
		System.out.println(products.getListOfProductPrices());
		// Click on Sort button, select low to high sorting
		products.sortProducts("lohi");
		Assert.assertTrue(products.checkIfLowToHighPriceSorted(products.getListOfProductPrices()));
		System.out.println(products.getListOfProductPrices());
	}

	@Test
	public void tc_02_HighToLowPrice() {
		ProductsPage products = new ProductsPage(driver);
		System.out.println(products.getListOfProductPrices());
		// Click on Sort button, select high to low high sorting
		products.sortProducts("hilo");
		Assert.assertTrue(products.checkIfHighToLowPriceSorted(products.getListOfProductPrices()));
		System.out.println(products.getListOfProductPrices());
	}

	@Test
	public void tc_03_AtoZSortingProducts() {
		ProductsPage products = new ProductsPage(driver);
		// Name (A to Z)
		products.sortProducts("az");
		Assert.assertTrue(products.checkIfAtoZSorted(products.getListOfProductNames()));
	}

	@Test
	public void tc_03_ZtoASortingProducts() {
		ProductsPage products = new ProductsPage(driver);
		// Name (Z to A)
		products.sortProducts("za");
		Assert.assertTrue(products.checkIfZtoASorted(products.getListOfProductNames()));
	}
}