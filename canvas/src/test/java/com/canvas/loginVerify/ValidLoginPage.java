package com.canvas.loginVerify;

import com.canvas.genericLib.BaseTest;
import com.canvas.genericLib.FileLib;
import com.canvas.genericLib.WebDriverCommonLib;
import com.canvas.pages.Loginpage;

public class ValidLoginPage extends BaseTest{

	
	public void loginToApp() throws Throwable {
		Loginpage lp=new Loginpage();
		FileLib fl=new FileLib();
		lp.login(fl.readPropData(prop_path,"username"),fl.readPropData(prop_path, "password"));
		
		WebDriverCommonLib wd=new WebDriverCommonLib();
		wd.verify(wd.getPageTitle(), fl.readPropData(prop_path, "homeTitle"), "Home Page");
	}
}
