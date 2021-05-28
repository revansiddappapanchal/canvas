package com.canvas.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest implements IAautoConsts {
  public static WebDriver driver;
 
  @BeforeClass
  public void openBrowser() throws Throwable 
  {
	  FileLib flib=new FileLib();
	  String browserName=flib.readPropData(prop_path, "browser");
	  if(browserName.equalsIgnoreCase("chrome")) {
		  System.setProperty(chrome_key, chrome_value);
		 driver=new ChromeDriver();
	  }
	  else if(browserName.equalsIgnoreCase("firebox")) {
		  System.setProperty(GECKO_KEY, GECKO_VALUE);
		  driver=new FirefoxDriver();
	  }
	  else {
		  System.out.println("Enter Proper browser name");
	  }
	  
	  driver.manage().window().maximize();
	  String appUrl = flib.readPropData(prop_path, "url");
	  driver.get(appUrl);
	  
	
	WebDriverCommonLib wlib = new WebDriverCommonLib();
     wlib.verify(wlib.getPageTitle(),flib.readPropData(prop_path, "loginTitle"),"LoginPage");
     
  }
 @AfterClass(enabled =false)
  public void closeBrowser() {
	  driver.quit();
  }

}
