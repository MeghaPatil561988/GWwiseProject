package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Utility;
import Resources.base;
import pageObjects.RegistrationPage;

public class SignPageTC extends base{
public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 System.out.println("driver is initialized");
		 driver.get(prop.getProperty("url"));
		 System.out.println("navigated to home page");
	}
	@Test(priority=0)
	public void SignIn() throws IOException 
	{
		RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		utility.wait(3);
		 Actions a = new Actions(driver);
		
		r.SignIn();
		System.out.println("navigated to signin page");
		
		 String excelFilePath = "C:\\Users\\User\\Documents\\TRON Infotech\\RegPageexcel.xlsx";
         FileInputStream inputstream=new FileInputStream(excelFilePath);
         XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
         XSSFSheet sheet=workbook.getSheetAt(0); 
         
        
         r.Dropdownarrow();
    		
		 a.moveToElement(r.Dropdownoption()).build().perform();
		 
		 r.SelectCountry().click();
		 a.moveToElement(r.DropDowncursor()).build().perform();
		 double mobno1 = sheet.getRow(1).getCell(3).getNumericCellValue();
	     r.MobNo(String.valueOf(mobno1));
	   
	  
	   
	   String acterrmsg3= r.MobNoErrorMessage().getText();
	   String expterrmsg3 ="The phone field is required.";
	   Assert.assertFalse(acterrmsg3.contains(expterrmsg3));
	   
	   driver.findElement(By.xpath("//button[@id='createRegistrationBtn']")).click();
	}
    @AfterTest
    public void teardown() {
    	driver.close();
    }

}
