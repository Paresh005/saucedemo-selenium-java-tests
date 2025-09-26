package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected final String baseUrl = "https://www.saucedemo.com/";

    @BeforeMethod
    public void setUp() {
        // Setup Chrome driver automatically
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Run headed for demo clarity; set to headless() if needed for CI
        options.addArguments("--start-maximized");
        driver = new org.openqa.selenium.chrome.ChromeDriver(options);

        // Navigate to base URL for each test to keep tests independent
        driver.get(baseUrl);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
