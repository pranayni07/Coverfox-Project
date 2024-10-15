package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverfoxMemberDetailsPage {
	@FindBy(name ="You") private WebElement ageDropdown;
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	public CoverfoxMemberDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void handleDropDown(String age)
	{
		Reporter.log("Handeled Age dropDown",true);
		Select s=new Select(ageDropdown);
		s.selectByValue(age+"y");
	}
	
	public void ClickOnNextButton()
	{
		Reporter.log("Clicking on next Button",true);
		nextButton.click();
	}

}
