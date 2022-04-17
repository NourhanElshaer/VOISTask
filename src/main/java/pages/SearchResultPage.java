package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
}
