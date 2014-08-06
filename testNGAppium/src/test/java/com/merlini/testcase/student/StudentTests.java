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
		  //��ҳ
		  GoTravelPage goTravelPage=new GoTravelPage(driver);
		  //�Ƶ���ҳ
		  HotelSearchPage hotelSearchPage=new HotelSearchPage(driver);
		  //�Ƶ��б�ҳ
		  HotelListPage hotelListPage=new HotelListPage(driver);
		  //ɸѡҳ
		  FilterPage filterPage =new FilterPage(driver);
		  //�Ƶ�����ҳ
		  HotelDetailPage hotelDetailPage=new HotelDetailPage(driver);
		  //��������ҳ
		  OrderDetailPage orderDetailPage=new OrderDetailPage(driver);
		  goTravelPage.navigateTo("ȥ����");
		  goTravelPage.nextToHotel();
		  hotelSearchPage.clickMyPosition();
		  hotelSearchPage.clickSearchButton();
		  hotelListPage.navigateToFilter();
		  filterPage.setPayMethod("���긶��(�Ƶ�ǰ̨����)");
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
		  //�����ͼ
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
	  //��䲻���٣�����ȱ�ٽ�ͼ����
	  super.afterMethod(result);
	  //driver.quit();
  }

}
