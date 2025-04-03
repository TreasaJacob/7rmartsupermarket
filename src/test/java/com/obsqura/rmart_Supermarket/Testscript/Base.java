package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.annotations.Test;

import com.obsqura.rmat_utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	WebDriver driver;
 
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get("https://groceryapp.uniqassosiates.com/admin/login");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod(ITestResult itResult) throws IOException {
	  if (itResult.getStatus() == ITestResult.FAILURE) {  //ITestResult is an interface //getStatus() is a method in ITestResult interface.
			ScreenshotUtility sc = new ScreenshotUtility();  //name of created java class
			sc.captureFailureScreenShot(driver, itResult.getName());//getName()-to capture name of failed test case
		}
		if (driver != null) {
			driver.quit();
		}
	  
  }

}
