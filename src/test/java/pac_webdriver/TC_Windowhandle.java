package pac_webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Windowhandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1202, 672));
		driver.get("https://letcode.in/windows");
		
		System.out.println("Windowhandle :"+driver.getWindowHandle());
		
		driver.findElement(By.id("multi")).click();
		
		List<String> wh=new ArrayList<String>(driver.getWindowHandles());
		
		for(String i:wh) {
			System.out.println("Multiple window handles :"+i);
		}
		
		driver.switchTo().window(wh.get(1));
		System.out.println("The url is :"+driver.getCurrentUrl());

	}

}
