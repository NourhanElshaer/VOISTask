package tests;

import java.io.Console;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.taskdefs.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.SearchResultPage;

public class SearchYoutube extends  TestBase {
	HomePage homeObject ; 
	SearchResultPage  SearchResultObject;
	
	@DataProvider(name="searchData")
    public Object  [] searchData(){
        String [] data = new String[2];
        data [0] = "Selenium Tutorial";             
        data [1] =  "Test Automation Tutorial";   
       
        return data;
    }
	
	
	@Test(priority=0,   dataProvider = "searchData")
	public void searchYoutube(String searchValue) throws InterruptedException 
	{
//		String searchValue="Selenium Tutorial";
		homeObject = new HomePage(LocalDriverManager.getDriver()); 
		SearchResultObject = new SearchResultPage(LocalDriverManager.getDriver()); 
		LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		homeObject.searchBy(searchValue);
		homeObject.clickSearch();
		homeObject.clickFiltersBtn();
		LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		homeObject.clickVideofiltersButton();
		
		WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 60);
		homeObject.waitUntilVideoFiltersButtonNotVisible(wait);
		homeObject.scrollDown();
		String videoTitle=homeObject.getVideoTitle();
		homeObject.playVideo();
		homeObject.waitUntilFiltersButtonNotVisible(wait);
		LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		String videoTitleAfterOpeningVideo=SearchResultObject.getVideoTitleAfterPlayingVideo();
		System.out.println("titleBefor:"+ videoTitle);
		System.out.println("titleAfter:"+ videoTitleAfterOpeningVideo);
		Assert.assertEquals(videoTitle, videoTitleAfterOpeningVideo);
	}
	
	
	@Test(priority = 1)
	public void searchTenthVideo() throws InterruptedException 
	{
		LocalDriverManager.getDriver();
		homeObject = new HomePage(LocalDriverManager.getDriver()); 
		LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		homeObject.searchBy("Selenium Tutorial");
		homeObject.clickSearch();
		homeObject.clickFiltersBtn();
		LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;

		homeObject.clickVideofiltersButton();
		WebDriverWait wait = new WebDriverWait(LocalDriverManager.getDriver(), 60);
		homeObject.waitUntilVideoFiltersButtonNotVisible(wait);
		homeObject.scrollDown_10();
		String videoTitle=homeObject.getVideoTitle_10();
		homeObject.waitUntilVideoFiltersButtonNotVisible(wait);
		homeObject.playVideo_10();
		homeObject.waitUntilFiltersButtonNotVisible(wait);
		LocalDriverManager.getDriver().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
		Thread.sleep(2000);
		String videoTitleAfterOpeningVideo=SearchResultObject.getVideoTitleAfterPlayingVideo();
		System.out.println("titleBefor:"+ videoTitle);
		System.out.println("titleAfter:"+ videoTitleAfterOpeningVideo);
		Assert.assertEquals(videoTitle, videoTitleAfterOpeningVideo);
//
	}
	

}
