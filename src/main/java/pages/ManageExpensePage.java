package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageExpensePage {
	
	public WebDriver driver;
	public PageUtility pageutility;
	public FileUploadUtility fileuploadutility;
	public GeneralUtility generalutility;
	public WaitUtility waitutility;
		
		public ManageExpensePage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
		@FindBy(xpath = "//select[@name='user_id']") WebElement userIdSelectField;
		@FindBy(xpath = "//select[@name='ex_cat']") WebElement categorySelectField;
		@FindBy(xpath = "//select[@name='order_id']") WebElement orderIdSelectField;
		@FindBy(xpath = "//select[@name='purchase_id']") WebElement purchaseIdSelectField;
		@FindBy(xpath = "//select[@name='ex_type']") WebElement expenseTypeSelectField;
		@FindBy(xpath = "//input[@id='amount']") WebElement amountInputField;
		@FindBy(xpath = "//textarea[@id='content']") WebElement remarksInputField;
		@FindBy(xpath = "//input[@name='userfile']") WebElement chooseFileButton;
		@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
		@FindBy(xpath = "//div[@class='col-sm-12']//child::div") WebElement successfullAlertPopup;
		
		
		public void clickOnNewButton() {
			newButton.click();
		}
		
		public void selectUserId(String visibleTextOfUserId) {
			pageutility = new PageUtility();
			pageutility.selectValueUsingSelectByVisibleText(userIdSelectField, visibleTextOfUserId);
		}
		
		public void selectCategory(String visibleTextOfCategory) {
			pageutility = new PageUtility();
			pageutility.selectValueUsingSelectByVisibleText(categorySelectField, visibleTextOfCategory);
		}
		
		public void selectOrderId(String visibleTextOfOrderId) {
			pageutility = new PageUtility();
			pageutility.selectValueUsingSelectByVisibleText(orderIdSelectField, visibleTextOfOrderId);
		}
		
		public void selectPurchaseId(String visibleTextOfPurchaseId) {
			pageutility = new PageUtility();
			pageutility.selectValueUsingSelectByVisibleText(purchaseIdSelectField, visibleTextOfPurchaseId);
		}
		
		public void selectExpenseType(String visibleTextOfExpenseType) {
			pageutility = new PageUtility();
			pageutility.selectValueUsingSelectByVisibleText(expenseTypeSelectField, visibleTextOfExpenseType);
		}
		
		public void enterAmountInAmountInputField(String amount) {
			amountInputField.sendKeys(amount);
		}
		
		public void enterRemarksInRemarksInputField(String remarks) {
			remarksInputField.sendKeys(remarks);
		}
		
		public void uploadFile() {
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(driver, chooseFileButton, GeneralUtility.MANAGECONTENT);
		}
		
		public void clickOnSaveButton() {
			
			PageUtility pageutilities = new PageUtility();
			pageutilities.javaScriptClick(driver, saveButton);
			
			WaitUtility waitUtility = new WaitUtility();
			waitUtility.ExplicitWaitForAnElement(driver, saveButton);
		}
		
		public boolean issuccessfullAlertPopupDisplayed() {
			
			return successfullAlertPopup.isDisplayed();
		}
		
}