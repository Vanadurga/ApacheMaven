package chapter_16_poi_basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.io.File;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DWS_Login_Page {
	
	
	public class Login
	{
		@DataProvider(name="Login data")
		public Object[][] testdata() throws EncryptedDocumentException, IOException
		{
			String path="./Test_Data/Login Data.xlsx";
			
			FileInputStream fis=new FileInputStream(new File(path));
			
			Workbook workbook=WorkbookFactory.create(fis);
			
			Sheet sheet=workbook.getSheet("Sheet1");
			
			int rows=sheet.getPhysicalNumberOfRows();
			
			int col=sheet.getRow(0).getPhysicalNumberOfCells();
			
			Object[][] data=new Object[rows-1][col];
			
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<=col-1;j++)
				{
					data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				}
					
			}
			return data;
			
			
		}
		@Test(dataProvider="Login data")
		public void login(String username,String Password)
		
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("https://demowebshop.tricentis.com");
			
			driver.findElement(By.linkText("Log in")).click();
			
			driver.findElement(By.id("Email")).sendKeys(username);
			
			driver.findElement(By.id("Password")).sendKeys(Password);
			
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
			driver.quit();
			
			
		}
		@Test(dataProvider="Login data")
		public void login1(String username,String Password)
		{
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("https://demowebshop.tricentis.com");
			
			driver.findElement(By.linkText("Log in")).click();
			
			driver.findElement(By.id("Email")).sendKeys(username);
			
			driver.findElement(By.id("Password")).sendKeys(Password);
			
			driver.findElement(By.xpath("//input[@value='Log in']")).click();
			
			driver.quit();
			
		}
	}
	

}
