package testScripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ManageSliderPage;
import utilities.ExcelUtility;

public class ManageSliderTest extends Base{
	
	
	
	@Test(description = "verify whether the User is able to upload image in manage slider page")
	public void verifyThatUserIsAbleToUploadImageInManageSliderLink() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		
		String selectedMenu = ExcelUtility.getString(1, 0,"ManageSlider" );
		String linkText = ExcelUtility.getString(1, 1,"ManageSlider" );
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage menupage = new HomePage(driver);
		ManageSliderPage managesliderpage = new ManageSliderPage(driver);
		
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		
		menupage.clickOnMenu(selectedMenu);
		managesliderpage.clickOnNewButton();
		managesliderpage.uploadImage();
		managesliderpage.enterLinkOnLinkTextField(linkText);
		managesliderpage.clickOnSaveButton();
		
		boolean isSuccessfullAlertisplayed = managesliderpage.isSuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertisplayed, "User is not able to upload image in Manage Slider Link");	
	}

}
