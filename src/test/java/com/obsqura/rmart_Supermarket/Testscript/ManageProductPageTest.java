package com.obsqura.rmart_Supermarket.Testscript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.obsqura.rmart_Supermarket.pages.HomePage;
import com.obsqura.rmart_Supermarket.pages.LoginPage;
import com.obsqura.rmart_Supermarket.pages.ManageProductPage;
import com.obsqura.rmat_utilities.ExcelUtility;

public class ManageProductPageTest extends Base
{
	public LoginPage loginpage;
	public HomePage homepage;
	public ManageProductPage manageproduct;
	
  @Test
  public void verifyThatUserCanSearchProduct() throws Exception {
		LoginPage loginpage = new LoginPage(driver);
		String username = ExcelUtility.readName(1, 0, "Productpage");
		String password = ExcelUtility.readName(1, 1, "Productpage");
		loginpage.enterUsernameAndPassword(username,password);
		homepage = loginpage.clickOnSignin();
		manageproduct = homepage.clickOnManageProduct();
		String title = ExcelUtility.readName(1, 2, "Productpage");
		String pcode = ExcelUtility.readName(1, 3, "Productpage");
		String pcategory = ExcelUtility.readName(1, 4, "Productpage");
		String psubcategory = ExcelUtility.readName(1, 5, "Productpage");
		manageproduct.clickonSearch().enterTitleAndProductCode(title,pcode).selectCategory(pcategory).selectSubCategory(psubcategory).clickOnSearchButton();
		boolean tableappear = manageproduct.isTableHeaderAppears();
		Assert.assertTrue(tableappear, "Search not happening");
  }
}
