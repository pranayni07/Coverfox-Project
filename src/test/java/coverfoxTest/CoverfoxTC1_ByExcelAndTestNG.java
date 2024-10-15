package coverfoxTest;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import coverfoxPOM.CoverfoxAddressDetailsPage;
import coverfoxPOM.CoverfoxHealthPlanPage;
import coverfoxPOM.CoverfoxHomePage;
import coverfoxPOM.CoverfoxMemberDetailsPage;
import coverfoxPOM.CoverfoxResultPage;
import coverfoxUtility.Utility;


//@Listeners(coverfoxUtility.Listener.class)   //If there is single listner then add to test class 
                                               //otherwise we have to add multiple listner inside testng.xml file
public class CoverfoxTC1_ByExcelAndTestNG extends coverfoxBase.BaseClass {

	CoverfoxHomePage homePage;
	CoverfoxHealthPlanPage healthPlanPage;
	CoverfoxAddressDetailsPage addressDetailsPage;
	CoverfoxMemberDetailsPage memberDetailsPage;
	CoverfoxResultPage resultPage;
	String filepath;
	public static Logger logger;

	@BeforeTest
	public void launchBrowser() {
		logger=Logger.getLogger("CoverfoxProject");
		PropertyConfigurator.configure("Log4j.properties");
		logger.info("open browser");
		
		openBrowser();
		homePage = new CoverfoxHomePage(driver);
		healthPlanPage = new CoverfoxHealthPlanPage(driver);
		memberDetailsPage = new CoverfoxMemberDetailsPage(driver);
		addressDetailsPage = new CoverfoxAddressDetailsPage(driver);
		resultPage = new CoverfoxResultPage(driver);
		filepath = System.getProperty("user.dir")+"\\myExcel.xlsx";
		
	}

	@BeforeClass
	public void preconditions() throws EncryptedDocumentException, IOException, InterruptedException {
		logger.info("Clicking on Gender button");
		homePage.clickOnGender();
		Thread.sleep(2000);

		logger.info("Clicking on next button");
		healthPlanPage.ClickOnNextButton();
		Thread.sleep(2000);

		logger.warn("enters age between 18-90");
		logger.info("Handeling age drop down");
		memberDetailsPage.handleDropDown(Utility.readDataFromExcel(filepath, "Sheet2", 0, 1));
		Thread.sleep(2000);
		
		logger.info("Clicking on next button");
		memberDetailsPage.ClickOnNextButton();
		Thread.sleep(2000);
		
		logger.warn("please enter valid pin code");
		logger.info("entering pin code");
		addressDetailsPage.enterPincode(Utility.readDataFromExcel(filepath, "Sheet2", 0, 2));
		Thread.sleep(2000);

		logger.warn("please enter valid mobile number");
		logger.info("entering mobile number");
		addressDetailsPage.enterMobileNumber(Utility.readDataFromExcel(filepath, "Sheet2", 0, 3));
        Thread.sleep(2000);

        logger.info("Clicking on continue button");
		addressDetailsPage.ClickOnNextButton();
		Thread.sleep(2000);
	}

	@Test
	public void validateBanners() throws InterruptedException, IOException {
		Thread.sleep(4000);
		logger.info("validating Banners");
		//Assert.fail();
		int bannerPlanNumbers = resultPage.getPlanNumersFromBanners();
		int StringplanNumbers = resultPage.getPlanNumersFromString();
		Assert.assertEquals(StringplanNumbers, bannerPlanNumbers,
				"Plans on banners not matching with results, TC failed");
		Utility.takeScreenShot(driver, "validateBanners");

	}

	@Test
	public void validatePresenceOfSortButton() throws InterruptedException, IOException {
		Thread.sleep(4000);
		logger.info("validating presence of sort button");
		//Assert.fail();
		Assert.assertTrue(resultPage.sortPlanFilterIsDisplayed(), "Sort Plan Filter is not displayed, TC is failed");
		Utility.takeScreenShot(driver, "validatePresenceOfSortButton");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		logger.info("closing browser");
		browserClose();
	}

}
