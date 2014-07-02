package com.merlini.app.page;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends PageBase{
	public HomePage(AppiumDriver driver){
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
