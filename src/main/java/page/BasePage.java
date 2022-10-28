package page;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
	
	public int generateRandomNum(int num)
	{
		Random rn = new Random();
		int randomNum = rn.nextInt(num);
		return randomNum;
	}
	
	public void selectDropDown(WebElement w , String visibleText)
	{
		Select sel = new Select(w);
		sel.selectByVisibleText(visibleText);
	}

}
