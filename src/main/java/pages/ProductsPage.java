package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {
    private final WebDriver driver;

    // Locators
    private final By inventoryItem = By.cssSelector(".inventory_item");
    private final By inventoryItemName = By.cssSelector(".inventory_item_name");
    private final By inventoryItemPrice = By.cssSelector(".inventory_item_price");
    private final By addToCartButtons = By.cssSelector("button.btn_inventory");
    private final By sortDropdown = By.cssSelector(".product_sort_container");
    private final By cartBadge = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoaded() {
        return !driver.findElements(inventoryItem).isEmpty();
    }

    public void sortByPriceLowToHigh() {
        driver.findElement(sortDropdown).click();
        driver.findElement(By.cssSelector("option[value='lohi']")).click();
    }

    public List<Double> getDisplayedPrices() {
        List<WebElement> items = driver.findElements(inventoryItem);
        return items.stream()
                .map(i -> i.findElement(inventoryItemPrice).getText().replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
    }

    public void addFirstNItemsToCart(int n) {
        List<WebElement> buttons = driver.findElements(addToCartButtons);
        for (int i = 0; i < Math.min(n, buttons.size()); i++) {
            buttons.get(i).click();
        }
    }

    public String getCartBadgeCount() {
        List<WebElement> badges = driver.findElements(cartBadge);
        return badges.isEmpty() ? "0" : badges.get(0).getText();
    }

    public void openCart() {
        driver.findElement(cartLink).click();
    }

    public List<String> getProductNames() {
        return driver.findElements(inventoryItemName).stream()
                .map(WebElement::getText).collect(Collectors.toList());
    }

    public boolean isSortedAscendingByPrice() {
        List<Double> prices = getDisplayedPrices();
        List<Double> sorted = prices.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        return prices.equals(sorted);
    }
}
