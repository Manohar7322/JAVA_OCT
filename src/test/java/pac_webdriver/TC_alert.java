package pac_webdriver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_alert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1202, 672));
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElement(By.id("login1")).sendKeys("username123");
		
		driver.findElement(By.name("proceed")).click();
		Alert showalert = driver.switchTo().alert();
		System.out.println("The warning :"+showalert.getText());
		showalert.accept();
		
		//Simple Alert Message
		driver.navigate().to("https://letcode.in/alert");
		
		driver.findElement(By.id("accept")).click();
		Alert simp=driver.switchTo().alert();
		simp.accept();
		
		//confirm alert
		driver.findElement(By.id("confirm")).click();
		Alert conf=driver.switchTo().alert();
		conf.accept();
		
		//prompt alert
		driver.findElement(By.id("prompt")).click();
		Alert prom=driver.switchTo().alert();
		prom.sendKeys("My name is srikar!!");
		prom.accept();
		
		

		
		
		
		

	}

}
