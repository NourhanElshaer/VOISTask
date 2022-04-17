package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase
{
	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	
	@FindBy(name="search_query")
	public WebElement searchBox ; 

	@FindBy(id="search-icon-legacy")
	public WebElement searchButton ; 
	
	@FindBy(xpath="//yt-formatted-string[text()='Filters']")
	public WebElement filtersButton ; 
	
	@FindBy(xpath="//yt-formatted-string[normalize-space()='Video']")
	public WebElement VideofiltersButton ; 
	
	@FindBy(xpath="(//a[@id='video-title'])[3]")
	public WebElement videotitleElement ;
	
	@FindBy(xpath="(//img[@class='style-scope yt-img-shadow' and @width='360'])[3]")
	public WebElement playVideo ;
	
	@FindBy(xpath="(//a[@id='video-title'])[10]")
	public WebElement videotitleElement_10 ;
	
	@FindBy(xpath="(//img[@class='style-scope yt-img-shadow' and @width='360'])[10]")
	public WebElement playVideo_10 ;
	

	
	public void clickSearch() 
	{
		clickButton(searchButton);

	}
	
	
	public void searchBy (String SeleniumTutorial) 
	{
		setTextElementText(searchBox, SeleniumTutorial);

	}

	public void clickFiltersBtn() 
	{
		clickButton(filtersButton);

	}
	
	public void clickVideofiltersButton() 
	{
		clickButton(VideofiltersButton);

	}
	
	public String getVideoTitle() {
		String videoTitle=getTitle(videotitleElement);
		return videoTitle;
		
	}
	
	public void playVideo() 
	{
		clickButton(playVideo);

	}
	
	public  void scrollDown() {
		jse.executeScript("scroll(0, 200);");
	}
	
	public  void scrollDown_10() {
		jse.executeScript("scroll(0, 1700);");
	}

	public void waitUntilFiltersButtonNotVisible(WebDriverWait wait) {
		wait.until(ExpectedConditions.invisibilityOf(filtersButton));
		}
	
	public void waitUntilVideoFiltersButtonNotVisible(WebDriverWait wait) {
		wait.until(ExpectedConditions.invisibilityOf(VideofiltersButton));
		}

	
	
	public String getVideoTitle_10() {
		String videoTitle=getTitle(videotitleElement_10);
		return videoTitle;
		
	}
	
	public void playVideo_10() 
	{
		clickButton(playVideo_10);

	}
}
