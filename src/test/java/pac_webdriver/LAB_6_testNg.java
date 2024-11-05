package pac_webdriver;

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

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB_6_testNg {
	
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String search) {
	  
	  driver.findElement(By.xpath("//*[@id=\"leftNavMenuRevamp\"]/div[1]/div[2]/ul/li[1]/a/span[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"category1Data\"]/div[1]/div/div/p[2]/a/span")).click();
		
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div/div[3]/div[2]/ul/li[2]")).click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"680540434263\"]/div[1]/a/picture/img")).click();
		

	
		List<String> wh= new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(wh.get(1));
      
		System.out.println("The item details is :"+driver.findElement(By.linkText("Item Details")).isDisplayed());
		driver.findElement(By.id("add-cart-button-id")).click();
		
		System.out.println("The product is added :"+driver.findElement(By.className("mess-text")).isDisplayed());
		
		System.out.println("finish");
		
		WebElement sea=driver.findElement(By.id("inputValEnter"));
		sea.sendKeys(search);
		
		driver.findElement(By.className("searchTextSpan")).click();
		
		driver.findElement(By.className("sort-selected")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[7]/div[5]/div[3]/div[1]/div[1]/div[2]/ul[1]/li[3]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[11]/div[7]/div[5]/div[3]/div[8]/section[1]/div[1]/div[1]/a[1]/picture[1]/img[1]")).click();

		List<String> wh1=new ArrayList(driver.getWindowHandles());
		driver.switchTo().window(wh1.get(2));
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[11]/section[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[4]/div[2]/div[1]/div[3]/div[1]/div[1]/i[1]")).click();
		
  }
  @BeforeMethod
  public void beforeMethod() throws InterruptedException {
	  
	 

//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Thread.sleep(5000);
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"mobile cover"},
//      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  
	  WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1202, 672));
		 driver.get("https://www.snapdeal.com/");
		 
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
