package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageDeliveryBoyPage {

	public WebDriver driver;


	public ManageDeliveryBoyPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);


	}

	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;

	@FindBy(xpath="//input[@placeholder='Name']") WebElement nameField;
	@FindBy(xpath="//input[@placeholder='Email']") WebElement emailField;
	@FindBy(xpath="//input[@placeholder='Phone Number']") WebElement phoneNumberField;
	@FindBy(xpath="//button[@type='submit']") WebElement submitButton;
	@FindBy(xpath = "//tbody/tr[1]") WebElement actualRowDetails;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']") WebElement manageDeliveryBoyGrid;



	public void clickOnManageDeliveryBoy() {

//		WebElement manageDeliveryBoyGrid = driver.findElement(By.xpath("//a[@href='https://groceryapp.uniqassosiates.com/admin/list-deliveryboy' and @class='small-box-footer']"));

		manageDeliveryBoyGrid.click();

	}

	public boolean isSearchButtonDisplayed() {
		return searchButton.isDisplayed();
	}

	public void clickOnSearchButton() {

		searchButton.click();

	}

	public boolean isNameFeildButtonDisplayed() {
		return nameField.isDisplayed();
	}

	public void enterNameOnNameFeild(String name) {
		nameField.sendKeys(name);
	}

	public void enterEmailOnEmailFeild(String email) {
		emailField.sendKeys(email);
	}

	public void enterNumberOnPhoneNumberFeild(String phoneNumber) {
		phoneNumberField.sendKeys(phoneNumber);
	}

	public void clickOnSubmitButton() {

		submitButton.click();

	}

	public List<String> getFirstRowDetails() {

		List<String> details = new ArrayList<String>();
		List<WebElement> cellDetails = actualRowDetails.findElements(By.tagName("td"));

		for (WebElement cell : cellDetails) {
			details.add(cell.getText());
		}

		return details;

	}


}
