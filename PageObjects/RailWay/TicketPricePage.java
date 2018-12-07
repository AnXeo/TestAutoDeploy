package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class TicketPricePage extends GeneralPage {

	// Locators

	private final String btnBookTicket = "//td[text()='%s']//../following-sibling::td/a";

	// Elements

	protected WebElement getbtnBookTicket(String text) {
		return Constant.WEBDRIVER.findElement(By.xpath(String.format(btnBookTicket, text)));
	}

	// Methods

	public TicketPricePage checkPrice(String departStation, String arriveStation) {

		By btnCheckPrice = By
				.xpath("//li[text()='" + departStation + " to " + arriveStation + "']/../following-sibling::td/a");

		Constant.WEBDRIVER.findElement(btnCheckPrice).click();

		return new TicketPricePage();
	}

	public BookTicketPage bookTicket(String seatType) {
		By btnBookTicket = By.xpath("//td[text()='" + seatType + "']//../following-sibling::td/a");
		Constant.WEBDRIVER.findElement(btnBookTicket).click();
		return new BookTicketPage();
	}

}
