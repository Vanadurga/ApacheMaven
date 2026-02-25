package chapter_17_propertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.Test;
import java.io.File;

public class DWS_Register_Page_Using_Properties {
	
	WebDriver driver;
	
	@Test
	public void RegisterTC() throws InterruptedException, IOException
	{
		FileInputStream fis=new FileInputStream(new File("./Test_Configuration_Files/Register_data.properties"));
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		String browser=prop.getProperty("Browser");
		
		String url=prop.getProperty("URL");
		
		String first=prop.getProperty("FirstName");
		
		String Last=prop.getProperty("LastName");
		
		String email=prop.getProperty("Email");
		
		String pass=prop.getProperty("Password");
		
		String cpass=prop.getProperty("CnnformPassword");
		
		switch(browser)
		{
		case "Chrome":
		{
				driver=new ChromeDriver();
				
				driver.manage().window().maximize();
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				
				driver.get(url);
				
				driver.findElement(By.linkText("Register")).click();
				
				driver.findElement(By.id("gender-female")).click();
				
				driver.findElement(By.id("FirstName")).sendKeys(first);
				
				driver.findElement(By.id("LastName")).sendKeys(Last);
				
				driver.findElement(By.id("Email")).sendKeys(email);
				
				driver.findElement(By.id("Password")).sendKeys(pass);
				
				driver.findElement(By.id("ConfirmPassword")).sendKeys(cpass);
				
				driver.findElement(By.id("register-button")).click();
				
				Thread.sleep(3000);
				
				driver.close();
				
				break;
				
		}
		case "Edge":
			System.out.println("No output");
			break;
			
		
		
	}

}
}
