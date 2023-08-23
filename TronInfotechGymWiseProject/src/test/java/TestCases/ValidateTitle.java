package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Utility;
import Resources.base;
import pageObjects.RegistrationPage;


public class ValidateTitle extends base{
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 System.out.println("driver is initialized");
		 driver.get(prop.getProperty("url"));
		 System.out.println("navigated to home page");
	}
    @Test
	public void baseTestNavigation() throws IOException
    {
		 
    	RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		utility.wait(3);
		 
		 //compare the text from the browser with actual text : Error
		
		driver.findElement(By.xpath("//section[@class='breadcrumb-wrap bg-f br-bg-4']//h2[1]"));
		String actualTitle = r.GetTitle();

		// Expected title
		String expectedTitle = "Partner Registration ";

		// Compare actual and expected titles
		if (actualTitle.equals(expectedTitle)) {
		    System.out.println("Title validation successful.");
		} else {
		    System.out.println("Title validation failed. Actual title: " + actualTitle);
		}
		




		
		System.out.println("successfullu validated text message");
    }
    @AfterTest
    public void teardown() {
    	driver.close();
    }
}