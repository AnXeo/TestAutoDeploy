package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class ChangePasswordPage extends GeneralPage {

	// Locators
	private final By lblChangePassword = By.xpath("//div[@id='content']/h1");


	// Elements

	protected WebElement getLblChangePassword() {
		return Constant.WEBDRIVER.findElement(lblChangePassword);
	}

	

	// Methods
	public boolean isChangePassWordTabDisplayed() {

		boolean isTabSelected = getClassOfChangePasswordTab().equalsIgnoreCase("selected");
		boolean isTitleDisplayCorrectly = getLblChangePassword().getText().equalsIgnoreCase("Change password");
		boolean isUrlDisplayedCorrectly = Utilities.getCurrentUrl().equalsIgnoreCase(Constant.ChangePasswordTab_URL);
		return (isTabSelected == true && isTitleDisplayCorrectly == true && isUrlDisplayedCorrectly == true);

	}

	

}
