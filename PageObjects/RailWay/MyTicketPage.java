package RailWay;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.Utilities;
import Constant.Constant;
import Objects.Ticket;

public class MyTicketPage extends GeneralPage {

	// Locators

	private final By lblTitle = By.xpath("//div[@id='content']/h1");
	private final By btnCancel = By
			.xpath("//table[@class='MyTable']//tr[2]/td[count(//th[text()='Operation']/preceding-sibling::th) + 1]");
	private final By txtDepartStationValue = By.xpath(
			"//table[@class='MyTable']//tr[2]/td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1]");
	private final By txtArriveStationValue = By.xpath(
			"//table[@class='MyTable']//tr[2]/td[count(//th[text()='Arrive Station']/preceding-sibling::th) + 1]");
	private final By txtSeatTypeValue = By
			.xpath("//table[@class='MyTable']//tr[2]/td[count(//th[text()='Seat Type']/preceding-sibling::th) + 1]");
	private final By txtDepartDateValue = By
			.xpath("//table[@class='MyTable']//tr[2]/td[count(//th[text()='Depart Date']/preceding-sibling::th) + 1]");
	private final By txtTicketAmountValue = By
			.xpath("//table[@class='MyTable']//tr[2]/td[count(//th[text()='Amount']/preceding-sibling::th) + 1]");

	private final By cbbDepartStation = By.xpath("//select[@name='FilterDpStation']");

	private final By btnApplyFilter = By.xpath("//div[@class='Filter']//input[@type='submit']");

	private final By lblDepartStations = By
			.xpath("//table[@class='MyTable']//td[count(//th[text()='Depart Station']/preceding-sibling::th) + 1]");

	private final By txtDepartDate = By.xpath("//div[@class='Filter']//input[@name='FilterDpDate']");

	private final By lblErrorMsg = By.xpath("//div[@class='error message']");

	// Elements
	protected WebElement getLblTitle() {
		return Constant.WEBDRIVER.findElement(lblTitle);
	}

	protected WebElement getBtnCancel() {
		return Constant.WEBDRIVER.findElement(btnCancel);
	}

	protected WebElement getTxtDepartDate() {
		return Constant.WEBDRIVER.findElement(txtDepartDateValue);
	}

	protected WebElement getTxtDepartStation() {
		return Constant.WEBDRIVER.findElement(txtDepartStationValue);
	}

	protected WebElement getTxtArriveStation() {
		return Constant.WEBDRIVER.findElement(txtArriveStationValue);
	}

	protected WebElement getTxtSeatType() {
		return Constant.WEBDRIVER.findElement(txtSeatTypeValue);
	}

	protected WebElement getTxtTicketAmount() {
		return Constant.WEBDRIVER.findElement(txtTicketAmountValue);
	}

	protected WebElement getCbbDepartStation() {
		return Constant.WEBDRIVER.findElement(cbbDepartStation);
	}

	protected WebElement getBtnApplyFilter() {
		return Constant.WEBDRIVER.findElement(btnApplyFilter);
	}

	protected WebElement getLblDepartStations() {
		return Constant.WEBDRIVER.findElement(lblDepartStations);
	}

	protected WebElement getTxtDepartDateForFilter() {
		return Constant.WEBDRIVER.findElement(txtDepartDate);
	}

	protected WebElement getLblErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg);
	}

	// Methods
	public boolean isMyTicketTabDisplayed() {

		boolean isTabSelected = getClassOfMyTicket().equalsIgnoreCase("selected");
		boolean isTitleDisplayCorrectly = getLblTitle().getText().equalsIgnoreCase("Manage ticket");
		boolean isUrlDisplayedCorrectly = Utilities.getCurrentUrl().equalsIgnoreCase(Constant.MyTicketTab_URL);
		return (isTabSelected == true && isTitleDisplayCorrectly == true && isUrlDisplayedCorrectly == true);

	}

	public MyTicketPage cancelTicket() {
		this.getBtnCancel().click();
		Utilities.confirmMessage();
		return new MyTicketPage();
	}

	public boolean isCancelTicketDisappeared(Ticket ticket) {
		boolean departDate = this.getTxtDepartDate().getText().equalsIgnoreCase(ticket.getDepartDate());
		boolean departStation = this.getTxtDepartStation().getText().equalsIgnoreCase(ticket.getDepartStation());
		boolean arriveStation = this.getTxtArriveStation().getText().equalsIgnoreCase(ticket.getArriveAt());
		boolean seatType = this.getTxtSeatType().getText().equalsIgnoreCase(ticket.getSeatType());
		boolean ticketAmount = this.getTxtTicketAmount().getText()
				.equalsIgnoreCase(Integer.toString(ticket.getAmount()));
		return (departDate == true && departStation == true && arriveStation == true && seatType == true
				&& ticketAmount == true);
	}

	public MyTicketPage filter(String value) {
		value = getDepartStationForFilter();
		Select selectDepartDate = new Select(this.getCbbDepartStation());
		selectDepartDate.selectByVisibleText(value);
		getBtnApplyFilter().click();
		return new MyTicketPage();
	}

	public String getTextDepartStation() {
		return this.getTxtDepartStation().getText().trim();
	}

	public int getAmountOfStations() {
		return Constant.WEBDRIVER.findElements(lblDepartStations).size();
	}

	public String getDepartStationForFilter() {

		Select select = new Select(getCbbDepartStation());
		List<WebElement> options = select.getOptions();
		int index = Utilities.randBetween(1, options.size() - 1);
		return options.get(index).getText();
	}

	public String getTextLblDepartStations() {
		return getLblDepartStations().getText();
	}

	public boolean isValueOfDepartStationsCorrect(String value) {

		List<WebElement> list = Constant.WEBDRIVER.findElements(lblDepartStations);
		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).getText().equalsIgnoreCase(value) == false)
				return false;
		}
		return true;
	}

	public MyTicketPage filterFollowDepartDate(String departDate) {
		this.getTxtDepartDateForFilter().sendKeys(departDate);
		this.getBtnApplyFilter().click();
		return new MyTicketPage();
	}

	public String getTextLblErrorMsg() {
		return getLblErrorMsg().getText().trim();
	}

}
