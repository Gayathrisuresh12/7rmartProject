package testScripts;

import static org.testng.Assert.assertEquals;

import java.util.List;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageDeliveryBoyPage;
import utilities.ExcelUtility;

public class ManageDeliveryBoyTest extends Base {
	
	@Test(description = "verify whether the User is able to search email and number" ,groups= {"Smoke"})
	public void verifyUserAbleToSearchWithNameAndEmailAndNumber() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		
		String expectedName = ExcelUtility.getString(1, 0,"ManageDeliveryBoy" );
		String expectedEmail = ExcelUtility.getString(1, 1,"ManageDeliveryBoy" );
		String expectedPhoneNumber =  ExcelUtility.getString(1, 2,"ManageDeliveryBoy" );
		String selectedMenu = ExcelUtility.getString(5, 3, "ManageDeliveryBoy");
		
		LoginPage loginPage = new LoginPage(driver);
		HomePage menupage = new HomePage(driver);
		loginPage.enterUserNameOnUserNameFeild(username);
		loginPage.enterPasswordOnPasswordFeild(password);
		loginPage.clickOnSignInButton();
		  
		ManageDeliveryBoyPage manageDeliveryBoyPage = new ManageDeliveryBoyPage(driver);
		menupage.clickOnMenu(selectedMenu);
		       
		manageDeliveryBoyPage.clickOnSearchButton();
        
		manageDeliveryBoyPage.enterNameOnNameFeild(expectedName);
		manageDeliveryBoyPage.enterEmailOnEmailFeild(expectedEmail);
		manageDeliveryBoyPage.enterNumberOnPhoneNumberFeild(expectedPhoneNumber);
		manageDeliveryBoyPage.clickOnSubmitButton();
		
		List<String> actualDetails = manageDeliveryBoyPage.getFirstRowDetails();
        assertEquals(actualDetails.get(0), expectedName, "Name not found!");
        assertEquals(actualDetails.get(1), expectedEmail, "Email not found!");
        assertEquals(actualDetails.get(2), expectedPhoneNumber, "Phone Number not found!");
		
  
	}

	
	

}
