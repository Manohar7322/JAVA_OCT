package Selenium_lab;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab_5 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set implicit wait

        // part-1: Launch App
        driver.get("https://demo.opencart.com/index.php?route=account/register");

        // 1. Verify the page heading 'Register Account'
        WebElement pageHeading = driver.findElement(By.xpath("//h1[contains(text(), 'Register Account')]"));
        String headingText = pageHeading.getText();
        if (headingText.equals("Register Account")) {
            System.out.println("Page heading 'Register Account' is displayed correctly.");
        } else {
            System.out.println("Page heading is incorrect: " + headingText);
        }

        // part-2: Personal Details (Leave blank intentionally for testing)

        // part-3: Auto Scroll to the Continue Button and Click
        WebElement continueButton = driver.findElement(
            By.xpath("//button[@type='submit' or @value='Continue' or contains(text(), 'Continue')]"));
        
        // Scroll to the Continue button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueButton);

        // Use regular click() instead of JavascriptExecutor for proper form validation
        continueButton.click();

        // part-4: Wait for and Verify the warning message 'Warning: You must agree to the Privacy Policy!'
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(Exception.class);

        try {
            // Look for the warning message after clicking the continue button
            WebElement warningMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(text(), 'Warning: You must agree to the Privacy Policy!')]")));
            System.out.println("Warning message displayed: " + warningMessage.getText());
        } catch (Exception e) {
            // If warning message is not found, show an error message
            System.out.println("Warning message not found. Form submission failed.");
        }

        // Clean up and close the browser
        driver.quit();
    }
}

