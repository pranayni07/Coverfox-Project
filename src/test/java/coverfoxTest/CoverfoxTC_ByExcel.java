package coverfoxTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;

import coverfoxPOM.CoverfoxAddressDetailsPage;
import coverfoxPOM.CoverfoxHealthPlanPage;
import coverfoxPOM.CoverfoxHomePage;
import coverfoxPOM.CoverfoxResultPage;
import coverfoxPOM.CoverfoxMemberDetailsPage;
import coverfoxUtility.Utility;

public class CoverfoxTC_ByExcel extends coverfoxBase.BaseClass {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		
		String filePath = System.getProperty("user.dir")+"\\myExcel.xlsx";
		String age = Utility.readDataFromExcel(filePath, "Sheet2", 0, 1);
		String pinCode = Utility.readDataFromExcel(filePath, "Sheet2", 0, 2);
		String mobileNumber = Utility.readDataFromExcel(filePath, "Sheet2", 0, 3);
		
		CoverfoxTC_ByExcel base=new CoverfoxTC_ByExcel();
		base.openBrowser();
		
		Thread.sleep(2000);
		CoverfoxHomePage homePage = new CoverfoxHomePage(driver);
		homePage.clickOnGender();
		
		Thread.sleep(2000);
		CoverfoxHealthPlanPage healthPlan=new CoverfoxHealthPlanPage(driver);
		healthPlan.ClickOnNextButton();
		
		Thread.sleep(5000);
		CoverfoxMemberDetailsPage memberDetails=new CoverfoxMemberDetailsPage(driver);
		memberDetails.handleDropDown(age);
		memberDetails.ClickOnNextButton();
		
		Thread.sleep(2000);
		CoverfoxAddressDetailsPage addressDetails=new CoverfoxAddressDetailsPage(driver);
		addressDetails.enterPincode(pinCode);
		addressDetails.enterMobileNumber(mobileNumber);
		addressDetails.ClickOnNextButton();
		
		Thread.sleep(5000);
		CoverfoxResultPage resultPage=new CoverfoxResultPage(driver);
		resultPage.validateNumberOfBanners();
		
		base.browserClose();
	
	}

}
