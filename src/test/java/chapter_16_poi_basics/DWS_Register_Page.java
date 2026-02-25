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

public class DWS_Register_Page {
	
	public class DNS_RegisterTest{
		@DataProvider(name="RegisterTestData")
		public Object[][] getTestData() throws EncryptedDocumentException, IOException
		{
			String path="./Test_Data/DWS_Test_Data.xlsx";
			
			FileInputStream file=new FileInputStream(new File(path));
			
			Workbook workbook=WorkbookFactory.create(file);
			
			Sheet sheet=workbook.getSheet("Sheet1");
			
			int rowcount=sheet.getPhysicalNumberOfRows();
			
			int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
			
			Object[][] data=new Object[rowcount-1][colcount];
			
			for(int i=1;i<rowcount;i++)
			{
				for(int j=0;j<=colcount-1;j++)
				{
					data[i-1][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
			
			return data;
			
		}
		@Test(dataProvider="RegisterTestData")
		public void registerTC(String firstname, String Lastname, String email, String password, String conpassword)
		
		{
			
			WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			
			driver.get("https://demowebshop.tricentis.com/");
			
			driver.findElement(By.linkText("Register")).click();
			
			driver.findElement(By.id("gender-female")).click();
			
			driver.findElement(By.id("FirstName")).sendKeys(firstname);
			
			driver.findElement(By.id("LastName")).sendKeys(Lastname);
			
			driver.findElement(By.id("Email")).sendKeys(email);
			
			driver.findElement(By.id("Password")).sendKeys(password);
			
			driver.findElement(By.id("ConfirmPassword")).sendKeys(conpassword);
			
			driver.findElement(By.id("register-button")).click();
			
			driver.quit();
			
			
			
			
			
			
			
			
			
		}
	}
	

}
