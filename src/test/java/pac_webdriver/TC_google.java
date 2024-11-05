package pac_webdriver;

import java.time.Duration;
import java.util.NoSuchElementException;

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

public class TC_google {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("alert('search testing methods');");
		
		Thread.sleep(5000);
				
		System.out.println("Title of the page is : "+driver.getTitle());
		//System.out.println("URL is :"+driver.getPageSource());
		System.out.println("URL is :"+driver.getPageSource().contains("yahoo"));


		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
		
		
		Wait wait1=new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		ele.sendKeys("Testing methods");
		ele.submit();
		
		System.out.println("Title of the page is : "+driver.getTitle());
		
		driver.navigate().to("https://www.yahoo.com/");
		System.out.println("URL is :"+driver.getPageSource().contains("yahoo"));

		System.out.println("Title of the page is : "+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Title of the page is : "+driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("Title of the page is : "+driver.getTitle());
		


		

		
		//driver.close();
		
	}

}
