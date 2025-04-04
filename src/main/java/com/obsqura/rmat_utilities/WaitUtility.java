package com.obsqura.rmat_utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.obsqura.rmart.constant.Constant;

public class WaitUtility 
{
public WebDriver driver;
public void elementToBeClickable(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

public void visibilityOf(WebDriver driver,WebElement element)
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
wait.until(ExpectedConditions.visibilityOf(element));

}
public void invisibilityOf(WebDriver driver,WebElement element)
{
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(ExpectedConditions.invisibilityOf(element));

}
public void elementToBeSelected(WebDriver driver,WebElement element)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.elementToBeSelected(element));
	
}
public void titleContains(WebDriver driver,String title)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.titleContains(title));
	
}
}
