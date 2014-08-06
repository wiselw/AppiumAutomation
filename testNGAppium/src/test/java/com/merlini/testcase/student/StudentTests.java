package com.merlini.testcase.student;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import com.merlini.app.common.AppHelper;
import com.merlini.app.youth.page.FilterPage;
import com.merlini.app.youth.page.GoTravelPage;
import com.merlini.app.youth.page.HotelDetailPage;
import com.merlini.app.youth.page.HotelListPage;
import com.merlini.app.youth.page.HotelSearchPage;
import com.merlini.app.youth.page.LoginPage;
import com.merlini.app.youth.page.OrderDetailPage;
import com.merlini.common.BaseCase;

public class StudentTests extends BaseCase{
  @Test
  public void f() {
	  try
	  {
		  //首页
		  GoTravelPage goTravelPage=new GoTravelPage(driver);
		  //酒店首页
		  HotelSearchPage hotelSearchPage=new HotelSearchPage(driver);
		  //酒店列表页
		  HotelListPage hotelListPage=new HotelListPage(driver);
		  //筛选页
		  FilterPage filterPage =new FilterPage(driver);
		  //酒店详情页
		  HotelDetailPage hotelDetailPage=new HotelDetailPage(driver);
		  //订单详情页
		  OrderDetailPage orderDetailPage=new OrderDetailPage(driver);
		  goTravelPage.navigateTo("去旅行");
		  goTravelPage.nextToHotel();
		  hotelSearchPage.clickMyPosition();
		  hotelSearchPage.clickSearchButton();
		  hotelListPage.navigateToFilter();
		  filterPage.setPayMethod("到店付款(酒店前台付款)");
		  hotelListPage.selectHotel(0);

		  hotelDetailPage.selectRoom(1);
		  if(!hotelDetailPage.checkLogin()){
			  //
			  LoginPage loginPage=new LoginPage(driver);
			  loginPage.Login("15600000000", "11111111");
			  
		  }
		  orderDetailPage.checkOrderPage();
		  //if(orderDetailPage.)
	  }
	  catch(Exception ex)
	  {
		  //错误截图
		  AppHelper.takeScreenShoot(driver);  
		  ex.printStackTrace();
	  }
  }
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("setUp");
	  driver=AppHelper.InitializeDriver("D:\\apk\\android_SIT6_test.apk",
			  "ctrip.android.youth","ctrip.android.youth.activity.CtripSplashActivity");
  }

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  //这句不能少，否则缺少截图功能
	  super.afterMethod(result);
	  //driver.quit();
  }

}
