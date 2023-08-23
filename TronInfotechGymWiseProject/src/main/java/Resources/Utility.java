package Resources;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

public class Utility {
    WebDriver driver;
    WebDriverWait wait;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

   /* public void launchApp(String appUrl) {
        driver.get(appUrl);
    }*/

   /* public void maximizewindow() {
        driver.manage().window().maximize();
    }*/

    //Switch Tab
    public void switchToTab(int tabnumber) {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabnumber));
    }

    //select Dropdown value
    public String dropdownValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
       return select.getFirstSelectedOption().getText();
      
        
       
    }

    //Implicit wait
    public void implicitwait(long waittime) {
        driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.SECONDS);
    }

    //Explicit wait
    public void explicitWaitForelement(String locator, Duration milliseconds) {
        WebDriverWait explicitWait = new WebDriverWait(driver, milliseconds);
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    //Fluent Wait
public void fluentWait()
{
    Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
            .withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(5, TimeUnit.SECONDS)
            .ignoring(NoSuchElementException.class);
    WebElement element = wait.until(new Function<WebDriver, WebElement>(){

        public WebElement apply(WebDriver driver ) {
            return driver.findElement(By.cssSelector("#quantity"));
        }
    });

}

    //Press Enter Key
    public void keyboardEnterKey()
    {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }

    //Get Text
    public String getText(WebElement webElement)
    {
    try {
            return webElement.getText();
         }catch (Exception e)
    {
        e.getStackTrace();
    }
    return null;
    }
    
    
    //Assert the Value
    public void assertEquals(String expectedValue, String actualValue)
    {
        Assert.assertEquals("Required assert failed", "1", actualValue);
    }
    

    //Assert True
    public void assertTrue(int count)
    {
        Assert.assertTrue(count>=1, "count is not correct return true");
    }
    
    public void assertFalse(int count)
    {
    	Assert.assertFalse(count<1, "count is not correct return false");
    }
    
    public void waitforAlret() throws InterruptedException 
	{
		int i=0;
		   while(i++<150)
		   {
		        try
		        {
		            Alert alert = driver.switchTo().alert();
		            String alrt = alert.getText();
		  		  	System.out.print("the text it capture is:" +alrt);
		  		  	alert.accept();
		            break;
		        }
		        catch(NoAlertPresentException e)
		        {
		          Thread.sleep(10000);
		          System.out.println("waiting for pop up to get Displayed");
		          continue;
		        }
		   }
		}

    
public void wait(int timeToWaitInSec) {
	try {
		Thread.sleep(timeToWaitInSec*1000);
	}
	catch(InterruptedException e) {
		e.printStackTrace();
	}
	}
    
    //Close the browser
    public void closebrowser()
    { try
    { }catch (Exception e)
    {
        e.getMessage();
    }finally {
        driver.quit();
    }
    }

    
    public boolean verifyactualandexpected(String ExpTitle) {
		String ActualTitle=driver.switchTo().alert().getText();
		System.out.println("The Actual Title is: "+ActualTitle);
		if(ActualTitle.equals(ExpTitle))
			return true;
		else
			return false;
	}
	
    public boolean verifyTitle(String ExpTitle) {
		String ActualTitle=driver.getTitle();
		System.out.println("The Actual Title is: "+ActualTitle);
		if(ActualTitle.equals(ExpTitle))
			return true;
		else
			return false;
	}

	public boolean assertTrue(WebElement verifyselectedcheckbox)
	{
		System.out.println(verifyselectedcheckbox.isSelected());
		return verifyselectedcheckbox.isSelected();
	}
    
	public boolean assertFalse(WebElement verifyselectedcheckbox)
	{
		System.out.println(verifyselectedcheckbox.isSelected());
		return verifyselectedcheckbox.isSelected();	
		
	}
	
	

	public void scrollAndTakeScreenShot() {
		JavascriptExecutor js =(JavascriptExecutor) driver;
		long bodyHeight=(long) js.executeScript("return document.body.scrollHeight;");
		Dimension initial_size=driver.manage().window().getSize();
		long winHeight=(long) initial_size.getHeight();
		
		if(bodyHeight <= winHeight)
			takeScreenShot();
		else {
			int currentScroll =0;
			js.executeScript("window.scrollTo(0,0)");
			
			do {
				takeScreenShot();
				currentScroll += winHeight;
				js.executeScript("window.scrollTo(0," + currentScroll + ")");
				wait(1);
				}
			while(currentScroll < bodyHeight);
		}
		
		}
	
	
	
	public void takeScreenShot() 
	{
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		
		
		File scrFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "//screenshots//" + screenshotFile));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	

	public void pressEscape(String locatorkey) {
		getElement(locatorkey).sendKeys(Keys.ESCAPE);
		getElement(locatorkey);
		System.out.println("Escape button pressed successfully"); 
	}
	
	public void click(String locatorkey) {
		
		wait(2);
		 getElement(locatorkey).click();
		 getElement(locatorkey);
		 System.out.println("Clicked successfully on: " +locatorkey);
	}

public List<WebElement> getElements(String locatorkey){
	List<WebElement> elementList=null;
	if(locatorkey.startsWith("ID_")) {
		locatorkey= locatorkey.replace("ID_", "");
		elementList=driver.findElements(By.id(locatorkey));
	}
	else if(locatorkey.startsWith("NAME_")) {
		locatorkey= locatorkey.replace("NAME_", "");
		elementList=driver.findElements(By.id(locatorkey));
}
	else if(locatorkey.startsWith("XPATH_")) {
		locatorkey= locatorkey.replace("XPATH_", "");
		elementList=driver.findElements(By.id(locatorkey));
}
	else {
		scrollAndTakeScreenShot();
		//test.log(LogStatus.FAIL, "Locator not correct " +locatorkey);
		Assert.fail("Locator not correct " +locatorkey);
	}
	if(elementList.size() ==0) {
		//test.log(LogStatus.FAIL, "No Element found to match Locator: " +locatorkey);
		Assert.fail("Fail the test - No element Found " +locatorkey);
	}
	return elementList;
		
	
}


public WebElement getElement(String locatorkey) {
	WebElement e =null;
	try {
		if(locatorkey.startsWith("ID_")) {
			locatorkey= locatorkey.replace("ID_", "");
			e=driver.findElement(By.id(locatorkey));
		}
		else if(locatorkey.startsWith("NAME_")) {
			locatorkey= locatorkey.replace("NAME_", "");
			e=driver.findElement(By.name(locatorkey));
	}
		else if(locatorkey.startsWith("XPATH_")) {
			locatorkey= locatorkey.replace("XPATH_", "");
			e=driver.findElement(By.xpath(locatorkey));
			
	}
		else {
			scrollAndTakeScreenShot();
			//test.log(LogStatus.FAIL, "Locator not correct " +locatorkey);
			Assert.fail("Locator not correct " +locatorkey);
		}
			
}
	catch(Exception ex) {
		scrollAndTakeScreenShot();
		//test.log(LogStatus.FAIL, ex.getMessage());
		ex.printStackTrace();
		Assert.fail("Failed the test -" +ex.getMessage());
	}
	return e;
		
	}
    

public void isVisible(WebElement element){
	 try {
			wait = new WebDriverWait(driver, 10);
			 wait.until(ExpectedConditions.visibilityOf(element)); 
	} catch (Exception e) {
		System.out.println("Element is not visbile");
	}
	
}

	public void clickOnElements(WebElement ... element){
		
		for(int i=1;i<element.length;i++){
			try {
				if(element[i].isDisplayed()){
					element[i].click();
				}
			} catch (Exception e) {
				System.out.println("Element does not displayed");
			}	
		}
		}
	
	
public void isDisplayed(WebElement element){
		isVisible(element);
		boolean isDisplayed;
		isDisplayed=element.isDisplayed();
			try{
				Assert.assertEquals(isDisplayed, true);
			} catch (Exception e) {
				System.out.println("Actual and Expected are not matchinge");
			}
		
		}


	
public boolean verifyActualandExpected(WebElement element)
{
	boolean actlstatus=false;
	try
	{
		actlstatus=element.isDisplayed();
		Assert.assertEquals(actlstatus, true);
	}
	catch(Exception e)
	{
		return false;
	}
	return actlstatus;
}


	
	public void alertHandle()
	{
		
		Alert alt=driver.switchTo().alert();
		alt.accept();
		
   }
	
	
		/*public void closeDriver(){
			driver.close();
		}*/
		
		
		
		public void selecteDropDown(WebElement ele,String option) throws Exception
		{
			
			Select sclt=new Select(ele);
			sclt.selectByVisibleText(option);
			Thread.sleep(5000);
			
		}
		
		
	public void mouseHoverAndClick(WebElement ele) throws Exception
	{
		    Actions act=new Actions(driver);
			act.moveToElement(ele).build().perform();
			Thread.sleep(2000);
			act.moveToElement(ele).click().perform();
	}
		


	
	public boolean click(String clickLocatorKey, String expObj, String screenName, double startTime, boolean reload, boolean timed) {
		click(clickLocatorKey);
		return true;
	}
	
	public boolean click(String clickLocatorKey, String screenName, double startTime, boolean reload, boolean timed) {
		click(clickLocatorKey);
		return true;
	}
	
	public boolean click(String clickLocatorKey,String expObj,String screenName,boolean reload, boolean timed) {
		click(clickLocatorKey);
		return true;
	}
	
	public boolean click(String clickLocatorKey,boolean reload)
	{
		click(clickLocatorKey);
		return (reload);
	}
	
	/*public void type(String locatorkey,String data) {
	
		getElement(locatorkey).sendKeys(data);
		getElement(locatorkey);
		System.out.println("Typed successfully on: " +locatorkey);
		
	}*/
	public void cleartext(String locatorkey) {
		getElement(locatorkey).clear();
		System.out.println("Text CLeared successfully in: " +locatorkey);
	}

	public void typeEnter(String locatorkey) {
		getElement(locatorkey);
		System.out.println("Enter button pressed successfully");
			
		}
	
	public void setListBox(String locatorkey) {
		System.out.println("Trying to click on List Box");
		try {
		Actions action= new Actions(driver);
		action.moveToElement(getElement(locatorkey)).click().build().perform();
		System.out.println("clicked on dropdown");
		}
		catch(Exception ex) {
			//test.log(LogStatus.FAIL, ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test -" +ex.getMessage());
		}
	}	
	public void autoSujestivenDropDown(String locatorkey,String option)
	{
		
		System.out.println("Trying to click on List Box");
		try {
		Actions action= new Actions(driver);
		action.moveToElement(getElement(locatorkey)).click().build().perform();
		System.out.println("clicked on dropdown");
		List<WebElement>list=null;
		for(WebElement options : list) 
		{
			if(options.getText().equalsIgnoreCase("option"))
			{
				options.click();
				break;
			}
		}
		}
		catch(Exception ex) {
			//test.log(LogStatus.FAIL, ex.getMessage());
			ex.printStackTrace();
			Assert.fail("Failed the test -" +ex.getMessage());
		}
	}	
		
	
	public String metdKeyDown(WebElement ele,String value) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).click();
		a.keyDown(Keys.SHIFT);
		a.sendKeys(value).keyUp(Keys.SHIFT).build().perform();
		wait(3);
		
		return value;
	}
	public String keyDown(WebElement ele,String value) {
		 ele.sendKeys(value);
		 ele.sendKeys(Keys.DOWN);
		 ele.sendKeys(Keys.DOWN);
		 ele.sendKeys(Keys.DOWN);
		 System.out.println(" down button pressed successfully"); 
    	 return ele.getAttribute("value");
		
		
	}
	
	
	
		
		
         
	}

	
	
	
	

