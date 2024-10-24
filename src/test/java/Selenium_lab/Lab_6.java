package Selenium_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Lab_6 {
    public static void main(String[] args) throws InterruptedException {
        // Step 1: Setup WebDriver for Edge browser
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        // Maximize the browser window and clear cookies
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        // Step 2: Navigate to login page
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        // Step 3: Enter login credentials
        driver.findElement(By.id("input-email")).sendKeys("hussainengineer2026@gmail.com"); // Email from Lab 1
        driver.findElement(By.id("input-password")).sendKeys("Opencart@2025");               // Password from Lab 1
        // Step 4: Click login button using JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increased to 20 seconds
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit' and contains(@class, 'btn btn-primary')]")));
        js.executeScript("arguments[0].click();", loginButton);

        // Step 5: Navigate to Components > Monitors with Explicit Wait
        WebElement componentsTab = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Components']")));
        componentsTab.click();

        // Add an increased wait to ensure the 'Monitors' link is visible and clickable
        WebElement monitorsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Monitors')]")));
        js.executeScript("arguments[0].click();", monitorsLink);

        // Step 6: Set the limit to 25 products per page
        WebElement limitDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("input-limit")));
        js.executeScript("arguments[0].value='https://demo.opencart.com/en-gb/catalog/component/monitor?limit=25';", limitDropdown);
        js.executeScript("arguments[0].dispatchEvent(new Event('change'));", limitDropdown);

        // Step 7: Add the first monitor to the cart
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='product-list']/div[1]//button[@type='submit' and @aria-label='Add to Cart']")));
        js.executeScript("arguments[0].click();", cartButton);

        // Step 8: Verify success message for adding monitor
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
        System.out.println("Monitor added successfully: " + successMessage.getText());

        // Step 9: Search for 'Mobile' in the search box
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("HTC Touch HD");
        driver.findElement(By.xpath("//button[@type='button' and contains(@class,'btn btn-default btn-lg')]")).click();

        // Step 10: Select HTC Touch HD from search results
        WebElement htcMobile = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='HTC Touch HD']")));
        htcMobile.click();

        // Step 11: Add HTC Touch HD to the cart
        WebElement addToCartHTC = wait.until(ExpectedConditions.elementToBeClickable(By.id("button-cart")));
        js.executeScript("arguments[0].click();", addToCartHTC);

        // Step 12: Verify success message for adding HTC Touch HD
        WebElement successMessageHTC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
        System.out.println("HTC Touch HD added successfully: " + successMessageHTC.getText());

        // Step 13: Clear the quantity field and set it to 3
        WebElement quantityBox = driver.findElement(By.id("input-quantity"));
        quantityBox.clear();
        quantityBox.sendKeys("3");
        driver.findElement(By.id("button-cart")).click();

        // Step 14: Verify cart update success
        WebElement cartSuccessMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'alert-success')]")));
        System.out.println("Quantity updated successfully: " + cartSuccessMessage.getText());

        // Step 15: Click on 'Checkout' button
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'checkout/checkout')]")));
        checkoutButton.click();

        // Step 16: Perform checkout process (skipping detailed steps as it depends on OpenCart's flow)
        // You can automate filling out the checkout form if needed.

        // Step 17: Click on 'My Account' and log out
        WebElement myAccountDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='My Account']")));
        myAccountDropdown.click();
        WebElement logoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Logout']")));
        logoutButton.click();

        // Step 18: Verify successful logout and click continue
        WebElement logoutHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Account Logout']")));
        System.out.println("Logout successful: " + logoutHeading.getText());
        WebElement continueButton = driver.findElement(By.xpath("//a[text()='Continue']"));
        continueButton.click();

        // Step 19: Close the browser
        driver.quit();
    }
}
