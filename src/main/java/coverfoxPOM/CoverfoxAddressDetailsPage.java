package coverfoxPOM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxAddressDetailsPage {
	
	@FindBy(xpath = "//input[contains(@placeholder,'Pincode')]") private WebElement pincode;
	@FindBy(xpath = "//input[contains(@placeholder,'mobile')]") private WebElement mobNumber;
	@FindBy(className = "next-btn") private WebElement nextButton;

	
	public CoverfoxAddressDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void enterPincode(String pincodeValue)
	{
		Reporter.log("Entering pincode", true);
		pincode.sendKeys(pincodeValue);
	}
	
	public void enterMobileNumber(String mobileNumber)
	{
		Reporter.log("Entering mobile Number", true);
		mobNumber.sendKeys(mobileNumber);
	}
	
	public void ClickOnNextButton()
	{
		Reporter.log("Clicking on next Button", true);
		nextButton.click();
	}


}
