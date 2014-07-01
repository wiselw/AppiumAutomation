package com.merlini.testNGAppium.car;

import java.util.Set;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;

import com.merlini.testNGAppium.PageBase;

public class CarHomePage extends PageBase{
	public CarHomePage(AppiumDriver driver){
		this.driver=driver;
	}
	public void switchToWebview() throws InterruptedException{
		Thread.sleep(6000);
		Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
          System.out.println(contextName);
          if (contextName.contains("WEBVIEW")){
            driver.context(contextName);
          }
        }
	}
	public void switchToTaxi(){
		driver.findElement(By.cssSelector(".list_st_border.carlist.carindex_20140414")).findElements(By.tagName("li")).get(2).click();
	}

}
