package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;


public class ManagePagesPage {
	
public WebDriver driver;
PageUtility pageUtility;
FileUploadUtility fileUploadUtility;
	
	
	public ManagePagesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//p[contains(text(), 'Manage Content')]/i[@class='fas fa-angle-left right']") WebElement manageContent;
	@FindBy(xpath="//p[contains(text(), 'Manage Pages')]//parent::a") WebElement managePages;
	@FindBy(xpath="//a[contains(text(), 'New') and @class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(xpath="//input[@type='file' and @id='main_img']") WebElement imageUploadButton;
	@FindBy(xpath="//input[@name='title']") WebElement titleField;
	@FindBy(xpath="//input[@name='page']") WebElement pageField;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']//child::div") WebElement pageCreatedSuccessfullyAlertPopup;



	public void clickOnManageContent() {
		manageContent.click();
	}
	
	public void clickOnManagePages() {
		managePages.click();
	}
	
	public void clickOnNewButton() {
		newButton.click();
	}
	
	public void enterTitleField(String title) {
		
		titleField.sendKeys(title);
		
	}
	
	public void enterPageField(String page) {
		
		pageField.sendKeys(page);
		
	}
	
	public void manageContent() {
	
			FileUploadUtility fileuploadutility = new FileUploadUtility();
			fileuploadutility.fileUploadUsingSendKeys(driver, imageUploadButton, GeneralUtility.MANAGECONTENT);	
	
	}
	
	public void clickOnSaveButton() {
		saveButton.click();
	}
	
	public boolean isPageCreatedSuccessfullyAlertPopupDisplayed() {
		return pageCreatedSuccessfullyAlertPopup.isDisplayed();
	}
	
	

}
