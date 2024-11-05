package pac_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Select {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1202, 672));
		
		driver.get("https://demo.opencart.com/");
		
		Thread.sleep(5000);
		
		driver.findElement(By.linkText("Desktops")).click();
		
		driver.findElement(By.linkText("Mac (1)")).click();
		
		Select sort = new Select(driver.findElement(By.id("input-sort")));
		
		Thread.sleep(5000);
		
		sort.selectByIndex(5);

	}

}
