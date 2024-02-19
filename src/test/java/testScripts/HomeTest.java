package testScripts;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	
	@Test(description = "verify whether the User is able to click on each grid")
	public void verifyUserAbleToClickOnEachGrid() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );

		String inputText = ExcelUtility.getString(1, 2,"ManagePages" );

		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
	 
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMenu(inputText);
		
	
	}
	

}
