package Selenium_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class Lab_7 {
    public static void main(String[] args) {
        // Setup WebDriver (using WebDriverManager to manage driver binaries)
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        // Maximize browser window
        driver.manage().window().maximize();

        // Step 1: Launch the URL
        driver.get("https://ispace.ig.capgemini.com/sitepages/index.aspx");

        // Step 2: Go to 'Application' tab
        WebElement applicationTab = driver.findElement(By.linkText("Application"));
        applicationTab.click();

        // Step 3: Click on checkbox 'Stationery Request'
        WebElement stationeryCheckbox = driver.findElement(By.id("stationeryCheckbox"));  // Replace with actual ID
        stationeryCheckbox.click();

        // Step 4: Verify new title 'Stationary'
        if (driver.getTitle().contains("Stationary")) {
            System.out.println("Title verified: 'Stationary'");
        } else {
            System.out.println("Title mismatch!");
        }

        // Step 5: On 'Stationery' tab, click 'Submit to collect your Stationery'
        WebElement submitLink = driver.findElement(By.linkText("Submit to collect your Stationery"));
        submitLink.click();

        // Step 6: Switch to the alert
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        // Step 7: Verify text on the alert: 'Please add product(s) to cart'
        String alertText = alert.getText();
        if (alertText.contains("Please add product(s) to cart")) {
            System.out.println("Alert text verified: 'Please add product(s) to cart'");
        } else {
            System.out.println("Alert text mismatch!");
        }

        // Step 8: Verify if 'OK' button is present on the alert
        // Alert automatically comes with an 'OK' button

        // Step 9: Click on 'OK' button
        alert.accept();

        // Step 10: Click on 'Photocopy' tab, click on 'Save Request' button
        WebElement photocopyTab = driver.findElement(By.linkText("Photocopy"));
        photocopyTab.click();
        WebElement saveRequestButton = driver.findElement(By.id("saveRequest"));  // Replace with actual ID
        saveRequestButton.click();

        // Step 11: Switch to alert and verify text 'No changes made'
        alert = wait.until(ExpectedConditions.alertIsPresent());
        if (alert.getText().contains("No changes made")) {
            System.out.println("Alert text verified: 'No changes made'");
        } else {
            System.out.println("Alert text mismatch!");
        }

        // Step 12: Verify if 'OK' button is present
        // Similar to step 8: Alert typically has 'OK' button

        // Step 13: Click on 'OK' button
        alert.accept();

        // Step 14: Click on 'Logout' button
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

        // Step 15: Close the 'Stationery' tab (i.e., close the browser)
        driver.quit();
    }
}
