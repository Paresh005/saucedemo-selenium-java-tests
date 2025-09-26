package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent {
    private final WebDriver driver;

    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutLink = By.id("logout_sidebar_link");

    public HeaderComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    public void logout() {
        openMenu();
        // small wait-free approach: element is present after animation
        driver.findElement(logoutLink).click();
    }
}
