package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddContactPage extends BasePage {
	
	WebDriver driver;
	
	public AddContactPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'account']") WebElement fullnameElement;
	@FindBy(how = How.XPATH, using = "//select[@id = 'cid']" ) WebElement companyElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'email']") WebElement emailElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'phone']") WebElement phoneElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'address']") WebElement addressElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'city']") WebElement cityElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'state']") WebElement stateElement;
	@FindBy(how = How.XPATH, using = "//input[@id = 'zip']") WebElement zipElement;
	@FindBy(how = How.XPATH, using = "//select[@id = 'country']") WebElement countryElement;
	
	@FindBy(how = How.XPATH , using = "//button[@id = 'submit']" )WebElement submitElement;
	public void insertName(String name)
	{
		fullnameElement.sendKeys(name + generateRandomNum(999) );
	}
	public void selectCompany(String company)
	{
		selectDropDown(companyElement , company);
	}
	
	public void insertEmail(String email)
	{
		//009sahibasoni@gmail.com
		//sahibasoni@gmail.com009
		emailElement.sendKeys(generateRandomNum(999) + email );
	}
	public void insertPhone(String ph)
	{
		phoneElement.sendKeys(generateRandomNum(999) + ph);
	}
	public void insertAddress(String add)
	{
		addressElement.sendKeys(add);
	}
	public void insertCity(String city)
	{
		addressElement.sendKeys(city);
	}
	public void insertState(String state)
	{
		addressElement.sendKeys(state);
	}
	public void insertZip(String zip)
	{
		addressElement.sendKeys(zip);
	}
	public void selectCountry(String country)
	{
		selectDropDown(countryElement , country);
	}
	public void clickSaveButton()
	{
		submitElement.click();
		
	}
	

}
