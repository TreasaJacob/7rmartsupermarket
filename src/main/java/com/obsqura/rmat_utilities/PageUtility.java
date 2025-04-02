package com.obsqura.rmat_utilities;

import java.awt.AWTException;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public WebDriver driver;
	public void selectByVisibleText(WebElement element,String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element,int index)
	{
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectByValue(WebElement element,String text)
	{
	Select select = new Select(element);
	select.selectByValue(text);
	}
	public void javaScriptExceutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,10000)");  //window.scrollBy(0,200000)
	}
	
	public void actionClass(WebElement dragelt1,WebElement dragelt2)  
	{
		Actions actions =new Actions(driver);
		actions.moveToElement(dragelt1);
		actions.doubleClick(dragelt1).perform();
		actions.dragAndDrop(dragelt1, dragelt2).build().perform();
	
	}
	
}
