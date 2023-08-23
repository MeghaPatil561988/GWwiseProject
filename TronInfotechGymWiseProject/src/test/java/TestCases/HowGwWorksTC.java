package TestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.Utility;
import Resources.base;
import pageObjects.HowGwWorks;
import pageObjects.RegistrationPage;

public class HowGwWorksTC extends base{
public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {

		 driver=initializedriver();
		 System.out.println("driver is initialized");
		 driver.get(prop.getProperty("url"));
		 System.out.println("navigated to home page");
	}
    @Test
	public void baseTestNavigation() throws IOException, InterruptedException
    {
		 
    	HowGwWorks h = new HowGwWorks (driver);
    	RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions a = new Actions(driver);
		utility.wait(3);
		h.HowGwWorkLink();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1400)");
		
		utility.wait(3);
		
		a.moveToElement(h.SubscribeLink()).build().perform();
		
		
		String s = "patilmegha.m5@gmail.com";
		a.moveToElement(h.EmailAddress()).build().perform();
		
		h.EmailAddress().sendKeys(s);
		Thread.sleep(2000);
		h.SubmitButton();
		
		
		
		
	}
    
    @Test(enabled=false)   
	public void BrokenLinks() throws MalformedURLException, IOException, InterruptedException {
		RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		utility.wait(3);
		System.out.println("navigated to practice page");
		System.out.println(r.NumofLinks().size());	
		
		SoftAssert a =new SoftAssert();
		List<WebElement> links = r.allbrokenLinks();
        for(WebElement link : links)
        {
        	
        	String url= link.getAttribute("href");
        	if(url!= null) {
            HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();

            conn.setRequestMethod("HEAD");
            Thread.sleep(2000);

            conn.connect();
           

            int respCode = conn.getResponseCode();

            System.out.println(respCode);
            
            Thread.sleep(2000);

            a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
        	}
            }
            Thread.sleep(2000);
            a.assertAll();
	}

	@Test(enabled=false)
	public void ClickOnEachLink() throws InterruptedException {
		RegistrationPage r = new RegistrationPage(driver);
		Utility utility = new Utility(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		utility.wait(3);
		System.out.println("navigated to Registration page");
		System.out.println(r.NumofLinks().size());	
		WebElement footerlinks = driver.findElement(By.xpath("//div[@class='footer-text']//a"));
		System.out.println(footerlinks.findElements(By.xpath("//div[@class='footer-text']//a")).size());
		//By.tagName("a")
		for(int i=1;i<footerlinks.findElements(By.xpath("//div[@class='footer-text']//a")).size();i++)
		{
			String clickcoleachlink = Keys.chord(Keys.CONTROL,Keys.ENTER);	
			footerlinks.findElements(By.xpath("//div[@class='footer-text']//a")).get(i).sendKeys(clickcoleachlink);
			Thread.sleep(2000L);
		}
		Set<String> eachtab = driver.getWindowHandles();
		Iterator<String> it = eachtab.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
	}
	
    
    @AfterTest
    public void teardown() {
    	driver.close();
    }

}
