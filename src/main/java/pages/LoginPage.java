package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@placeholder='Username']") WebElement usernameField;
	@FindBy(xpath="//input[@placeholder='Password']") WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") WebElement signInButton;
	@FindBy(xpath="//i[@class='fas fa-bars']") WebElement adminButton;
	@FindBy(xpath="//button[@class='close']//parent::div") WebElement redAlertTextBox;



	public void enterUserNameOnUserNameFeild(String userName) {
		usernameField.sendKeys(userName);
	}
	
	public void enterPasswordOnPasswordFeild(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
	}
	
	public boolean isAdminButtonDisplayed() {
		return  adminButton.isDisplayed();
	}
		
	public boolean isredAlertTextBoxDisplayed() {
		return  redAlertTextBox.isDisplayed();
	}
	

}
