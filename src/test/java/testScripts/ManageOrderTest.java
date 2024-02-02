package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageOrderPage;
import utilities.ExcelUtility;

public class ManageOrderTest extends Base {
	
	
	@Test
	public void verifyUserAbleToChangeStatus() {
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		
		String selectedMenu = "Manage Order";
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		
		ManageOrderPage manageOrderPage = new ManageOrderPage(driver);
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMenu(selectedMenu);
		manageOrderPage.clickOnChangeDeliveryDate();
		manageOrderPage.clickOnTimeField();
		manageOrderPage.clickOnTimeValue();
		manageOrderPage.clickOnUpdateButton();
		
		
		boolean isDateChangedSuccessfullyAlertPopupDisplayed = manageOrderPage.isDateChangesSuccessfullyAlertPopupDisplayed();
		assertTrue(isDateChangedSuccessfullyAlertPopupDisplayed, "User is not able to change delivery address in Manage Order Page");
		
	}

}
