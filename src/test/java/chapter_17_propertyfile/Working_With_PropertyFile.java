package chapter_17_propertyfile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;

import org.testng.annotations.Test;

public class Working_With_PropertyFile {
	
	@Test
	public void demo() throws Exception
	{
		String path="./Test_Configuration_Files/TestConfiguration.properties";
		
		FileInputStream fis=new FileInputStream(new File(path));
		
		//Create an object for properties class
		
		Properties prop=new Properties();
		
		prop.load(fis);
		
		//to retrieve the values from the property file
		
		String fname=prop.getProperty("FirstName");
		
		System.out.println(fname);
		
		String lname=prop.getProperty("LastName");
		
		System.out.println(lname);
		
		String email=prop.getProperty("Email");
		
		System.out.println(email);

}
}
