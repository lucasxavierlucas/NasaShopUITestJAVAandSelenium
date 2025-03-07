package main.java.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShopNasaPage {
    private final WebDriverWait wait;

    // Constants
    private static final String SEARCH_BUTTON_SELECTOR = "[aria-label='Search']";
    private static final String SEARCH_BOX_SELECTOR = "input.predictive-search__input"; // Replace with actual selector
    private static final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(10);
    private static final String ELEMENT_NOT_FOUND_ERROR = "ERROR: One of the elements was not found. Please verify selectors.";
    private static final String UNEXPECTED_ISSUE_ERROR = "ERROR: An unexpected issue occurred during search.";
    private static final String ADD_TO_CART_BUTTON_SELECTOR = "#AddToCart"; // Extracted constant
    private static final String VIEW_CART = ".cart-notification__view-cart"; // Extracted constant
    private static final String TOTAL_COST_SELECTOR = "div.cart__total-container span.heading.h6:nth-of-type(2)";
    private static final String CHECKOUT_BUTTON_SELECTOR = "button.cart__checkout-button.checkout-button.button--primary.button--full";
    private static final String PRODUCT_TITLE = "Peanuts Peace On Earth Unisex T-Shirt";
    private static final String PRODUCT_NOT_FOUND_MESSAGE = "Product with title '%s' not found.";
    private static final By productTitleSelector = By.cssSelector("p._1tx8jg70._1fragemlo._1tx8jg7c._1tx8jg7b");
    
    // Constructor
    public ShopNasaPage(WebDriver driver) {
        this.wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
    }

    // Perform the search operation
    public void performSearch(String searchTerm) {
        try {
            clickSearchButton();
            enterSearchTerm(searchTerm);
        } catch (NoSuchElementException e) {
            logError(ELEMENT_NOT_FOUND_ERROR, e);
        } catch (Exception e) {
            logError(UNEXPECTED_ISSUE_ERROR, e);
        }
    }

    private void clickSearchButton() {
        WebElement searchButton = waitForElement(By.cssSelector(SEARCH_BUTTON_SELECTOR), true);
        searchButton.click();
    }

    private void enterSearchTerm(String searchTerm) {
        WebElement searchBox = waitForElement(By.cssSelector(SEARCH_BOX_SELECTOR), false);
        searchBox.clear();
        searchBox.sendKeys(searchTerm);
        searchBox.submit();
    }

    private WebElement waitForElement(By locator, boolean shouldWaitForClickability) {
        if (shouldWaitForClickability) {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        }
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void logError(String message, Exception e) {
        System.err.println(message + " " + e.getMessage());
    }

    public void findProductByTitle() {
        By productLocator = getProductLocatorByTitle(PRODUCT_TITLE);
        try {
            WebElement productElement = waitForElement(productLocator, true);
            productElement.click();
        } catch (NoSuchElementException e) {
            handleProductNotFound(PRODUCT_TITLE, e);
        }
    }

    private By getProductLocatorByTitle(String title) {
        return By.xpath("//a[contains(@class, 'product-item-meta__title') and contains(text(), '" + title + "')]");
    }

    private void handleProductNotFound(String title, NoSuchElementException e) {
        String errorMessage = String.format(PRODUCT_NOT_FOUND_MESSAGE, title);
        logError(errorMessage, e);
    }

    public void assertProductTitle() {
        try {
            WebElement productTitleElement = waitForElement(productTitleSelector, false);
            String actualTitle = productTitleElement.getText().trim();

            if (!actualTitle.equals(PRODUCT_TITLE)) {
                throw new AssertionError("Product title assertion failed: Expected '" + PRODUCT_TITLE + "', but found '" + actualTitle + "'.");
            }

            System.out.println("Product title assertion passed: " + actualTitle);
        } catch (NoSuchElementException e) {
            logError("Product title element not found.", e);
        } catch (Exception e) {
            logError("Unexpected error during product title assertion.", e);
        }
    }


    public void addToCart() {
        try {
            WebElement addToCartButton = waitForElement(By.cssSelector(ADD_TO_CART_BUTTON_SELECTOR), true);
            addToCartButton.click();
            System.out.println("Product successfully added to cart.");
        } catch (NoSuchElementException e) {
            logError("Add to Cart button not found.", e);
        } catch (Exception e) {
            logError("Unexpected error occurred while attempting to add to cart.", e);
        }
    }

    public void viewCart() {
        try {
            WebElement viewCartButton = waitForElement(By.cssSelector(VIEW_CART), true);
            viewCartButton.click();
            System.out.println("Viewing cart.");
        } catch (NoSuchElementException e) {
            logError("View Cart button not found.", e);
        } catch (Exception e) {
            logError("Unexpected error occurred while attempting to view cart.", e);
        }
    }

    public void validateTotalCost(String expectedCost) {
        try {
            WebElement totalCostElement = waitForElement(By.cssSelector(TOTAL_COST_SELECTOR), false);
            String actualCost = totalCostElement.getText().trim();

            if (!actualCost.equals(expectedCost)) {
                throw new AssertionError("Cost validation failed: Expected '" + expectedCost + "', but found '" + actualCost + "'.");
            }

            System.out.println("Cost validation passed: " + actualCost);
        } catch (NoSuchElementException e) {
            logError("Total cost element not found.", e);
        } catch (Exception e) {
            logError("Unexpected error during total cost validation.", e);
        }
    }

    public void checkout() {
        try {
            WebElement checkoutButton = waitForElement(By.cssSelector(CHECKOUT_BUTTON_SELECTOR), true);
            checkoutButton.click();
            System.out.println("Checkout successful.");
        } catch (NoSuchElementException e) {
            logError("Checkout button not found.", e);
        } catch (Exception e) {
            logError("Unexpected error occurred while attempting to checkout.", e);
        }

    }

}

    



