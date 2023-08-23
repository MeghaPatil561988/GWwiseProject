package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Utility;
import Resources.base;
import pageObjects.Locations;
import pageObjects.RegistrationPage;

public class LocationsTC extends base{
	public WebDriver driver;
	base b=new base();
	
	
	
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		  // it takes only one set of data
		 driver.get(prop.getProperty("url")); //for only one set of data 
		 System.out.println("navigated to register page");
		

}
	@Test(enabled=false)
	public void locations() throws IOException, InterruptedException
	{
		 
		// driver.get(prop.getProperty("url")); //so better we have to write here
		//driver.get(prop.getProperty("url")); 
		Locations l = new Locations(driver);
		RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Actions a = new Actions(driver);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 l.LocationLink();
		 //l.DeviceLocation();
		 Thread.sleep(2000);
		 Assert.assertTrue(l.DeviceLocation());
		 l.Submitbutton();
	}	
	@Test(priority=1)
	public void ManualLocation() throws InterruptedException {
		Locations l = new Locations(driver);
		RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 Actions a = new Actions(driver);
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 l.LocationLink();
		 //l.DeviceLocation();
		 Thread.sleep(2000);
		 Assert.assertTrue(l.ManualLocation());
		 l.Submitbutton();
		 String place = "pune";
		 l.SearchTextBox().sendKeys(place);
		 Thread.sleep(2000);
		 l.SearchButton();
	}
	@AfterTest
    public void teardown() throws InterruptedException {
	 Thread.sleep(2000);
    	driver.close();
    }
	
}