package pac_webdriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_login_pagefactory_extentreports {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {

		
//		"""EXTENT REPORTS"""
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("r1.html");
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("verify the Title");
		
//		"""USING PROPERTIES FILE"""

//		Properties pro=new Properties();
//		InputStream input= new FileInputStream("C:\\Users\\srikar.kotha\\eclipse-workspace\\oct2024\\login_properties");
//		pro.load(input);
//		String opencart_url=pro.getProperty("url");
//		String uname=pro.getProperty("username");
//		String pword=pro.getProperty("password");
		
//		"""USING XML FILE"""
		
//		String projectpath=System.getProperty("user.dir");
//		File xmlfile=new File(projectpath+"\\login.xml");
//		
//		DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
//		DocumentBuilder DBBuilder=DBFactory.newDocumentBuilder();
//		Document DBDoc=(Document)DBBuilder.parse(xmlfile);
//		
//		NodeList NL=((Node) DBDoc).getChildNodes();
//		Node n= NL.item(0);
//		Element ele = (Element)n;
//		
//		String opencart_url=ele.getElementsByTagName("url").item(0).getTextContent();
//		String uname=ele.getElementsByTagName("username").item(0).getTextContent();
//		String pword=ele.getElementsByTagName("password").item(0).getTextContent();
		
// 		"""USING XL SHEET"""
		
		FileInputStream input = new FileInputStream("C:\\Users\\srikar.kotha\\eclipse-workspace\\oct2024\\login.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet("login");
		
		int noofrows=sheet.getPhysicalNumberOfRows();
		System.out.println("rows : "+noofrows);
		
		
		
		for(int i=0;i<noofrows;i++)
		{
			String opencart_url=sheet.getRow(i).getCell(0).getStringCellValue();
			String uname=sheet.getRow(i).getCell(1).getStringCellValue();
			String pword=sheet.getRow(i).getCell(2).getStringCellValue();
		
		WebDriverManager.edgedriver().setup();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get(opencart_url);
		
		if(driver.getTitle().equals("Account Login"))
		{
			test.pass("title is matched");
			File ssfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(ssfile,new File("s1.jpg"));	
			
		}
		else
		{
			test.fail("title is not matched");
		}
		
		Thread.sleep(5000);
		
		driver.manage().window().maximize();
		

		TC_pagefactory obj=PageFactory.initElements(driver,TC_pagefactory.class);
		
		obj.enterusername(uname);
		obj.enterpassword(pword);
		
		Thread.sleep(2000);
		obj.login();
		
		driver.quit();
		
		extent.flush();
		
		}
	}

}
