package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class DashBoardPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH , using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2" )WebElement DashBoardElement;
	@FindBy(how = How.XPATH , using = "//span[text() = 'Customers']" )WebElement customerElement;
	@FindBy(how = How.XPATH , using = "//a[text() = 'Add Customer']" )WebElement addCustomerElement;
	
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void validateDashBoardPage(String actualText)
	{
		Assert.assertEquals(DashBoardElement.getText() , actualText , "Page not found" );
	}
	
	public void clickCustomer()
	{
		customerElement.click();
	}
	
	public void clickAddCustomer()
	{
		addCustomerElement.click();
	}
	
	
	
	

}
