package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ManageOrderPage {
	
	
	public WebDriver driver;
	public PageUtility pageutility;
	
	
	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	
	
	@FindBy(xpath="//i[@class=\"nav-icon fas fa-shopping-basket\"]") WebElement manageOrder;
		
	@FindBy(xpath="//tbody//tr[1]//td[5]") WebElement paymentModeField;
	
	@FindBy(xpath="//tbody//tr[1]//a[@class='btn btn-primary btn-sm']") WebElement changeDeliveryDate;

	@FindBy(xpath="//tbody//tr[1]//input[@class='time1 time ui-timepicker-input']") WebElement timeField;
	
	@FindBy(xpath="//ul[@class=\"ui-timepicker-list\"]//li[2]") WebElement timeValue;

	@FindBy(xpath="//tbody//tr[1]//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date']//button[@type='submit']") WebElement updateButton;
	
	@FindBy(xpath="//div[@class=\"alert alert-success alert-dismissible\"]") WebElement alertPopup;

	
	
	public void clickOnManageOrder() {

		manageOrder.click();

	}
	
	public void clickOnChangeDeliveryDate() {
		
		changeDeliveryDate.click();
		
	}
	

	
	public void clickOnTimeField() {
		
		timeField.click();
		
		
	}
	
	public void clickOnTimeValue() {
		timeValue.click();
	}
	
	
	public void clickOnUpdateButton() {
		
		updateButton.click();
		
	}
	
	public boolean isDateChangesSuccessfullyAlertPopupDisplayed() {
		return alertPopup.isDisplayed();
	}
	
	
	
	
}

	
	


