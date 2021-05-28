package com.canvas.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.canvas.genericLib.BaseTest;

public class Loginpage {	  
		@FindBy(id="userName")private  WebElement untb;
		@FindBy(id="passWord")private WebElement pwtb;
		@FindBy(xpath="//input[@alt='Sign In']")private WebElement ltb;
		
		public Loginpage()
		{
			PageFactory.initElements(BaseTest.driver,this);
		}

		public WebElement getUntb() {
			return untb;
		}

		public void setUntb(String un) {
			untb.sendKeys(un);
		}

		public WebElement getPwtb() {
			return pwtb;
		}

		public void setPwtb(String pw) {
			pwtb.sendKeys(pw);
		}

		public WebElement getLtb() {
			return ltb;
		}

		public void setLtb() {
			ltb.click();
		}
		public void login(String un,String pw)
		{
			untb.sendKeys(un);
			pwtb.sendKeys(pw);
			ltb.click();
		}
	}