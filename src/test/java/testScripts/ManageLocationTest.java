package testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base {
	
	@Test
	public void verifyThatTheUserIsAbleToAddLocationInManageLocationMoreInfoLink() throws IOException {
		
		String username = ExcelUtility.getString(0, 1, "ManageLocationsTest");
		String password = ExcelUtility.getString(1, 1, "ManageLocationsTest");
		String selectedMenu = ExcelUtility.getString(2, 1, "ManageLocationsTest");
		String location = ExcelUtility.getString(3, 1, "ManageLocationsTest");
		String deliveryCharge = ExcelUtility.getString(4, 1, "ManageLocationsTest");
		
		String value = ExcelUtility.getInteger(5, 1, "ManageLocationsTest");
		String visibleText = ExcelUtility.getString(6, 1, "ManageLocationsTest");
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage menupage = new HomePage(driver);
		ManageLocationPage managelocationspage = new ManageLocationPage(driver);
		
		loginpage.enterUserNameOnUserNameFeild(username);
		loginpage.enterPasswordOnPasswordFeild(password);
		loginpage.clickOnSignInButton();
		
		menupage.clickOnMenu(selectedMenu);
		managelocationspage.clickOnNewButton();
		managelocationspage.selectCountry(value);
		managelocationspage.selectState(visibleText);
		managelocationspage.enterLocationInLocationInputField(location);
		managelocationspage.enterChargeInDeliveryChargeField(deliveryCharge);
		managelocationspage.clickOnSaveButton();
		boolean islocationCreatedSuccessfullyAlertPopupDisplayed = managelocationspage.islocationCreatedSuccessfullyAlertPopupDisplayed();
		assertTrue(islocationCreatedSuccessfullyAlertPopupDisplayed, "User is not able to add Location details in Manage Location More Info Link");
		
		
		
	}
}