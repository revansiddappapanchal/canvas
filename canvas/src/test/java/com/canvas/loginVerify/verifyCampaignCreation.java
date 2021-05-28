package com.canvas.loginVerify;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.canvas.genericLib.BaseTest;
import com.canvas.genericLib.FileLib;
import com.canvas.genericLib.WebDriverCommonLib;
import com.canvas.pages.DisplayCustomerViewPage;
import com.canvas.pages.Homepage;
import com.canvas.pages.Newcampaignpage;
@Listeners(com.canvas.genericLib.MyListeners.class)
public class verifyCampaignCreation extends BaseTest {

	@Test
	public void verifyoperationTest() throws Throwable {
		// open the browser and enter the URL and click on go button and verify login
		// page

		// login to app and verify HOME PAGE
		ValidLoginPage v1 = new ValidLoginPage();
		v1.loginToApp();

		// click on campaignPage
		Homepage hp = new Homepage();
		hp.clickcamigntab();

		WebDriverCommonLib wdlib = new WebDriverCommonLib();
		FileLib flib = new FileLib();
		wdlib.verify(wdlib.getPageTitle(), flib.readPropData(prop_path, "NewCampaignTitle"), "NewCampaignTitle");

		// click on newcampaignpage
		Newcampaignpage ncp = new Newcampaignpage();
		ncp.clickNewCampaignbtn();
		wdlib.verify(wdlib.getPageTitle(), flib.readPropData(prop_path, "CreatePageTitle"), "Create Page Title");

		//Click    'Save'  button and verify 
		DisplayCustomerViewPage dc=new DisplayCustomerViewPage();
		dc.setCampaignName("siddu");
		dc.clickSaveBtn();
		Thread.sleep(2000);
		hp.clickcamigntab();
		Thread.sleep(2000);
	  ncp.verifyCampaignCreation("siddu");
		
	}
}
