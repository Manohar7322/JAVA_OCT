package TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC_TestNG {
    
    WebDriver driver;

    // Test method that runs the login test with different sets of credentials
    @Test(dataProvider = "dp")
    public void f(String username, String password) throws InterruptedException {
        System.out.println("This is the test");
        // Enter email and password
        driver.findElement(By.id("input-email")).sendKeys(username);
        driver.findElement(By.id("input-password")).sendKeys(password);
        // Click login button
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        // Adding a wait time for login to complete
        Thread.sleep(20000); 
    }

    // DataProvider supplies data (username and password) to the test method
    @DataProvider(name = "dp")
    public Object[][] dp() {
        return new Object[][] {
            {"MANU2024@gmail.com", "Opencart@2025"},  // Correct credentials
            {"MANU2025r@example.com", "incorrectPassword"}  // Incorrect credentials for negative testing
        };
    }

    // This method runs before every test method
    @BeforeMethod
    public void beforeMethod() {
        // Setting up Edge browser using WebDriverManager
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        // Maximize the browser window and navigate to the login page
        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com/en-gb?route=account/login");
        System.out.println("This is the @BeforeMethod");
    }

    // This method runs after every test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("This is the @AfterMethod");
        // Close the browser after each test
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("This is the @BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("This is the @AfterClass");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is the @BeforeTest");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is the @AfterTest");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is the @BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("This is the @AfterSuite");
    }
}
