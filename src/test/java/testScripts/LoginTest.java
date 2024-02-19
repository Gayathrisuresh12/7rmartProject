package testScripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	@Test(description = "verify whether the User is able to login with valid credentials" ,priority=1,groups= {"Regression"})
	public void verifyUserAbleToLoginWithCorrectUsernameAndCorrectPassword() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		boolean isHomePageDisplayed = loginPage.isAdminButtonDisplayed();
        Assert.assertTrue(isHomePageDisplayed, "User not able to Login as the AdminButton is not found");
	}
	
	
	@Test(description = "verify whether the User is able to login with invalid pwd" ,groups= {"Regression"})
	public void verifyUserNOTAbleToLoginWithCorrectUsernameAndIncorrectPassword() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(3, 0,"LoginPage" );
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		boolean isRedAlertDisplayed = loginPage.isredAlertTextBoxDisplayed();
		Assert.assertTrue(isRedAlertDisplayed, "User able to login with Incorrect Password");
	}
	
	
	@Test
	public void verifyUserNOTAbleToLoginWithIncorrectUsernameAndCorrectPassword() {
		

		String username = ExcelUtility.getString(3, 1,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		boolean isRedAlertDisplayed = loginPage.isredAlertTextBoxDisplayed();
		Assert.assertTrue(isRedAlertDisplayed, "User  able to login with Incorrect Username");
	
		
	}
	
	@Test(dataProvider ="LoginProvider")
	public void verifyUserNOTAbleToLoginWithIncorrectUsernameAndIncorrectPassword(String username, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		boolean isRedAlertDisplayed = loginPage.isredAlertTextBoxDisplayed();
		Assert.assertTrue(isRedAlertDisplayed, "User able to login with Incorrect Username and Password");
	
		
	}
	
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws IOException {
		return new Object[][] { { ExcelUtility.getString(3, 1, "LoginPage"), ExcelUtility.getString(3, 0, "LoginPage") },

		};

}
}

