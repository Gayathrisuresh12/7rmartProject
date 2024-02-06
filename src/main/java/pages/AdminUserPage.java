package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUserPage {
	
	public WebDriver driver;
	public PageUtility pageUtility;
		
		public AdminUserPage(WebDriver driver) {
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
		@FindBy(xpath = "//input[@id='username']") WebElement usernameInputField;
		@FindBy(xpath = "//input[@id='password']") WebElement passwordInputField;
		@FindBy(xpath = "//select[@id='user_type']") WebElement userTypeSelectField;
		@FindBy(xpath = "//button[@name='Create']") WebElement saveButton;
		@FindBy(xpath = "//div[@class='row-sm-12']//child::div[@class='alert alert-success alert-dismissible']") WebElement userCreationSuccessfulAlert;
		
		public void clickOnNewButton() {
			newButton.click();
		}
		
		public void enterUsernameOnUsernameInputField(String usernameToAdd) {
			usernameInputField.sendKeys(usernameToAdd);
		}
		
		public void enterPasswordOnPassowrdInputField(String passwordToAdd) {
			passwordInputField.sendKeys(passwordToAdd);
		}
		
		public void selectUserType(String visibleTextOfUserType) {
			pageUtility = new PageUtility();
			pageUtility.selectValueUsingSelectByVisibleText(userTypeSelectField, visibleTextOfUserType);
		}
		
		public void clickOnSaveButton() {
			saveButton.click();
		}
		
		public boolean isUserCreationSuccessfulAlertDisplayed() {
			return userCreationSuccessfulAlert.isDisplayed();
		}

}
