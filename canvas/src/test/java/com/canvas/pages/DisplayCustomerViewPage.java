package com.canvas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.canvas.genericLib.BaseTest;

public class DisplayCustomerViewPage {

	@FindBy(xpath ="//input[@name='property(Campaign Name)']")
	private WebElement CampaignName;
	@FindBy(xpath = "//td[contains(text(),'Create Campaign')]/ancestor::table/following-sibling::table[2]/descendant::input[@value='Save']")
	private WebElement SaveBtn;

	public DisplayCustomerViewPage() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public WebElement getCampaignName() {
		return CampaignName;
	}

	public void setCampaignName(String campname) {
		CampaignName.sendKeys(campname);
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public void clickSaveBtn() {
		SaveBtn.click();

	}
}
