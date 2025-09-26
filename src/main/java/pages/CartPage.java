package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private final WebDriver driver;

    // Locators
    private final By cartItems = By.cssSelector(".cart_item");
    private final By cartItemName = By.cssSelector(".inventory_item_name");
    private final By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getCartItemNames() {
        return driver.findElements(cartItems).stream()
                .map(i -> i.findElement(cartItemName).getText())
                .collect(Collectors.toList());
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
