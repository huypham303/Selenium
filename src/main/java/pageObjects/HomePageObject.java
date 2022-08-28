package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
	WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
	}
	
	public void clickDynamicLink(String value){
		waitForElementClickable(driver, HomePageUI.DYNAMIC_LINK, value);
		clickToElement(driver, HomePageUI.DYNAMIC_LINK, value);
	}
	
	public MyAccountPageObject clickMyAccountLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return new MyAccountPageObject(driver);
	}
	
	public LoginPageObject clickLogInLink() {
		waitForElementClickable(driver, HomePageUI.LOG_IN_LINK);
		clickToElement(driver, HomePageUI.LOG_IN_LINK);
		return new LoginPageObject(driver);
	}
}
