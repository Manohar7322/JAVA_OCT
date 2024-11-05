package pac_webdriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB6_XLXS {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("project path: "+projectpath);
		
		FileInputStream input = new FileInputStream(projectpath+"\\lab6.xlsx");
//		"C:\Users\srikar.kotha\eclipse-workspace\oct2024\lab6.xlsx"
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet=workbook.getSheet("lab6");
		
		int noofrows = sheet.getPhysicalNumberOfRows();
		
		for(int i=0;i<noofrows;i++)
		{
			String snapdeal_url=sheet.getRow(i).getCell(0).getStringCellValue();
			String sear=sheet.getRow(i).getCell(1).getStringCellValue();
			
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().setSize(new Dimension(1202, 672));
		
		driver.get(snapdeal_url);

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
		}


	}

}
