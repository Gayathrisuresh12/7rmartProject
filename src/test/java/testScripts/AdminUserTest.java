package testScripts;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;
import utilities.RandomUtility;

public class AdminUserTest extends Base {
	
	@Test
	public void verifyThatUserIsAbleToAddAdminUsersInformationInAdminUsersLink() throws IOException {
		
		String username = ExcelUtility.getString(0, 1, "AdminUserTest");
		String password = ExcelUtility.getString(1, 1, "AdminUserTest");
		String selectedMenu = ExcelUtility.getString(2, 1, "AdminUserTest");
		String usernameToAdd = RandomUtility.getRandomUserName();
		String passwordToAdd = ExcelUtility.getString(3, 1, "AdminUserTest");
		String visibleTextOfUserType = ExcelUtility.getString(4, 1, "AdminUserTest");
		
		LoginPage loginpage = new LoginPage(driver);
		HomePage menupage = new HomePage(driver);
		AdminUserPage adminuserspage = new AdminUserPage(driver);
		loginpage.enterUserNameOnUserNameFeild(username);
		loginpage.enterPasswordOnPasswordFeild(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		adminuserspage.clickOnNewButton();
		adminuserspage.enterUsernameOnUsernameInputField(usernameToAdd);
		adminuserspage.enterPasswordOnPassowrdInputField(passwordToAdd);
		adminuserspage.selectUserType(visibleTextOfUserType);
		adminuserspage.clickOnSaveButton();
		
		boolean isUserCreationSuccessfulAlertDisplayed = adminuserspage.isUserCreationSuccessfulAlertDisplayed();
		assertTrue(isUserCreationSuccessfulAlertDisplayed, "User is not able to add Admin Users Information in Admin Users Link");
		
	}

}