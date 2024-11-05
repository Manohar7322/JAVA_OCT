package Selenium_lab;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Lab_14 {
    public static void main(String[] args) {
        WebDriver driver = null;
        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            // Load Excel file
            fis = new FileInputStream("UserDetails.xlsx"); // Adjust the path as needed
            workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet1"); // Assumes data is in Sheet1

            // Set up ChromeDriver
            System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Update path to chromedriver
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Open the URL
            driver.get("http://demo.opencart.com/");
            
            // Step 2: Verify page title
            String expectedTitle = "Your store"; // Update as necessary
            Assert.assertEquals(driver.getTitle(), expectedTitle);

            // Step 3: Navigate to 'My Account' -> 'Register'
            driver.findElement(By.linkText("My Account")).click();
            driver.findElement(By.linkText("Register")).click();

            // Step 5: Verify 'Register Account' text is present
            WebElement registerText = driver.findElement(By.tagName("h1"));
            Assert.assertTrue(registerText.getText().contains("Register Account"));

            // Step 6: Read data from the Excel sheet and fill out the form
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Skip header row
                Row row = sheet.getRow(i);
                String firstName = row.getCell(0).getStringCellValue();
                String lastName = row.getCell(1).getStringCellValue();
                String email = row.getCell(2).getStringCellValue();
                String telephone = row.getCell(3).getStringCellValue();
                String password = row.getCell(4).getStringCellValue();
                String passwordConfirm = row.getCell(5).getStringCellValue();

                // Enter data in the form
                driver.findElement(By.id("input-firstname")).sendKeys(firstName);
                driver.findElement(By.id("input-lastname")).sendKeys(lastName);
                driver.findElement(By.id("input-email")).sendKeys(email);
                driver.findElement(By.id("input-telephone")).sendKeys(telephone);
                driver.findElement(By.id("input-password")).sendKeys(password);
                driver.findElement(By.id("input-confirm")).sendKeys(passwordConfirm);

                // Step 7: Check 'Privacy Policy' checkbox
                driver.findElement(By.name("agree")).click();

                // Step 8: Click 'Continue' button
                driver.findElement(By.cssSelector("input[type='submit'][value='Continue']")).click();

                // Step 9: Verify account creation acknowledgment
                WebElement successMessage = driver.findElement(By.cssSelector("div#content h1"));
                Assert.assertTrue(successMessage.getText().contains("Your Account Has Been Created"));

                // Optional: Log out and prepare for the next iteration
                driver.findElement(By.linkText("Logout")).click();
                driver.findElement(By.linkText("Register")).click();
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (workbook != null) workbook.close();
                if (fis != null) fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (driver != null) driver.quit();
        }
    }
}
