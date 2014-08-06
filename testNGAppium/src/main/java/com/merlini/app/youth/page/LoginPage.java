package com.merlini.app.youth.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import com.merlini.app.page.PageBase;

public class LoginPage extends PageBase {
	public LoginPage(AppiumDriver driver){
		this.driver=driver;
	}
    public void Login(String user ,String psw){
    	WebElement userContainer=findElementByDescription("LinearLayout","login_name");
    	MobileElement ele=new MobileElement((RemoteWebElement) userContainer,driver);
    	WebElement userEdit=ele.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.EditText\")");
    	userEdit.click();
    	//userEdit.clear();
    	clear(userEdit);
    	userEdit.sendKeys(user);
//    	WebElement pswContainer=driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").childSelector(new UiSelector().className(\"android.widget.TextView\").text(\"ÃÜÂë\"))"));
//    	MobileElement ele1=new MobileElement((RemoteWebElement) pswContainer,driver);
//    	WebElement pswEdit=ele1.findElement(MobileBy.tagName("android.widget.EditText"));
//    	pswEdit.sendKeys(psw);
    	driver.findElements(MobileBy.className("android.widget.EditText")).get(1).sendKeys(psw);
    	findButtonElementByText("µÇÂ¼").click();
    	
    }
}
