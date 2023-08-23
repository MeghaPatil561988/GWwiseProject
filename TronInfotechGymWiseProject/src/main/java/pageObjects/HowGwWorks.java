package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HowGwWorks {
	WebDriver driver;
	
	 @FindBy(xpath="//div[@class='web-menu']//a[normalize-space()='How GW Works']")
	    private WebElement HowGwWorkLink;
	 
	 @FindBy(xpath="//input[@placeholder='email@example.com']")
	    private WebElement EmailAddress;
	
	 @FindBy(css=".btn.v1.sendM")
	    private WebElement SubmitButton;
	
	 
	 @FindBy(css=".btn.subscribe.float")
	    private WebElement SubscribeLink;
	       
	       
	    public HowGwWorks(WebDriver driver) 
		{
			 this.driver = driver;
			 PageFactory.initElements(driver, this);
	    }
	    
	    public WebElement HowGwWorkLink(){
	    	HowGwWorkLink.click();
	    	return HowGwWorkLink;}
	    
	    public WebElement EmailAddress(){
	    	return EmailAddress;}
	     
	    public WebElement SubscribeLink(){
	    	SubscribeLink.click();
	    	return SubscribeLink;}
	    
	    public WebElement SubmitButton(){
	    	SubmitButton.click();
	    	return SubmitButton;}
	    
}
