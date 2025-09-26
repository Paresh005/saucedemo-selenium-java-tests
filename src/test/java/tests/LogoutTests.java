package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HeaderComponent;
import pages.LoginPage;
import pages.ProductsPage;

public class LogoutTests extends BaseTest {

    @BeforeMethod
    public void login() {
        new LoginPage(driver).login("standard_user", "secret_sauce");
    }

    @Test
    public void logout_returnsToLoginPage() {
        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertTrue(productsPage.isLoaded(), "Products page should be loaded.");

        HeaderComponent header = new HeaderComponent(driver);
        header.logout();

        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isOnLoginPage(),
                "User should be redirected to login page after logout.");
    }
}
