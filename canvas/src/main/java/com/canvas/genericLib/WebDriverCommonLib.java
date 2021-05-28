package com.canvas.genericLib;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommonLib extends BaseTest {

	public String getPageTitle()
	{
		String pageTitle = driver.getTitle();
		return pageTitle;
	}
	public void waitForPageLoad(String title)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void selectOption(WebElement element,String text)
	{
		Select sel = new Select(element);
        sel.selectByVisibleText(text);
	}
	public void selectOption(String value,WebElement element)
	{
     		Select sel = new Select(element);
         sel.selectByValue(value);
	}
	public void selectOption(WebElement element,int index)
	{
     		Select sel = new Select(element);
           sel.selectByIndex(index);
	}
    public void switchToFrame(int index)
    {
    	driver.switchTo().frame(index);
	}
    public void  switchToFrame(String value)
    {
    	driver.switchTo().frame(value);
    }
    public void switchToFrame(WebElement element)
    {
    	driver.switchTo().frame(element);
    }
    public void mouseHover(WebElement element)
    {
    	Actions ac=new Actions(driver);
    	ac.moveToElement(element).perform();
    }
	public void verify(String actual,String expected,String page)
	{
		Assert.assertEquals(actual,expected);
		Reporter.log(page+"is Displayed,PASS",true);
	}
	public void verifyElement(WebElement element,String elementName)
	{
		if(element.isDisplayed())
		{
			Assert.assertTrue(true);
			Reporter.log(elementName+"is Displayed,PASS", true);
		}else
		{
			Reporter.log(elementName+"is not Displayed,FAIL", true);
			Assert.assertTrue(false);
		}
	}
	public void getPageScreenshot(String path) {
	      TakesScreenshot ts=(TakesScreenshot) BaseTest.driver;
	      File src = ts.getScreenshotAs(OutputType.FILE);
	      File dest=new File(path);
	      try
	      {
	    	  Files.copy(src, dest);
	      }catch(IOException e) {
	    	  
	      }
		
	}
	public void getElementScreenshot(String path,WebElement element)
	{
		File src = element.getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		try
		{
			Files.copy(src, dest);
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
