package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Locations {
WebDriver driver;
  

	@FindBy(xpath = "//div[@class='web-menu']//a[@data-bs-toggle='modal'][normalize-space()='Locations']")
	private WebElement Location;
	
	@FindBy(xpath = "(//div[@class='modal-body']//input)[2]")
	private WebElement DeviceLocation;
	
	@FindBy(xpath = "//div[@class='modal-footer']//button[1]")
	private WebElement submitbutton;
	
	@FindBy(xpath = "(//div[@class='modal-body']//input)[3]")
	private WebElement ManualLocation;
	
	@FindBy(xpath = "//div[@class='input-group']//input[1]")
	private WebElement SearchTextBox;
	
	@FindBy(xpath = "//div[@class='input-group']//span[1]")
	private WebElement SearchButton;
	
	
	public Locations(WebDriver driver) 
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
    }
    
    public WebElement SearchButton(){
    	SearchButton.click();
    	return SearchButton;
    	}
    public WebElement LocationLink(){
    	Location.click();
    	return Location;
    	}
    
	public boolean DeviceLocation() {
		DeviceLocation.click();
    	return true;
	}
	public WebElement Submitbutton(){
		submitbutton.click();
    	return submitbutton;
    	}
	public boolean ManualLocation() {
		ManualLocation.click();
    	return true;
	}
	public WebElement SearchTextBox() {
		return SearchTextBox;
	}
}
