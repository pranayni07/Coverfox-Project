package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHomePage {
	//WebElement-->Data Members
	@FindBy(xpath = "//div[text()='Male']") private WebElement maleButton;
	
	//constructor
	public CoverfoxHomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//method()
	public void clickOnGender()
	{
		Reporter.log("Clicking on gender button",true);
		maleButton.click();
	}

}
