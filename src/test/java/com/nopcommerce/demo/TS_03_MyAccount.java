package com.nopcommerce.demo;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;

public class TS_03_MyAccount extends BaseTest {
	WebDriver driver;
	LoginPageObject loginPage;
	HomePageObject homePage;
	MyAccountPageObject myAccountPage;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.get("https://demo.nopcommerce.com/customer/info");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

//  TC_01: Ở tab Customer Info, update thông tin của Customer, save lại
	@Test
	public void TC_01_updateCustomerInfo() {
		loginPage = new LoginPageObject(driver);
		loginPage.refreshCurrentPage(driver);
		loginPage.enterToEmailTextbox(GlobalConstants.username);
		loginPage.enterToPasswordTextbox(GlobalConstants.password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
		myAccountPage = homePage.clickMyAccountLink();
		
		Assert.assertTrue(myAccountPage.isPageTitle("My account - Customer info"));
		myAccountPage.enterToFirstNameTextbox("Huy");
		myAccountPage.enterToLastNameTextbox("Huy");
		myAccountPage.enterToEmailTextbox(GlobalConstants.username);
		myAccountPage.clickToSaveButton();
		
		Assert.assertEquals(myAccountPage.getFirstNameValue("value"), "Huy");
		
		sleepInSecond(3);
	}
	
	@Test
    public void TC_02_updateAddressMyAccount() {
        myAccountPage.clickToAddressTab();
        Assert.assertTrue(myAccountPage.isPageTitle("My account - Addresses"));
        Assert.assertTrue(myAccountPage.isAddressNoDataMessage("No addresses"));
        myAccountPage.clickToAddAddressButton();
        Assert.assertTrue(myAccountPage.isPageTitle("My account - Add new address"));
        
        myAccountPage.enterToAddressFirstNameTextbox("Huy");
        myAccountPage.enterToAddressLastNameTextbox("Huy");
        myAccountPage.enterToAddressEmailTextbox(GlobalConstants.username);
        myAccountPage.enterToCountryDropdown("Viet Nam");
        myAccountPage.enterToAddressCityTextbox("Ha Noi");
        myAccountPage.enterToAddress1Textbox("Ha Noi");
        myAccountPage.enterToAddressZipTextbox("100000");
        myAccountPage.enterToAddressPhoneNumberTextbox("12345678");
        myAccountPage.clickToAddressSaveButton();
        myAccountPage.clickToAddressEditButton();
        
        Assert.assertEquals(myAccountPage.getAddressFirstNameValue("value"), "Huy");
        Assert.assertEquals(myAccountPage.getAddressLastNameValue("value"), "Pham");
        Assert.assertEquals(myAccountPage.getAddressCityValue("value"),"Ha Noi");
        Assert.assertEquals(myAccountPage.getAddressEmailValue("value"),GlobalConstants.username);
        sleepInSecond(3);
    }
	
	@Test
    public void TC_03_changePasswordMyAccount() {
		myAccountPage.clickToChangePasswordTab();
		Assert.assertTrue(myAccountPage.isPageTitle("My account - Change password"));
		myAccountPage.enterToOldPasswordTextbox(GlobalConstants.password);
		myAccountPage.enterToNewPasswordTextbox(GlobalConstants.new_password);
		myAccountPage.enterToConfirmNewPasswordTextbox(GlobalConstants.new_password);
		myAccountPage.clickToChangePasswordButton();
		Assert.assertTrue(myAccountPage.isBarNotificationMessage("Password was changed"));
		myAccountPage.clickBarNotificationCloseButton();
		
		homePage = myAccountPage.clickLogOutButton();
		loginPage = homePage.clickLogInLink();
		loginPage.enterToEmailTextbox(GlobalConstants.username);
		loginPage.enterToPasswordTextbox(GlobalConstants.new_password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertEquals(homePage.getPageUrl(driver), "https://demo.nopcommerce.com/");
	}
}
