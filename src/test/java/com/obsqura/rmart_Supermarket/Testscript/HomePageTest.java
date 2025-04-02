package com.obsqura.rmart_Supermarket.Testscript;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart.constant.Constant;
import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmat_utilities.ExcelUtility;

public class HomePageTest extends Base{
	public LoginPage loginpage;
	public HomePage homepage;
	
  @Test
  public void verifyThatUserCanLogoutAfterLoginToTheApplication() throws Exception {
	  LoginPage loginpage = new LoginPage(driver);
	  String username = ExcelUtility.readName(1, 0, "Homepage");
	  String password = ExcelUtility.readName(1, 1, "Homepage");
	  loginpage.enterUsernameAndPassword(username,password);
	  homepage = loginpage.clickOnSignin();
	  homepage.clickOnAdminUser().clickOnLogOut();
	  String expected = "Login | 7rmart supermarket";
	  String actual = driver.getTitle();
	  System.out.println(actual);
	  Assert.assertEquals(actual, expected, Constant.ERRORMESSAGEWHENLOGOUTFAILEDHOMEPAGE);
  }
}
