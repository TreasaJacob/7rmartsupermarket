package com.obsqura.rmart_Supermarket.Testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;

public class HomePageTest extends Base{
	public LoginPage loginpage;
	public HomePage homepage;
	
  @Test
  public void verifyThatUserCanLogoutAfterLoginToTheApplication() {
	  LoginPage loginpage = new LoginPage(driver);
	  loginpage.enterUsernameAndPassword("admin","admin");
	  homepage = loginpage.clickOnSignin();
	  homepage.clickOnAdminUser().clickOnLogOut();
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEWHENLOGOUTFAILEDHOMEPAGE);
  }
}
