package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxHealthPlanPage {
	
	@FindBy(className = "next-btn") private WebElement nextButton;
	
	public CoverfoxHealthPlanPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void ClickOnNextButton()
	{
		Reporter.log("Clicking on next Button",true);
		nextButton.click();
	}

}
