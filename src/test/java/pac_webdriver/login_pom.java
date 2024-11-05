package pac_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class login_pom {
	
	public login_pom(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	WebDriver driver;
	By username=By.id("input-email");
	By password=By.id("input-password");
	By loginbutton=By.xpath("//button[@type='submit']");
	
	
	
	
	void enterusername(String email) {
		driver.findElement(username).sendKeys(email);;
	}
	
	void enterpassword(String pass) {
		driver.findElement(password).sendKeys(pass);;
	}
	
	void login() {
		driver.findElement(loginbutton).click();;
	}
	

}
