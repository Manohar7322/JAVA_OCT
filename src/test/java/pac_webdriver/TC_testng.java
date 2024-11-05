package pac_webdriver;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC_testng {
	
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String username , String password) throws InterruptedException {
	  
//	  System.out.println("This is the test");
	  
	  
	  if(driver.findElement(By.id("input-email")).isDisplayed()) {
	  driver.findElement(By.id("input-email")).sendKeys(username);
	  Assert.assertTrue(true);
	  }
	  else
	  {
		  Assert.assertTrue(false);  
	  }
	  driver.findElement(By.id("input-password")).sendKeys(password);
	  
//	  Thread.sleep(2000);
		
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  driver.findElement(By.cssSelector("button[type='submit']")).click();
	  
	  
	  Thread.sleep(5000);
  }
  @BeforeMethod
  public void beforeMethod() {
//	  System.out.println("This is before method");
		
	  driver.get("https://demo.opencart.com/en-gb?route=account/login");	
  }

  @AfterMethod
  public void afterMethod() throws InterruptedException {
	  System.out.println("This is after method");
	  
//	  Thread.sleep(5000);
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;
	  js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	  
//	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
	  driver.quit();
	  
  }


  @DataProvider
  public Object[][] dp() {
	  
//	   System.out.println("This is dataprovider method");
    return new Object[][] {
      new Object[] { "Srikarkotha260@gmail.com", "Srikar@123" },
      
    };
    
  }
  @BeforeClass
  public void beforeClass() {
	  
	  System.out.println("This is before class");
	  
	  //initialize the web driver
	  WebDriverManager.edgedriver().setup();
		
		driver = new EdgeDriver();
		
		driver.manage().window().maximize();
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  
	  System.out.println("This is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  
	  System.out.println("This is before suite");

  }

  @AfterSuite
  public void afterSuite() {
	  
	  System.out.println("This is after Suite");
  }

}
