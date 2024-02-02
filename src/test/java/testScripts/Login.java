package testScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.ExcelUtility;

public class Login extends Base {
	
	@Test
	public void verifyUserAbleToLoginWithCorrectUsernameAndCorrectPassword() {
		
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(1, 1,"LoginPage" );
		
		WebElement usernameInputField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInputField.sendKeys(username);
		WebElement passwordInputField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInputField.sendKeys(password);
		WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signInButton.click();
		
		WebElement adminButton = driver.findElement(By.xpath("//i[@class='fas fa-bars']"));
        boolean isAdminButtonDisplayed = adminButton.isDisplayed();
        Assert.assertTrue(isAdminButtonDisplayed, "User not able to Login as the AdminButton is not found");
		
	}
	
	@Test
	public void verifyUserNOTAbleToLoginWithCorrectUsernameAndIncorrectPassword() {
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String wrongPassword = ExcelUtility.getString(1, 2,"LoginPage" );
		
		WebElement usernameInputField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInputField.sendKeys(username);
		WebElement passwordInputField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInputField.sendKeys(wrongPassword);
		WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signInButton.click();
		
		WebElement redAlertTextBox = driver.findElement(By.xpath("//button[@class='close']//parent::div"));
		boolean isRedAlertDisplayed = redAlertTextBox.isDisplayed();
		Assert.assertTrue(isRedAlertDisplayed, "User was able to login with Incorrect Password");
		
	}
	
	@Test
	public void verifyUserNOTAbleToLoginWithIncorrectUsernameAndCorrectPassword() {
		String wrongUsername = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(2, 1,"LoginPage" );
		
		WebElement usernameInputField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInputField.sendKeys(wrongUsername);
		WebElement passwordInputField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInputField.sendKeys(password);
		WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signInButton.click();
		
		WebElement redAlertTextBox = driver.findElement(By.xpath("//button[@class='close']//parent::div"));
		boolean isRedAlertTextBoxDisplayed = redAlertTextBox.isDisplayed();
		Assert.assertTrue(isRedAlertTextBoxDisplayed, "Red Alert Box is not displayed");
	}
	
	@Test
	public void verifyUserNOTAbleToLoginWithIncorrectUsernameAndIncorrectPassword() {
		String username = ExcelUtility.getString(1, 0,"LoginPage" );
		String password = ExcelUtility.getString(3, 2,"LoginPage" );
		
		WebElement usernameInputField = driver.findElement(By.xpath("//input[@placeholder='Username']"));
		usernameInputField.sendKeys(username);
		WebElement passwordInputField = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		passwordInputField.sendKeys(password);
		WebElement signInButton = driver.findElement(By.xpath("//button[text()='Sign In']"));
		signInButton.click();
		
		WebElement redAlertTextBox = driver.findElement(By.xpath("//button[@class='close']//parent::div"));
		boolean isRedAlertTextBoxDisplayed = redAlertTextBox.isDisplayed();
		Assert.assertTrue(isRedAlertTextBoxDisplayed, "Red Alert Box is not displayed");
	}
}
