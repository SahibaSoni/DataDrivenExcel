package util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	
	static WebDriver driver;
	static String browser = "Chrome";
	static String url = "https://www.techfios.com/billing/?ng=admin/";
	
	public static WebDriver init()
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else
		{
			System.out.println("Browser not found");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
