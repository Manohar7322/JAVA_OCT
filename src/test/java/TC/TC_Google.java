package TC;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Google {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://google.com/");
		System.out.println("Title of the page is:"+driver.getTitle());
		
		WebElement ele =driver.findElement(By.name("q"));
		ele.sendKeys("Testing Method");
		
		ele.submit();
		Thread.sleep(3000);
		System.out.println("title of the page is:"+driver.getTitle());
		
		driver.navigate().to("https://www.yahoo.com/");
		System.out.println("Title of the page is:"+driver.getTitle());
		
		driver.navigate().back();
		System.out.println("Title of the page is:"+driver.getTitle());
		
		driver.navigate().forward();
		System.out.println("Title of the page is:"+driver.getTitle());
		
		System.out.println("URL is:"+driver.getCurrentUrl());
		
		System.out.println("page source"+driver.getPageSource());
		System.out.println("page source is:"+driver.getPageSource().contains("yahoo"));
		/*
		driver.findElement(By.name("q")).sendKeys("testing method");
		driver.findElement(By.name("btnk")).click();
*/
	}

}
