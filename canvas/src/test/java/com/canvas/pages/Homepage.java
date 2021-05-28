package com.canvas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.canvas.genericLib.BaseTest;

public class Homepage {

	@FindBy(xpath = "//a[text()='Campaigns']")private WebElement camaigntab;
	
	
   public Homepage()
	{
		PageFactory.initElements(BaseTest.driver, this);
	}

public WebElement getCamaigntab() {
	return camaigntab;
}
   public void clickcamigntab() {
	   camaigntab.click();
   }

}
