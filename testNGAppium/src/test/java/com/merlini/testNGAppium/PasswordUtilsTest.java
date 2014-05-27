package com.merlini.testNGAppium;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class PasswordUtilsTest {
  @Test(enabled=false)
  public void f() throws SQLException {
	  try {
          Connection con;
          Statement stmt;
          ResultSet rs;
          Class.forName("net.sourceforge.jtds.jdbc.Driver");
          DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
          String dbUrl = "jdbc:jtds:sqlserver://192.168.81.16:55944/ATDataBase;user=uapp_autotest;passWord=1qaz@wsx";
          //String dbUrl = "jdbc:jtds:sqlserver://fathoteldb.qa.nt.ctripcorp.com,55888/ProductDB;user=weiliang ;passWord=lws1qaz@WSX ";
          con = java.sql.DriverManager.getConnection(dbUrl);
          stmt = con.createStatement();
          rs = stmt.executeQuery("SELECT *FROM dbo.CI_API_Call");
          while (rs.next()) {
              System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
          }

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
  @Test
  public void DBUtilTest() throws SQLException
  {
	  String sql="SELECT *FROM dbo.CI_API_Call";
	  ResultSet rs=DBUtil.getResultSet(sql);
	  while (rs.next()) {
          System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
      }
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
