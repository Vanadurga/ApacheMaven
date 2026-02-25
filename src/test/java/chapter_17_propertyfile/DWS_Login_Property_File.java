package chapter_17_propertyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;

public class DWS_Login_Property_File {
	
	WebDriver driver;
	
	@Test
	public void TC1() throws IOException, InterruptedException
	{
		//property file
		FileInputStream fis=new FileInputStream(new File("./Test_Configuration_Files/TestConfiguration.properties"));
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String browsername=prop.getProperty("Browser");
		
		String time=prop.getProperty("timeout");
		
		String url=prop.getProperty("URL");
		
		driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get(url);
			
			
			driver.findElement(By.linkText("Log in")).click();
			
			driver.findElement(By.id("Email")).sendKeys(prop.getProperty("username"));
			
			driver.findElement(By.id("Password")).sendKeys(prop.getProperty("password"));
			
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
			Thread.sleep(3000);
			
			driver.close();
			
			
		
		
		
	}

}
