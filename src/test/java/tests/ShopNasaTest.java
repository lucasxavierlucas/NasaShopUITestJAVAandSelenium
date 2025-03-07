package test.java.tests;

import main.java.pages.ShopNasaPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShopNasaTest {

    // Path to the ChromeDriver executable (update if necessary)
    private static final String CHROME_DRIVER_PATH = "C:\\Users\\lucas\\.cache\\selenium\\chromedriver\\win64\\133.0.6943.141\\chromedriver.exe";

    public static void main(String[] args) {
        // Set the system property for ChromeDriver to ensure Selenium can locate it
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);

        // Instantiate the WebDriver (Google Chrome in this case)
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the Shop NASA website
            driver.get("https://www.shopnasa.com/");

            // Initialize the ShopNasaPage object with the driver
            ShopNasaPage shopNasaPage = new ShopNasaPage(driver);

            // Step 1: Perform a search for the product "Peace"
            shopNasaPage.performSearch("Peace");

            // Step 2: Locate the desired product on the page by its title
            shopNasaPage.findProductByTitle();

            // Step 3: Add the product to the cart
            shopNasaPage.addToCart();

            // Step 4: Open the cart to review the selected product
            shopNasaPage.viewCart();

            // Step 5: Validate that the total cost of the product in the cart is correct
            shopNasaPage.validateTotalCost("$18.95 USD");

            // Step 6: Proceed to the checkout process (if implemented)
            shopNasaPage.checkout();

            // Step 7: Assert the product title in the cart or during checkout to confirm it matches expectations
            shopNasaPage.assertProductTitle();

        } catch (Exception e) {
            // Print stack trace for any encountered errors during the test
            e.printStackTrace();
        } finally {
            // Close the browser and end the WebDriver session
            driver.quit();
        }
    }
}