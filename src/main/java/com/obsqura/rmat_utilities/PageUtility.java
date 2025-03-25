package com.obsqura.rmat_utilities;

import java.awt.AWTException;
import java.awt.Robot;
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
	public void selectByIndex(WebElement element,int num)
	{
		Select select = new Select(element);
		select.selectByIndex(num);
	}
	public void selectByValue(WebElement element,String text)
	{
	Select select = new Select(element);
	select.selectByValue(text);
	}
	public void javaScriptExceutor(WebDriver driver,WebElement element)
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0,150000)");
	}
	public void roboClass(WebDriver driver,WebElement element) throws AWTException
	{
		StringSelection selection = new StringSelection("C:\\Users\\treas\\OneDrive\\Pictures\\1.1.1.png");//File upload using robot class
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robo = new Robot();
		robo.delay(2000);
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);                                                        
		robo.keyRelease(KeyEvent.VK_ENTER);
	}
	public void actionClass(WebElement dragelt1,WebElement dragelt2)
	{
		Actions actions =new Actions(driver);
		actions.moveToElement(dragelt1);
		actions.doubleClick(dragelt1).perform();
		actions.dragAndDrop(dragelt1, dragelt2).build().perform();
	
	}
	
}
