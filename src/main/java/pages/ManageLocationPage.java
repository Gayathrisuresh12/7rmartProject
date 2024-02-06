package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageLocationPage {
	
public WebDriver driver;
public PageUtility pageUtility;
	
	public ManageLocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath = "//select[@id='country_id']") WebElement countrySelectField;
	@FindBy(xpath = "//select[@id='st_id']") WebElement stateSelectField;
	@FindBy(xpath = "//input[@id='location']") WebElement locationInputField;
	@FindBy(xpath = "//input[@id='delivery']") WebElement deliveryChargeField;
	@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div") WebElement locationCreatedSuccessfullyAlertPopup;
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void selectCountry(String value) {
		pageUtility = new PageUtility();
		pageUtility.selectValueUsingSelectByValue(countrySelectField, value);
	}
	
	public void selectState(String visibleText) {
		pageUtility = new PageUtility();
		pageUtility.selectValueUsingSelectByVisibleText(stateSelectField, visibleText);
	}
	
	public void enterLocationInLocationInputField(String location) {
		locationInputField.sendKeys(location);
	}
	
	public void enterChargeInDeliveryChargeField(String deliveryCharge) {
		deliveryChargeField.sendKeys(deliveryCharge);
	}
	
	public void clickOnSaveButton( ) {
		saveButton.click();
	}
	
	public boolean islocationCreatedSuccessfullyAlertPopupDisplayed() {
		return locationCreatedSuccessfullyAlertPopup.isDisplayed();
	}

}