package pac_webdriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LAB6_XML {

	public static void main(String[] args) throws InterruptedException, IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		
		String projectpath = System.getProperty("user.dir");
		System.out.println("project path: "+projectpath);
		
		File xmlfile=new File(projectpath+"\\lab6_xml");
		
		DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
		DocumentBuilder DBBuilder=DBFactory.newDocumentBuilder();
		Document DBDoc=(Document)DBBuilder.parse(xmlfile);
		
		NodeList NL=((Node) DBDoc).getChildNodes();
		Node n= NL.item(0);
		Element ele = (Element)n;
		
		String snapdeal_url=ele.getElementsByTagName("url").item(0).getTextContent();
		String sear=ele.getElementsByTagName("search").item(0).getTextContent();
		
		
		
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
