package testScripts;

import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ManageExpensePage;
import pages.HomePage;
import utilities.ExcelUtility;

public class ManageExpenseTest extends Base {

	@Test
	public void verifyThatUserIsAbleToAddExpenseAndUploadImageInManageExpenseTest() throws IOException {

		String username = ExcelUtility.getString(0, 1, "ManageExpenseTest");
		String password = ExcelUtility.getString(1, 1, "ManageExpenseTest");
		String selectedMenu = ExcelUtility.getString(2, 1, "ManageExpenseTest");
		String visibleTextOfUserId = ExcelUtility.getString(3, 1, "ManageExpenseTest");
		String visibleTextOfCategory = ExcelUtility.getString(4, 1, "ManageExpenseTest");
		String visibleTextOfOrderId = ExcelUtility.getInteger(5, 1, "ManageExpenseTest");
		String visibleTextOfPurchaseId = ExcelUtility.getInteger(6, 1, "ManageExpenseTest");
		String visibleTextOfExpenseType = ExcelUtility.getString(7, 1, "ManageExpenseTest");
		String amount = ExcelUtility.getInteger(8, 1, "ManageExpenseTest");
		String remarks = ExcelUtility.getString(9, 1, "ManageExpenseTest");

		LoginPage loginpage = new LoginPage(driver);
		HomePage menupage = new HomePage(driver);
		ManageExpensePage manageExpensePage = new ManageExpensePage(driver);
		loginpage.enterUserNameOnUserNameFeild(username);
		loginpage.enterPasswordOnPasswordFeild(password);
		loginpage.clickOnSignInButton();
		menupage.clickOnMenu(selectedMenu);
		manageExpensePage.clickOnNewButton();
		manageExpensePage.selectUserId(visibleTextOfUserId);
		manageExpensePage.selectCategory(visibleTextOfCategory);
		manageExpensePage.selectOrderId(visibleTextOfOrderId);
		manageExpensePage.selectPurchaseId(visibleTextOfPurchaseId);
		manageExpensePage.selectExpenseType(visibleTextOfExpenseType);
		manageExpensePage.enterAmountInAmountInputField(amount);
		manageExpensePage.enterRemarksInRemarksInputField(remarks);
		manageExpensePage.uploadFile();
		manageExpensePage.clickOnSaveButton();

		boolean isSuccessfullAlertPopupDisplayed = manageExpensePage.issuccessfullAlertPopupDisplayed();
		assertTrue(isSuccessfullAlertPopupDisplayed, "User is not able to add expense and upload image in Manage Expense Link");	
	}

}