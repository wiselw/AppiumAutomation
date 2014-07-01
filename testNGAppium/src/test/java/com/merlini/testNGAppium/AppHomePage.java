package com.merlini.testNGAppium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;

public class AppHomePage extends PageBase{
	
	
	public AppHomePage(AppiumDriver driver){
		//
		this.driver=driver;
	}
	public void SwitchTo(Navi navi){
		//
        switch(navi){
        case Flight:
        	break;
        case Train:
        	break;
        case Car:
        	WebElement car=WaitForElement(By.name("用车"));
        	car.click();
        	break;
        case Hotel:
        	WebElement hotel=WaitForElement(By.name("酒店"));
        	hotel.click();
        	break;
        case Money:
        	break;
        case Tuan:
        	break;
        default:
        	break;
        }
	}
	

}
