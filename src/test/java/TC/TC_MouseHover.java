package TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class TC_MouseHover {
    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.get("https://www.snapdeal.com");

        Actions actions = new Actions(driver);
        
        // Locate the "Men's Fashion" element
        WebElement mensFashion = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
        
        // Perform mouse hover on "Men's Fashion"
        actions.moveToElement(mensFashion).perform();
        
        // Add explicit wait for the "Sunglasses" link to be visible and clickable
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sunglasses = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sunglasses']")));
        
        // Click on "Sunglasses"
        sunglasses.click();

        // Close the browser
        driver.quit();
    }
}
