package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class AddContactTest {
	
	WebDriver driver;
	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String actualText = "Dashboard";
	String name = exlRead.getCellData("AddContactInfo", "FullName", 2) ;
	String email = exlRead.getCellData("AddContactInfo", "Email", 2);
	String ph = exlRead.getCellData("AddContactInfo", "Phone", 2);
	String address = exlRead.getCellData("AddContactInfo", "Address", 2);
	String company = exlRead.getCellData("AddContactInfo", "CompanyName", 2);
	String city = exlRead.getCellData("AddContactInfo", "City", 2);
	String country = exlRead.getCellData("AddContactInfo", "Country", 2);
	String state = exlRead.getCellData("AddContactInfo", "State", 2);
	String zip = exlRead.getCellData("AddContactInfo", "Zip", 2);
	
	
	
	@Test
	public void validUserShouldBeAbleToLogin()
	{
		driver = BrowserFactory.init();
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUsername(username);
		login.insertPassword(password);
		login.clickSignIn();
		
		DashBoardPage dashboard = PageFactory.initElements(driver, DashBoardPage.class);
		dashboard.validateDashBoardPage(actualText);
		dashboard.clickCustomer();
		dashboard.clickAddCustomer();
		
		AddContactPage contact = PageFactory.initElements(driver, AddContactPage.class);
		contact.insertName(name);
		contact.selectCompany(company);
		contact.insertEmail(email);
		contact.insertPhone(ph);
		contact.insertAddress(address);
		contact.insertCity(city);
		contact.insertState(state);
		contact.insertZip(zip);
		contact.selectCountry(country);
		contact.clickSaveButton();
	}
	
	

}
