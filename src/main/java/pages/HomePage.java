package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HomePage {
	
	public WebDriver driver;
	PageUtility pageUtility;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		
	}
	@FindBy(xpath = "//div[contains(@class,'small')]//child::div[@class='inner']") List<WebElement> menuList;
	@FindBy(xpath = "//a[@class='small-box-footer']") List<WebElement> menuLink;
	@FindBy(xpath="//input[@placeholder='Email']") WebElement emailField;
	@FindBy(xpath="//div[@class='row']/div") List<WebElement> gridValue;
	
	public void clickOnMenu(String selectedMenu) {
		int menuIndex;
		for (WebElement menuItem : menuList) {
			menuIndex = menuList.indexOf(menuItem);
			if(menuIndex!=-1 && menuItem.getText().contains(selectedMenu)) {
				menuLink.get(menuIndex).click();	
				break;
			}
		}
	}

	
	public void dummyMethod() {
		
		pageUtility= new PageUtility();
		pageUtility.selectValueUsingSelectByIndex(emailField, 1);
			
		
	}
	

}
