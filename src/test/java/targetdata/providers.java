package targetdata;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import targetutilites.utilites;

public class providers {
	public static WebDriver driver;
	@BeforeMethod
	  public void beforeMethod() {
		
	}
	@Test(dataProvider="Authentication")
	public void f(String tcName, String sUserName, String sPassWord){
		System.out.println(tcName);
		System.out.println(sUserName);
		System.out.println(sPassWord);
	}
	@DataProvider
	public static Object[][]Authentication(){
		utilites Exu;
		try {
		
		Exu=new utilites("TestData\\sheet2.xlsx");
		Object[][] testobjArray = Exu.getDataArray("Sheet1");
		return testobjArray;
		
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	return null;
		
	}
	@AfterMethod
	public void aftermethod{
		driver.close();
	}
	
	

}
