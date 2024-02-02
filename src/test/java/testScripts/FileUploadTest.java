package testScripts;

import org.testng.annotations.Test;

import pages.FileUploadPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class FileUploadTest extends Base {
	
	@Test
	public void verifyUserAbleToUploadFileInManagePageImagefield() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		
		String titleField = ExcelUtility.getString(1, 0,"ManagePages" );
		String pageField = ExcelUtility.getString(1, 1,"ManagePages" );


		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		
		FileUploadPage fileUploadPage = new FileUploadPage(driver);
		fileUploadPage.clickOnManageContent();
		fileUploadPage.clickOnManagePages();
		fileUploadPage.clickOnNewButton();
		fileUploadPage.enterTitleField(titleField);
		fileUploadPage.enterPageField(pageField);
		fileUploadPage.manageContent();
		fileUploadPage.clickOnSaveButton();
		
	}

}
