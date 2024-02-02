package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.GeneralUtility;
import utilities.PageUtility;
import utilities.WaitUtility;


public class ManageSliderPage {

	public WebDriver driver;
	
	public FileUploadUtility fileuploadutility;
	
	public PageUtility pageutilities;
	
	public WaitUtility waitutility;

	public ManageSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/Slider/add']") WebElement newButton;
	@FindBy(xpath = "//input[@type='file']") WebElement uploadButton;
	@FindBy(xpath = "//input[@type='text']") WebElement linkTextField;
	@FindBy(xpath = "//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath = "//div[@class='col-sm-12']") WebElement successfullAlert;

	public void clickOnNewButton() {
		newButton.click();
	}

	public void uploadImage() {

		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.fileUploadUsingSendKeys(driver, uploadButton, GeneralUtility.MANAGECONTENT);
	}

	public void enterLinkOnLinkTextField(String linkText) {
		linkTextField.sendKeys(linkText);
	}
	public void clickOnSaveButton() {
		PageUtility pageutilities = new PageUtility();
		pageutilities.javaScriptClick(driver, saveButton);
		
		WaitUtility waitUtility = new WaitUtility();
		waitUtility.ExplicitWaitForAnElement(driver, saveButton);
	}

	public boolean isSuccessfullAlertPopupDisplayed() {
		return successfullAlert.isDisplayed();
	}

}
