package Tasks_21_3;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;


public class Task_16 {

        private EdgeDriver driver;
        private WebDriverWait wait;

        @BeforeMethod
        public void setUp() {
            // Set up WebDriver
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            driver = new EdgeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        }

        @Test
        public void completeCheckoutProcess() {
            // 1. Launch browser and 2. Navigate to url
            driver.get("http://automationexercise.com");

            // 3. Verify that home page is visible successfully
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".logo img")));
            Assert.assertTrue(logo.isDisplayed(), "Home page logo is not displayed");
            WebElement sliderCarousel = driver.findElement(By.id("slider-carousel"));
            Assert.assertTrue(sliderCarousel.isDisplayed(), "Home page slider is not displayed");

            // 4. Click 'Signup / Login' button
            driver.findElement(By.cssSelector("a[href='/login']")).click();

            // 5. Fill email, password and click 'Login' button
            String email = "your_test_email@example.com"; // Use your test email
            String password = "your_test_password"; // Use your test password

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.login-form")));
            driver.findElement(By.cssSelector("input[data-qa='login-email']")).sendKeys(email);
            driver.findElement(By.cssSelector("input[data-qa='login-password']")).sendKeys(password);
            driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();

            // 6. Verify 'Logged in as username' at top
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:contains('Logged in as')")));
            String loggedInText = driver.findElement(By.cssSelector("li a")).getText();
            Assert.assertTrue(loggedInText.contains("Logged in as"), "User is not logged in correctly");

            // 7. Add products to cart
            // Navigate to products page
            driver.findElement(By.cssSelector("a[href='/products']")).click();

            // Add first product to cart
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".features_items")));
            driver.findElement(By.cssSelector("a.add-to-cart[data-product-id='1']")).click();

            // Continue shopping
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.continue-shopping")));
            driver.findElement(By.cssSelector("button.continue-shopping")).click();

            // Add second product to cart
            driver.findElement(By.cssSelector("a.add-to-cart[data-product-id='2']")).click();

            // 8. Click 'Cart' button
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.continue-shopping")));
            driver.findElement(By.cssSelector("button.continue-shopping")).click();
            driver.findElement(By.cssSelector("a[href='/view_cart']")).click();

            // 9. Verify that cart page is displayed
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart_info")));
            WebElement cartInfo = driver.findElement(By.cssSelector("#cart_info"));
            Assert.assertTrue(cartInfo.isDisplayed(), "Cart page is not displayed");

            // 10. Click Proceed To Checkout
            driver.findElement(By.cssSelector(".check_out")).click();

            // 11. Verify Address Details and Review Your Order
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#address_delivery")));
            WebElement addressDetails = driver.findElement(By.cssSelector("#address_delivery"));
            Assert.assertTrue(addressDetails.isDisplayed(), "Address Details are not displayed");

            WebElement orderReview = driver.findElement(By.cssSelector("#cart_info"));
            Assert.assertTrue(orderReview.isDisplayed(), "Order Review is not displayed");

            // 12. Enter description in comment text area and click 'Place Order'
            driver.findElement(By.cssSelector("textarea.form-control")).sendKeys("Please deliver as soon as possible.");
            driver.findElement(By.cssSelector("a.check_out")).click();

            // 13. Enter payment details: Name on Card, Card Number, CVC, Expiration date
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.payment-information")));
            driver.findElement(By.cssSelector("input[data-qa='name-on-card']")).sendKeys("Test User");
            driver.findElement(By.cssSelector("input[data-qa='card-number']")).sendKeys("4111111111111111");
            driver.findElement(By.cssSelector("input[data-qa='cvc']")).sendKeys("123");
            driver.findElement(By.cssSelector("input[data-qa='expiry-month']")).sendKeys("12");
            driver.findElement(By.cssSelector("input[data-qa='expiry-year']")).sendKeys("2030");

            // 14. Click 'Pay and Confirm Order' button
            driver.findElement(By.cssSelector("button[data-qa='pay-button']")).click();

            // 15. Verify success message 'Your order has been placed successfully!'
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.alert-success")));
            WebElement successMessage = driver.findElement(By.cssSelector("div.alert-success"));
            Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed");
            Assert.assertTrue(successMessage.getText().contains("Your order has been placed successfully"),
                    "Success message does not contain expected text");

            // 16. Click 'Delete Account' button
            driver.findElement(By.cssSelector("a[href='/delete_account']")).click();

            // 17. Verify 'ACCOUNT DELETED!' and click 'Continue' button
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.title")));
            WebElement accountDeletedMessage = driver.findElement(By.cssSelector("h2.title"));
            Assert.assertEquals(accountDeletedMessage.getText(), "ACCOUNT DELETED!",
                    "Account deleted message is not displayed correctly");

            driver.findElement(By.cssSelector("a.btn.btn-primary")).click();
        }

        @AfterMethod
        public void tearDown() {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }


