package TC;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Google {

    public static void main(String[] args) throws InterruptedException {
        // Set up WebDriverManager and ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Open Google
        driver.get("https://google.com/");

        // Use JavascriptExecutor to trigger an alert
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("alert('search testing method');"); // Triggering alert

        // Handle the alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText()); // Optional: Print alert text
        alert.accept();  // Accept the alert (click OK)

        // Page load timeout
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        System.out.println("Title of the page is: " + driver.getTitle());

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));

        // Fluent wait
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        // Interact with the Google search box
        ele.sendKeys("Testing Method");
        ele.submit();

        // Print the title of the current page
        System.out.println("Title of the page is: " + driver.getTitle());

        // Navigate to Yahoo and back
        driver.navigate().to("https://www.yahoo.com/");
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.navigate().back();
        System.out.println("Title of the page is: " + driver.getTitle());
        driver.navigate().forward();
        System.out.println("Title of the page is: " + driver.getTitle());

        // Print the current URL and page source
        System.out.println("URL is: " + driver.getCurrentUrl());
        System.out.println("Page source contains 'yahoo': " + driver.getPageSource().contains("yahoo"));

        // Close the browser
        driver.quit();
    }
}
