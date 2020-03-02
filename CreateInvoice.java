package com.autodesk.crm.OrganizationTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.autodesk.crm.GenericLib.WebDriverUtils;

public class CreateInvoice {
	static {
		System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
		
		
	     }
	
	@Test
	public void data() throws IOException, InterruptedException
	{
		FileInputStream fis=new FileInputStream("./data/commondata.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		String browser = pobj.getProperty("browser");
		String username = pobj.getProperty("username");
		String password = pobj.getProperty("password");
		String url = pobj.getProperty("url");
		System.out.println(browser+ "" +username+ "" +password+ "" +"url");
		WebDriver driver=null;
		if(browser.equals("chrome"))
			
		{
			driver=new ChromeDriver();
		}
		
		else
		{
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		WebElement mov = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		Actions act = new Actions(driver);
		   act.moveToElement(mov).perform();
		   driver.findElement(By.xpath("//a[@name='Invoice']")).click();
		   Thread.sleep(3000);
		   driver.findElement(By.xpath("//img[@title='Last Viewed']")).click();

		   
		   driver.findElement(By.xpath("//a[text()='hplaptop']")).click();
		   driver.findElement(By.xpath("//input[@name='Edit']")).click();
		   
		   driver.findElement(By.name("campaignname")).sendKeys("hplaptop1");
		   driver.findElement(By.xpath("//input[@name='button']")).click();
		   WebElement mov1 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			Actions act1 = new Actions(driver);
			   act1.moveToElement(mov1).perform();
			   driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
		  // WebDriverUtils wdu = new WebDriverUtils();
			//wdu.select(drop, "hplaptop");	
}
}
