package coverfoxPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverfoxResultPage {
	
	@FindBy(xpath = "//div[contains(text(),'Insurance Plans')]") private WebElement myText;
	@FindBy(className = "plan-card-container") private List<WebElement> banners;
	@FindBy(xpath="//div[text()='Sort Plans']") private WebElement sortPlanFilter;
	
	public CoverfoxResultPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateNumberOfBanners()
	{
	    String[] ar = myText.getText().split(" ");
	    String numberInString = ar[0];
	    int Result = Integer.parseInt(numberInString);
		Reporter.log("gettting total Banners", true);
		
		int numberOfBanners = banners.size();
		System.out.println(numberOfBanners);
		
		if (numberOfBanners == Result)
			System.out.println("Result is matching, TC passed");
		else
			System.out.println("Result not matching, TC fialed");
	}
	
	public int getPlanNumersFromString()
	{
	String ar[]=myText.getText().split(" ");
	Reporter.log("gettting Plan Numbers From String", true);

	int result = Integer.parseInt(ar[0]);
	return result;
	}
	public int getPlanNumersFromBanners()
	{
	int bannerSize = banners.size();
	Reporter.log("gettting Plan Numbers From Banners", true);

	return bannerSize;
	}
	
	public boolean sortPlanFilterIsDisplayed()
	{
		boolean result = sortPlanFilter.isDisplayed();
		Reporter.log("Checking if sortPlanFilter is Displayed", true);
		return result;
	}
}
