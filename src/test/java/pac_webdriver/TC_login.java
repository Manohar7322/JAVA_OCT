package pac_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_login {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://demo.opencart.com/en-gb?route=account/login");
		
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		

		login_pom obj=new login_pom(driver);
		
		obj.enterusername("Srikarkotha260@gmail.com");
		obj.enterpassword("Srikar@123");
		
		Thread.sleep(2000);
		obj.login();
	}

}
