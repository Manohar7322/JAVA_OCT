package pac_webdriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TC_LAB_5 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/en-gb?route=account/register");
	    driver.manage().window().setSize(new Dimension(1202, 672));

		//verifying the title
		if(driver.getTitle().equals("Register Account")) {
			
			System.out.println("The title is :"+driver.getTitle());
			
			   // Scroll to the bottom of the page
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	        // Wait for the page to load completely
	        Thread.sleep(5000);      
	        
	        // Locate the 'Continue' button and click it
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        //display the alert warning
	        System.out.println("Alert Warning : "+driver.findElement(By.id("alert")).isDisplayed());
	        
	        Thread.sleep(5000);
	        
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

	        
	        Thread.sleep(5000);
	        
	        //Locate First name 
            WebElement Fname=driver.findElement(By.id("input-firstname"));
            
            //Enter the value
            Fname.sendKeys("Srikar");
            Fname.submit();
            
            //Scroll down
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	        Thread.sleep(5000);

           
	        //Click continue
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        //Check warning message
            System.out.println("Firstname warning :"+driver.findElement(By.id("error-firstname")).isDisplayed());
            
            //scroll up
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            
            Thread.sleep(5000);

	        
	        WebElement Lname=driver.findElement(By.id("input-lastname"));
	        Lname.click();
	        
	        Lname.sendKeys("Kotha");
	        Lname.submit();
	        
	      //Scroll down
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	        Thread.sleep(5000);
	        

	      //Click continue
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        //Check warning message
            System.out.println("Lastname warning :"+driver.findElement(By.id("error-lastname")).isDisplayed());
            
          //scroll up
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            
//            Thread.sleep(1000);
            
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");

            
            
            //Email element
            WebElement mail=driver.findElement(By.id("input-email"));
            mail.click();
            
            mail.sendKeys("Srikarkotha2605678@gmail.com");
            mail.submit();
	        
            //Scroll down
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
	        
	        Thread.sleep(3000);
	        
	        //Click continue
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        
	        //Check warning message
            System.out.println("Email warning :"+driver.findElement(By.id("error-email")).isDisplayed());
            
            WebElement pass=driver.findElement(By.id("input-password"));
            pass.sendKeys("Srikar@123");
            pass.submit();
            
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            
            //Check warning message
            System.out.println("Email warning :"+driver.findElement(By.id("error-email")).isDisplayed());
            
            WebElement agr=driver.findElement(By.name("agree"));
            agr.click();
            
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            
            Thread.sleep(5000);
            
            WebElement con=driver.findElement(By.linkText("Your Account Has Been Created!"));
            System.out.println("confirmation :"+con.isDisplayed());
            
            driver.findElement(By.linkText("Continue")).click();
            
            driver.close();
            
		}
		else {
			System.out.println("Title mismatched");
		}
			
		
		
		
		
		
		
	}
	

}
