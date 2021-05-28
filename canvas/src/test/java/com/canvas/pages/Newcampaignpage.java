package com.canvas.pages;


import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.canvas.genericLib.BaseTest;

public class Newcampaignpage {

	@FindBy(xpath ="//input[@value='New Campaign']")
	private WebElement newCampaignBtn;
	@FindBy(xpath = "//table[@class='secContent']//tbody//tr[*]//td[@class=\"tableData\"][3]")
	private List<WebElement> CampaignList;

	
	public Newcampaignpage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getNewCampaignbtn() {
		return newCampaignBtn;
	}

	public void clickNewCampaignbtn() {
		newCampaignBtn.click();
	}
	public void verifyCampaignCreation(String campaign) {
		for(WebElement onecampaign:CampaignList) {
			String CampaignName=onecampaign.getText();
		if(CampaignName.equals(campaign))
		{
			Reporter.log("our campaign is created",true);
			break;
		}else
		{
			Reporter.log("our campaign is not created",true);
		}
		}	
}

	
}
