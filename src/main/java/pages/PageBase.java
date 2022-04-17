package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	protected WebDriver drvier ; 
	public static JavascriptExecutor jse ; 
	public Select select ; 
	public static Actions action ; 

	// create constructor 
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public  void clickButton(WebElement button) 
	{
		button.click();
	}
	
	
	 void setTextElementText(WebElement textElement , String value) 
	{
		textElement.sendKeys(value);
	}
	
	
	 String getTitle(WebElement button) 
	{
		String	titleName=button.getAttribute("title");
		return titleName;
	}
	
 void clickOnNonClickableElement(WebElement element) {
	    action.moveToElement(element);
	    action.click().perform();
	}
	
	protected static String getTextOfElement(WebElement element) 
	{
		String	textValue=element.getAttribute("innerHTML");
		return textValue;
	}
	

}
