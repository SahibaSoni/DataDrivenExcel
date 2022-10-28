 package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashBoardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;
	
	ExcelReader exlRead = new ExcelReader("testData\\TF_TestData.xlsx");
	String username = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);;
	String actualText = "Dashboard";
	
	
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
	}
}
