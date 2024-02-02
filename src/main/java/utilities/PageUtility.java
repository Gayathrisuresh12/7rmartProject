package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	public void selectValueUsingSelectByIndex(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectValueUsingSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);		
	}
	
	public void selectValueUsingSelectByVisibleText(WebElement element, String visibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
	
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void promtAlert (WebElement alertElement,String input, WebDriver driver) {
		driver.switchTo().alert().sendKeys(input);
   	  	driver.switchTo().alert().accept();
	}
	
	public void frame(WebElement iframe, WebDriver driver) {
		driver.switchTo().frame(iframe);
	}

	public void javaScriptClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	
	


}
