package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private final WebDriver driver;

    // Step One
    private final By firstName = By.id("first-name");
    private final By lastName = By.id("last-name");
    private final By postalCode = By.id("postal-code");
    private final By continueButton = By.id("continue");

    // Step Two
    private final By finishButton = By.id("finish");
    private final By completeHeader = By.cssSelector(".complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillCustomerInfo(String f, String l, String p) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(f);
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(l);
        driver.findElement(postalCode).clear();
        driver.findElement(postalCode).sendKeys(p);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    public String getCompletionText() {
        return driver.findElement(completeHeader).getText();
    }
}
