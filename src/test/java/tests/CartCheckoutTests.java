package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.List;

public class CartCheckoutTests extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @Test
    public void addTwoItemsToCart_cartBadgeShowsTwo_andItemsPresentInCart() {
        ProductsPage products = new ProductsPage(driver);
        products.addFirstNItemsToCart(2);
        Assert.assertEquals(products.getCartBadgeCount(), "2",
                "Cart badge should show 2 after adding two items.");

        products.openCart();
        CartPage cartPage = new CartPage(driver);
        List<String> names = cartPage.getCartItemNames();
        Assert.assertEquals(names.size(), 2, "Cart should contain two items.");
    }

    @Test
    public void completeCheckout_showsThankYouMessage() {
        ProductsPage products = new ProductsPage(driver);
        products.addFirstNItemsToCart(1);
        products.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillCustomerInfo("Jane", "Doe", "75001");
        checkout.clickContinue();
        checkout.clickFinish();

        String completion = checkout.getCompletionText();
        Assert.assertTrue(completion.toLowerCase().contains("thank you"),
                "Completion page should show 'Thank you for your order!'.");
    }
}
