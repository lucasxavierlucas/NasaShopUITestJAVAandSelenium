# NasaShopCheckout Automation

Welcome, team!  

This project is built using **Java** with **Selenium** to automate the purchase of a **"Peanuts Peace On Earth" T-shirt** from the NASA shop website. The goal is to spread peace, one T-shirt at a time, while giving peace a chance. ☮️🌎😉  

---

## Tools and Frameworks Used:

- **Java**: Core programming language for the project.
- **Selenium WebDriver**: To automate browser interactions like searching, clicking, and validating the cart.
- **WebDriverWait**: To handle dynamic element interactions and ensure stability during execution.
- **Chrome WebDriver**: For browser-based automation (can be updated to work with other browsers in future iterations).  

---

## Project Overview:

This project automates the checkout process for adding one **"Peanuts Peace On Earth T-shirt"** to the cart and validating the total cost at checkout. Here’s what it does step by step:

1. **Launch the NASA Shop Website**: Open the browser at [NASA Shop](https://www.shopnasa.com/).  
2. **Search for the Product**: Perform a search for the term "Peace".  
3. **Identify and Select the Product**: Locate the "Peanuts Peace On Earth" T-shirt using specific selectors.  
4. **Add to Cart**: Add the shirt to the shopping cart.  
5. **View Cart**: Navigate to the cart and validate its contents.  
6. **Validate Total Cost**: Ensure the total cost of the order is as expected (`"$18.95 USD"`).  
7. **Checkout**: Automate the checkout process.  
8. **Product Validation**: Assert that the correct product was added to the cart and is ready for checkout.  

---

## How to Execute the Project:  

### Prerequisites
1. **Java Installed**: Ensure you have Java JDK (version 11+ recommended).  
2. **ChromeDriver Installed**: Update the `CHROME_DRIVER_PATH` constant in `ShopNasaTest.java` to match the location of your local ChromeDriver executable.  
3. **Browser Compatibility**: Chrome browser is required for this implementation (can be customized for other browsers).  
4. **IDE Setup**: Use an IDE like IntelliJ IDEA for building and running the project.  

### Steps to Execute:

1. Clone or download the project repository.  
2. Open the project in your IDE.  
3. Configure the `CHROME_DRIVER_PATH` in `ShopNasaTest.java` file to match your local ChromeDriver path.  
4. Run the `ShopNasaTest` class.  
5. Observe the automation flow in the Chrome browser and check for successful completion.

---

## Output:

Upon successful execution, the automation will:  
- Add the **"Peanuts Peace On Earth" T-shirt** to the cart.  
- Validate that the total cost is exactly `$18.95 USD`.  
- Proceed to checkout and verify that the product added matches the title.

---

By automating the purchase of this peaceful T-shirt, we encourage giving peace a chance through technology! May your tests pass, and peace prevail. ☮️  

Enjoy your T-shirt automation journey! 🌌