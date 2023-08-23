package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
   
	
	//By PartnerManagerFirstName = By.cssSelector("#first_name");
	

	@FindBy(css = "#first_name")
	private WebElement FirstName;
	
	@FindBy(css = "#error-first_name")
	private WebElement FirstNameErrorMessage;
	
	@FindBy(xpath ="//div[@class='web-menu']//a[@data-bs-toggle='modal'][normalize-space()='Locations']")
	private WebElement Locations;
	
	@FindBy(xpath="//input[@id='last_name']")
	private WebElement Lastname;
	
    @FindBy(css="#email")
	private WebElement Email;
    
    @FindBy(xpath ="//p[@id='error-email']")
	private WebElement EmailErrorMessage;
    
    @FindBy(css="#phone1")
	private WebElement MobileNo;
    
    @FindBy(xpath="//p[@id='error-phone']")
   	private WebElement MobNoErrorMessage;
    
    @FindBy(xpath="//div[@class='iti__arrow']")
	private WebElement dropdownarrow;
    
    @FindBy(css="#phone1")
    //li[@id='iti-0__item-in-preferred']//span[@class='iti__country-name'][contains(text(),'India (भारत)')]
   	private WebElement DropDowncursor;
    
    @FindBy(xpath="//ul[@id='iti-0__country-listbox']/li")
    private WebElement dropdownoption;
 
    @FindBy(xpath="//input[@placeholder='Gym Name']")
   	private WebElement CenterName;
    
    @FindBy(xpath="//p[@id='error-gym_name']")
   	private WebElement CenterNameErrorMessage;
 
    @FindBy(xpath="//input[@placeholder='Enter Address']")
   	private WebElement Address;
    
    @FindBy(xpath="//p[@id='error-gym_name']")
   	private WebElement AddressErrorMessage;
    
    @FindBy(xpath="//input[@name='lat']")
   	private WebElement Latitude;
    
    @FindBy(xpath="//input[@name='lng']")
   	private WebElement Longitude;
    
    @FindBy(css="#locality")
   	private WebElement Locality;
    
    @FindBy(xpath="//p[@id='error-city']")
   	private WebElement CityErrorMessage;
    
    @FindBy(css=" #postal_code")
   	private WebElement ZipCode;
    
    @FindBy(xpath="//li[@id='iti-0__item-in-preferred']//span[@class='iti__country-name'][contains(text(),'India (भारत)')]")
    private WebElement selectcountry;
   
    @FindBy(xpath="//span[@class='select2-selection select2-selection--multiple']")
   	private WebElement Facility;
    
    @FindBy(xpath="//input[@name='one_hour_rate']")
   	private WebElement Rate1hour;
    
    @FindBy(xpath="//input[@name='two_hour_rate']")
   	private WebElement Rate2hour;
    
    @FindBy(xpath="//input[@name='three_hour_rate']")
   	private WebElement Rate3hour;
    
    @FindBy(xpath="//button[normalize-space()='Add']")
    private WebElement AddButton;
    
    @FindBy(xpath="//tbody/tr[3]/td[5]/button[1]")
    private WebElement RemoveButton;
    
    @FindBy(xpath="(//input[@name='days']/following-sibling::span)[2]")
    private WebElement DaysRadiobutton;
    
    @FindBy(xpath="//div[@class='form-group row']//select")
    private WebElement OpeningTime;
    
    @FindBy(xpath="(//div[@class='form-group row']//select)[2]")
    private WebElement ClosingTime;
    
    @FindBy(xpath="(//div[@class='input-group']//input)[3]")
    private WebElement MaxSlotPerDayplus;
    
    @FindBy(xpath="//div[@class='input-group']//input")
    private WebElement MaxSlotPerDayminus;
    
    @FindBy(xpath="//a[normalize-space()='Please select timing for each day.']")
    private WebElement ErrorMessageTiming;
    
    @FindBy(xpath="//a[normalize-space()='View public holidays']")
    private WebElement PublicHolidayLink;
    
    @FindBy(xpath="//body/div[@id='mm-0']/div[2]/div[2]/div[1]/div[1]/div[1]/button[1]/i[1]")
    private WebElement PublicHolidayclosebtn;
    
    @FindBy(xpath="//label[@for='yes1']")
    private WebElement YesRadioButton;
    
    @FindBy(xpath="//label[@for='no1']")
    private WebElement NoRadioButton;
    
    @FindBy(xpath="//button[normalize-space()='Submit']")
    private WebElement SubmitButton;
    
    @FindBy(tagName="a")
    private List<WebElement> numoflinks;
    
    //div[@class='footer-text']//a
    @FindBy(xpath="// @FindBy(xpath=\"//div[@class='social-profile']/ul/li/a\")")
    private  List<WebElement> brokenlinks;
    
    @FindBy(xpath="//a[@class='btn v1']")
    private WebElement SignIn;
    
    @FindBy(xpath="//section[@class='breadcrumb-wrap bg-f br-bg-4']//h2[1]")
    private String getTitle;
    
    
    public RegistrationPage(WebDriver driver) 
	{
		 this.driver = driver;
		 PageFactory.initElements(driver, this);
    }
    
    public String GetTitle(){
    	return getTitle;}
    
    public List<WebElement> NumofLinks(){
    	
    	 return numoflinks;
		}
    public List<WebElement> allbrokenLinks()
    {
    	return brokenlinks;
    }
    public boolean NoRadioButton(){
    	NoRadioButton.click();
		return false;
		}
    public WebElement FirstNameErrorMessage(){
    	return FirstNameErrorMessage;
		}
    public WebElement SubmitButton(){
    	SubmitButton.click();
		return SubmitButton;}
    
    public boolean YesRadioButton(){
    	YesRadioButton.click();
         return true;
	}
    
    public WebElement SignIn(){
    	SignIn.click();
         return SignIn;
	}
    public WebElement PublicHolidayclosebtn(){
    	PublicHolidayclosebtn.click();
		return PublicHolidayclosebtn;
	}
    
    public WebElement PublicHolidayLink(){
    	PublicHolidayLink.click();
		return PublicHolidayLink;
	}
    
    public WebElement ErrorMessageTiming(){
		return ErrorMessageTiming;
	}
    
    public WebElement MaxSlotPerDayminus(){
		return MaxSlotPerDayminus;
	}
    
    public WebElement MaxSlotPerDayplus(){
		return MaxSlotPerDayplus;
	}
    public WebElement OpeningTimeDpoption(){
    	
    	return ClosingTime;
	}
    public WebElement ClosingTimeDpoption(){
    	
    	return OpeningTime;
    	}
    public boolean DaysRadiobutton()
   	{
    	DaysRadiobutton.click();
		return true;
   	}
    public void Addbuton()
	{AddButton.click();}
    public void Removebuton()
   	{
    	RemoveButton.click();
   	}
    public WebElement ZipCode(String zipcode)
	{ZipCode.sendKeys(String.valueOf(zipcode));
		return ZipCode;
	}
	public void Dropdownarrow()
	{dropdownarrow.click();
	}
	public WebElement Latitude(String latitude)
	{Latitude.sendKeys(String.valueOf(latitude));
		return Latitude;
	}
	public WebElement Locality(String locality)
	{Locality.sendKeys(locality);
		return Locality;
	}
	public WebElement Longitude(String longitude)
	{Longitude.sendKeys(String.valueOf(longitude));
		return Longitude;
	}
	public WebElement Address(String address)
	{Address.sendKeys(address);
		return Address;
	}
	public WebElement PartnerManagerFirstName(String firstname)
	{FirstName.sendKeys(firstname);
		return FirstName;
	}
	public WebElement PartnerManagerLastName(String lastname)
	{Lastname.sendKeys(lastname);
		return Lastname;
	}
	public WebElement Email(String email)
	{Email.sendKeys(email);
		 return Email;}
	public WebElement MobNo(String mobno)
    {MobileNo.sendKeys(String.valueOf(mobno));
		 return MobileNo;
	}
	public WebElement CenterName(String centername)
	{CenterName.sendKeys(centername);
		return CenterName;
	}
	public WebElement Rate1Hour(String rate1hour)
	{Rate1hour.sendKeys(String.valueOf(rate1hour));
		return Rate1hour;
	}
	public WebElement Rate2Hour(String rate2hour)
	{Rate2hour.sendKeys(String.valueOf(rate2hour));
		return Rate2hour;
	}
	public WebElement Rate3Hour(String rate3hour)
	{Rate3hour.sendKeys(String.valueOf(rate3hour));
		return Rate3hour;
	}
    public WebElement Facility(String facility2)
	{Facility.sendKeys(facility2);
       return Facility;
	}
    public WebElement Facility1() {
    	
    	return Facility;
    }
	public WebElement DropDowncursor()
	{  
		return DropDowncursor;
	}
	public WebElement location()
	{return Locations;
	}
	public WebElement Dropdownoption(){
		return dropdownoption;
	}
	public WebElement SelectCountry(){
        return selectcountry;
	}
	public WebElement EmailErrorMessage() {
		return EmailErrorMessage;
	}
	public WebElement MobNoErrorMessage() {
		return MobNoErrorMessage;
	}
	public WebElement CenterNameErrorMessage() {
		return CenterNameErrorMessage;
	}
    public WebElement AddressErrorMessage() {
		return AddressErrorMessage;
	}
   public WebElement CityErrorMessage() {
		return CityErrorMessage;
	}

    public Object getTitle() {
	// TODO Auto-generated method stub
	return null;
}
}