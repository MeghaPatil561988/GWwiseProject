package TestCases;



import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Resources.Utility;
import Resources.base;
import pageObjects.RegistrationPage;


	public class RegistrationPageTC extends base{
		
		public WebDriver driver;
		base b=new base();
		
		@BeforeTest
		public void initialize() throws IOException {

			 driver=initializedriver();
			  // it takes only one set of data
			 driver.get(prop.getProperty("url")); //for only one set of data 
			 System.out.println("navigated to register page");		 
		}
		
		@Test(priority=0)
		public void registarionPage() throws IOException, InterruptedException
		{
			 
			// driver.get(prop.getProperty("url")); //so better we have to write here
			//driver.get(prop.getProperty("url")); 
			RegistrationPage r = new RegistrationPage(driver);
			Utility utility = new Utility(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			 Actions a = new Actions(driver);
			 JavascriptExecutor js = (JavascriptExecutor)driver;
			 
		
			 String excelFilePath = "C:\\Users\\User\\Documents\\TRON Infotech\\RegPageexcel.xlsx";
	         FileInputStream inputstream=new FileInputStream(excelFilePath);
	         XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
	         XSSFSheet sheet=workbook.getSheetAt(0); 
	         
		      String fname = sheet.getRow(1).getCell(0).getStringCellValue();
		       r.PartnerManagerFirstName(fname);
		       String acterrmsg=r.FirstNameErrorMessage().getText();
		       String expterrmsg ="First name is required.";
		       Assert.assertFalse(acterrmsg.contains(expterrmsg));
		       
		       String lname = sheet.getRow(1).getCell(1).getStringCellValue();
		       r.PartnerManagerLastName(lname);		      
		       
		       String email = sheet.getRow(1).getCell(2).getStringCellValue();
		       r.Email(email);
		       String acterrmsg2= r.EmailErrorMessage().getText();
		       String expterrmsg2 ="Please provide your email address for better communication. Thank you.";
		       Assert.assertFalse(acterrmsg2.contains(expterrmsg2));
		     
		       Thread.sleep(2000L);
		    
		  
		   
		         r.Dropdownarrow();
	    		
				 a.moveToElement(r.Dropdownoption()).build().perform();
				 
				 r.SelectCountry().click();
				 a.moveToElement(r.DropDowncursor()).build().perform();
				 double mobno1 = sheet.getRow(1).getCell(3).getNumericCellValue();
			     r.MobNo(String.valueOf(mobno1));
			   
			  
			   
			   String acterrmsg3= r.MobNoErrorMessage().getText();
			   String expterrmsg3 ="The phone field is required.";
			   Assert.assertFalse(acterrmsg3.contains(expterrmsg3));
		     
		  
		      
		      String centrename = sheet.getRow(1).getCell(4).getStringCellValue();
		       r.CenterName(centrename);
		       String acterrmsg4= r.CenterNameErrorMessage().getText();
		       String expterrmsg4 ="The gym name field is required.";
		       Assert.assertFalse(acterrmsg4.contains(expterrmsg4));
		       
		       
				//put it in chrome chropath console and check
			   js.executeScript("window.scrollBy(0,200)");
		       
		       String address = sheet.getRow(1).getCell(5).getStringCellValue();
		       r.Address(String.valueOf(address));
		       driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
		       System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
		       Thread.sleep(2000);
		       driver.findElement(By.cssSelector(".dismissButton")).click();
				//driver.findElement(By.id("autocomplete")).click();
				
				String acterrmsg5= r.AddressErrorMessage().getText();
		        String expterrmsg5 ="Please select the address from the list.";
		        Assert.assertFalse(acterrmsg5.contains(expterrmsg5));
				
		  
		       
		       double latitude = sheet.getRow(1).getCell(6).getNumericCellValue();
		       r.Latitude(String.valueOf(latitude));
		       
		       double longitude = sheet.getRow(1).getCell(7).getNumericCellValue();
		       r.Longitude(String.valueOf(longitude));
		      
		       String city = sheet.getRow(1).getCell(8).getStringCellValue();
		       r.Locality(city);
		       
		       String acterrmsg6= r.CityErrorMessage().getText();
		       String expterrmsg6 ="City is required.";
		       Assert.assertFalse(acterrmsg6.contains(expterrmsg6));
		       
		       double zipcode = sheet.getRow(1).getCell(9).getNumericCellValue();
		       r.ZipCode(String.valueOf(zipcode));
		      
		       
		      int totalnumberrows = sheet.getLastRowNum(); 
		       for(int i=0;i<=totalnumberrows;i++) 
		       {
		    	  XSSFCell result = sheet.getRow(i).getCell(0);
		    	  System.out.println(result);
		       }
		       
			//File upload
		       
			/*	//put it in chrome chropath console and check
			   js.executeScript("window.scrollBy(0,900)");
			   Thread.sleep(2000);
			   a.moveToElement(driver.findElement(By.xpath("(//input[@type='file']) [1]"))).click();           //Upload button
		     
		      Runtime.getRuntime().exec("C:\\Users\\User\\Documents\\TRON Infotech\\FileUpload.exe");
		       System.out.println("File Uploaded Successfully"); 
	         
	         */
	         
		      
				//put it in chrome chropath console and check
			   js.executeScript("window.scrollBy(0,400)");
		       String facility = sheet.getRow(1).getCell(10).getStringCellValue();
		       r.Facility(String.valueOf(facility));
		       r.Facility1().sendKeys(Keys.DOWN);
		      // driver.findElement(By.xpath("//li[@title='Private Showers']")).click();

 		  
		      
		       Thread.sleep(2000);
		     //select[@name='category']
		       WebElement saticdropdown = driver.findElement(By.xpath("//select[@name='category']"));
				Select option = new Select(saticdropdown);
				
				option.selectByIndex(3);
				Thread.sleep(3000);
				option.getFirstSelectedOption().getText();
				 System.out.println(option.getFirstSelectedOption().getText());
				 
				 
				  double rate1hour = sheet.getRow(1).getCell(11).getNumericCellValue();
			      r.Rate1Hour(String.valueOf(rate1hour));
			  
			      Thread.sleep(2000);
			     
			      r.Addbuton();
			      Thread.sleep(2000);
			      r.Removebuton();
			      
			      js.executeScript("window.scrollBy(0,500)");
			      Thread.sleep(2000);
			      r.DaysRadiobutton();
			      //Assert.assertFalse(r.DaysRadiobutton());//this takes the single condition
			      
			     
			      
			       // utility.wait();
			        
			       
			        //WebElement openingtime = r.OpeningTimeDpoption();
			        WebElement openingtime = driver.findElement(By.xpath("//div[@class='form-group row']//select"));
			        a.moveToElement(openingtime).click().perform();
				    Select opentime = new Select(openingtime);
				    
					opentime.selectByIndex(4);
					opentime.getFirstSelectedOption().getText();
					System.out.println(opentime.getFirstSelectedOption().getText());
			      
			      
			      
			    /*  Actions act = new Actions(driver);
			      WebElement list =  driver.findElement(By.xpath("//label[@class='label col-md-5']/following-sibling::select"));
					Thread.sleep(2000L);
					act.moveToElement((WebElement) list).build().perform();
					
					/*Thread.sleep(2000L);
					for(WebElement option1 : list) 
					{
						if(option1.getText().equalsIgnoreCase(""))
						{
							option1.click();
							break;
						}
					}
			      */
			      

				/*	 WebElement closingtime = r.ClosingTimeDpoption();
						Select closetime = new Select(closingtime);
						
						closetime.selectByIndex(3);
						Thread.sleep(3000);
						closetime.getFirstSelectedOption().getText();
						 System.out.println(closetime.getFirstSelectedOption().getText());
						 
						 String acterrmsg1;  
						 String expterrmsg1 = "Please select timing for each day.";
						 
						 acterrmsg1 = r.ErrorMessageTiming().getText();
							System.out.println(acterrmsg);
							try {
								Assert.assertEquals(acterrmsg1, expterrmsg1);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							//Assert.assertTrue(acterrmsg.contains(expterrmsg));//this takes the single condition
							finally
							{
								System.out.println("Test Passed");
							}
						*/ 
						   Actions actions = new Actions(driver);
                           
						   for(int i=1;i<5;i++)
							{
							   actions.moveToElement(r.MaxSlotPerDayplus()).click().perform();
								//r.MaxSlotPerDayplus().click();// 4 times
							}
			      
			      WebElement element = driver.findElement(By.xpath("//tbody/tr[2]/td[2]/div[1]/div[3]/div[2]/div[1]/input[3]"));
			      
			      JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			      jsExecutor.executeScript("arguments[0].click();", element);
						 for(int i=2;i>5;i--)
							{
								r.MaxSlotPerDayminus().click();// 4 times
							}
						 r.PublicHolidayLink();
						 
						 r.PublicHolidayclosebtn();
						 
						 Assert.assertTrue(r.YesRadioButton());
						 
						 Assert.assertFalse(r.NoRadioButton());
						 
						 r.SubmitButton(); 
						 
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
		    public void teardown() throws InterruptedException {
			 Thread.sleep(2000);
		    	driver.close();
		    }
	}




