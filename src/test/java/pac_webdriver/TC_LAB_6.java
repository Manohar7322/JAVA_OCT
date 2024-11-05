package pac_webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_LAB_6 {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark= new ExtentSparkReporter("replab6.html");
		extent.attachReporter(spark);
		ExtentTest test=extent.createTest("Verify the snapdeal web");
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("project path: "+projectpath);
		Properties pro =new Properties();
		InputStream input = new FileInputStream(projectpath+"\\lab6_properties");
		pro.load(input);
		String snapdeal_url=pro.getProperty("url");
		String sear=pro.getProperty("search");
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1202, 672));
		
		driver.get(snapdeal_url);
		
		if(driver.getTitle().equals("Shop Online for Men, Women & Kids Clothing, Shoes, Home Decor Items"))
		{
			test.pass("Title is matched");
			File ssfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ssfile, new File("f1.jpg"));
			test.pass("Title is matched"+test.addScreenCaptureFromPath(projectpath+"\\f1.jpg"));
			
		}
		else
		{
			test.fail("Title is not matched");
		}

		LAB6_pom obj =PageFactory.initElements(driver,LAB6_pom.class);
		
		Thread.sleep(5000);
		
		obj.mens();
		obj.sort();
		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[9]/div[2]/div/div[3]/div[2]/ul/li[2]")).click();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"680540434263\"]")).click();
		
		//window switch
		obj.switch_window(1);
        
		System.out.println("The item details is :"+driver.findElement(By.linkText("Item Details")).isDisplayed());
		
		obj.add_cart();
		
		System.out.println("The product is added :"+driver.findElement(By.className("mess-text")).isDisplayed());

		//Searching
		obj.search(sear);
		
		obj.sort();

		driver.findElement(By.xpath("//*[@id=\"content_wrapper\"]/div[7]/div[5]/div[3]/div[1]/div/div[2]/ul/li[3]")).click();
		
		driver.findElement(By.id("621740455267")).click();

		obj.switch_window(2);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[11]/section[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/span[1]")).click();
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[4]/div[2]/div[1]/div[3]/div[1]/div[1]/i[1]")).click();
		
		System.out.println("finish");
		
		extent.flush();


	}

}
