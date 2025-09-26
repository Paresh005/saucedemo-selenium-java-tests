package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCredentials_navigatesToProducts() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isLoaded(), 
                "Products page should be loaded after valid login.");
    }

    @Test
    public void loginWithInvalidCredentials_showsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("invalid_user", "wrong_password");

        String error = loginPage.getErrorText();
        Assert.assertTrue(error.toLowerCase().contains("epic sadface"),
                "An error message should be shown for invalid login.");
        Assert.assertTrue(loginPage.isOnLoginPage(),
                "User should remain on login page when credentials are invalid.");
    }
}
