package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductTests extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @Test
    public void sortByPriceLowToHigh_displaysAscendingOrder() {
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isLoaded(), "Products page should be loaded.");

        productsPage.sortByPriceLowToHigh();
        Assert.assertTrue(productsPage.isSortedAscendingByPrice(),
                "Prices should be sorted ascending after selecting 'low to high'.");
    }
}
