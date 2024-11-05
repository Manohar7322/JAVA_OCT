package Selenium_lab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Lab_12 {
    public static void main(String[] args) {
        Properties props = new Properties();
        WebDriver driver = null;

        try {
            // Check if config.properties file exists
            File configFile = new File("config.properties");
            if (!configFile.exists()) {
                System.out.println("Error: config.properties file not found!");
                return;
            }

            // Load properties file
            FileInputStream fis = new FileInputStream(configFile);
            props.load(fis);

            // Set up ChromeDriver
            System.setProperty("webdriver.chrome.driver", props.getProperty("chromedriver"));
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Open the URL
            driver.get(props.getProperty("url"));

            // Step 3: Verify page title
            String expectedTitle = "Your Expected Title Here"; // Update this with actual title
            Assert.assertEquals(expectedTitle, driver.getTitle());

            // Step 4-5: Navigate to Desktops -> Mac
            driver.findElement(getBy(props.getProperty("desktops_tab"))).click();
            driver.findElement(getBy(props.getProperty("mac_link"))).click();

            // Step 6: Sort by Name (A-Z)
            WebElement sortBy = driver.findElement(getBy(props.getProperty("sort_by_dropdown")));
            sortBy.sendKeys(props.getProperty("sort_by_name"));

            // Step 7: Click 'Add to Cart' for Mac
            driver.findElement(getBy(props.getProperty("add_to_cart_button"))).click();

            // Step 8-9: Search for 'Mobile'
            driver.findElement(getBy(props.getProperty("search_box"))).sendKeys("Mobile");
            driver.findElement(getBy(props.getProperty("search_button"))).click();
            
            // Wait for search results
            Thread.sleep(2000);

            // Step 10: Clear 'Search Criteria' text box
            WebElement searchBox = driver.findElement(getBy(props.getProperty("search_box")));
            searchBox.clear();

            // Step 11-12: Check 'Search in product descriptions' and search again
            driver.findElement(getBy(props.getProperty("product_description_checkbox"))).click();
            driver.findElement(getBy(props.getProperty("search_button"))).click();

            // Step 13: Verify the 'Mac' heading
            WebElement macHeading = driver.findElement(getBy(props.getProperty("mac_heading")));
            Assert.assertTrue(macHeading.isDisplayed());

            // Step 14: Change 'Mobile' to 'Monitors' and repeat steps
            searchBox.clear();
            searchBox.sendKeys("Monitors");
            driver.findElement(getBy(props.getProperty("search_button"))).click();

            // Export test case and complete steps as per Lab Demo 4 instructions
            // You may save the test case and check the 'Pass' status as needed
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the driver
            if (driver != null) {
                driver.quit();
            }
        }
    }

    // Helper method to interpret locators from properties file
    private static By getBy(String locator) {
        String[] locatorParts = locator.split("=", 2);
        String locatorType = locatorParts[0];
        String locatorValue = locatorParts[1];

        switch (locatorType) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "linkText":
                return By.linkText(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            default:
                throw new IllegalArgumentException("Invalid locator type: " + locatorType);
        }
    }
}
