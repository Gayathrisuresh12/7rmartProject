package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.ManagePagesPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ManagePagesTest extends Base {
	
	@Test(description = "verify whether the User is able to upload image in image field")
	public void verifyUserAbleToUploadFileInManagePageImagefield() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		
		String titleField = ExcelUtility.getString(1, 0,"ManagePages" );
		String pageField = ExcelUtility.getString(1, 1,"ManagePages" );


		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		
		ManagePagesPage managePagesPage = new ManagePagesPage(driver);
		managePagesPage.clickOnManageContent();
		managePagesPage.clickOnManagePages();
		managePagesPage.clickOnNewButton();
		managePagesPage.enterTitleField(titleField);
		managePagesPage.enterPageField(pageField);
		managePagesPage.manageContent();
		managePagesPage.clickOnSaveButton();
		
		boolean isPageCreatedSuccessfullyAlertPopupDisplayed = managePagesPage.isPageCreatedSuccessfullyAlertPopupDisplayed();
		assertTrue(isPageCreatedSuccessfullyAlertPopupDisplayed, "User is not able to add Location details in Manage Location More Info Link");
		
		
	}

}
