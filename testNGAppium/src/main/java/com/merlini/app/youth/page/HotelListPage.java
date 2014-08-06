package com.merlini.app.youth.page;

import io.appium.java_client.AppiumDriver;

import com.merlini.app.page.PageBase;

public class HotelListPage extends PageBase {
	public HotelListPage(AppiumDriver driver){
		this.driver=driver;
	}
	public void navigateToFilter(){
		findTextViewElementByText("ɸѡ").click();
	}
    public void selectHotel(int index){
    	findElementsByDescription("RelativeLayout","hotel_list_item").get(index).click();
    }
}
