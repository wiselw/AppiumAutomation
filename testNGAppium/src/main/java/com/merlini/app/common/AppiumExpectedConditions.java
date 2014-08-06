package com.merlini.app.common;

import io.appium.java_client.AppiumDriver;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppiumExpectedConditions {
	private final static Logger log = Logger.getLogger(ExpectedConditions.class.getName());
	private AppiumExpectedConditions() {
		    // Utility class
		  }
	private static WebElement findElement(By by, AppiumDriver driver) {
	    try {
	      return driver.findElement(by);
	    } catch (NoSuchElementException e) {
	      throw e;
	    } catch (WebDriverException e) {
	      log.log(Level.WARNING,
	          String.format("WebDriverException thrown by findElement(%s)", by), e);
	      throw e;
	    }
	  }
	private static WebElement elementIfVisible(WebElement element) {
	    return element.isDisplayed() ? element : null;
	  }
	public static AppiumExpectedCondition<WebElement> visibilityOfElementLocated(
		      final By locator) {
		    return new AppiumExpectedCondition<WebElement>() {
		      @Override
		      public WebElement apply(AppiumDriver driver) {
		        try {
		          return elementIfVisible(findElement(locator, driver));
		        } catch (StaleElementReferenceException e) {
		          return null;
		        }
		      }
		      @Override
		      public String toString() {
		        return "visibility of element located by " + locator;
		      }

		    };
		  }

}
