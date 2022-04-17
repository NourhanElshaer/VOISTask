package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends PageBase{

	public SearchResultPage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor) driver; 
		action = new Actions(driver); 
	}
	@FindBy(xpath="//h1//yt-formatted-string[@class='style-scope ytd-video-primary-info-renderer']")
	public WebElement videoTitleFromVideo ;
	
	
	public String getVideoTitleAfterPlayingVideo() {
		String videoTitle=getTextOfElement(videoTitleFromVideo);
		return videoTitle;
		
	}
	
	
	@FindBy(css="h1.title.style-scope.ytd-video-primary-info-renderer > yt-formatted-string.style-scope.ytd-video-primary-info-renderer>span")
	public WebElement videoTitleFromVideo2 ;
	
	
	public String getVideoTitleAfterPlayingVideo2() {
		String videoTitle=getTextOfElement2(videoTitleFromVideo);
		return videoTitle;
		
	}
	
	
	public void waitUntilFiltersButtonNotVisible(WebDriverWait wait) {
		wait.until(ExpectedConditions.attributeToBeNotEmpty(videoTitleFromVideo2, null));
		}
}
