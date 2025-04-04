package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmat_utilities.ScreenshotUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Base {
	public Properties properties;
	public FileInputStream fis;
	WebDriver driver;
  @Parameters("Browser")
  @BeforeMethod(alwaysRun = true)
  public void beforeMethod(String browzer) throws Exception {
	  try {
			properties = new Properties();
			fis = new FileInputStream(Constant.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browzer.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browzer.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (browzer.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
	  //driver = new ChromeDriver();
	  //driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.get(properties.getProperty("url"));  //properties->globally declared object.
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod(alwaysRun = true)
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
