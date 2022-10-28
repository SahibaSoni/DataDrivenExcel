package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
//	String username;
//	String password;
//	String signin;
//	
	public LoginPage(WebDriver driver)
	{
		// Because its construcor concept
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH,using = "//input[@id = 'username']")WebElement UsernameElement;
	@FindBy(how = How.XPATH,using = "//input[@id = 'password']")WebElement PasswordElement;
	@FindBy(how = How.XPATH,using = "//button[text() = 'Sign in']")WebElement SignInElement;
	
	public void insertUsername(String username)
	{
		UsernameElement.sendKeys(username);
	}

	public void insertPassword(String password)
	{
		PasswordElement.sendKeys(password);
	}

	public void clickSignIn()
	{
		SignInElement.click();;
	}

}
