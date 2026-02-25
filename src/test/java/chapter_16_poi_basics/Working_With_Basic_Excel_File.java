package chapter_16_poi_basics;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Working_With_Basic_Excel_File {
	
	@Test
	public void demo() throws EncryptedDocumentException, IOException
	{
		String path="./Test_Data/DWS_Test_Data.xlsx";
		
		FileInputStream file=new FileInputStream(new File(path));
		
		//access the workbook
		
		
		//create workbook where the test data is stored
		Workbook workbook=WorkbookFactory.create(file);
		
		//access the sheet where the data is present for you to work on
		
		Sheet sheet=workbook.getSheet("Sheet1");
		
		//print the values of cells
		
		//String row_value=sheet.getRow(2).getCell(1).toString();
		
		//System.out.println(row_value);
		
		//printing all the excel values at a time
		
		
		int rowcount=sheet.getPhysicalNumberOfRows();
		
		int colcount=sheet.getRow(0).getPhysicalNumberOfCells();
		
		System.out.println(rowcount);
		
		System.out.println(colcount);
		
		//to print all the rows
		
		for(int i=0;i<rowcount-1;i++)
		{
			for(int j=0;j<colcount;j++)
			{
			String cellvalue=sheet.getRow(i).getCell(j).toString();
			System.out.print(cellvalue);
			System.out.print(" ");
			}
			System.out.println();
			
			
		}
		
		
		
		
		
		
		
	}

}
