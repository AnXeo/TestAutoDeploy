package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class ContactPage extends GeneralPage {

	// Locators

	private final By eleEmailAddress = By.xpath("//div[@class='contact']//a[1]");

	// Elements

	public WebElement getEleEmailAddress() {
		return Constant.WEBDRIVER.findElement(eleEmailAddress);
	}

	// Methods

	public String getAttributeHref() {
		return this.getEleEmailAddress().getAttribute("href");
	}

}
