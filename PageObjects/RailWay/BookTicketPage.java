package RailWay;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import Common.Utilities;
import Constant.Constant;
import Objects.Ticket;
import RailWay.BookSuccessfullyPage;

public class BookTicketPage extends GeneralPage {

	// Locators
	private final By cbbDepartDate = By.xpath("//select[@name='Date']");
	private final By cbbDepartFrom = By
			.xpath("//select[@name='DepartStation']");
	private final By cbbAriveAt = By.xpath("//select[@name='ArriveStation']");
	private final By cbbSeatTypet = By.xpath("//select[@name='SeatType']");
	private final By cbbTicketAmount = By
			.xpath("//form[@method='post']//select[@name='TicketAmount']");
	private final By btnBookTicket = By
			.xpath("//form[@method='post']//input[@type='submit']");
	private final By lblErrorMsg = By
			.xpath("//div[@id='content']//p[@class='message error']");
	private final By vldErrorAmount = By
			.xpath("//select[@name='TicketAmount']//following-sibling::label");

	// Elements

	protected WebElement getCbbDepartDate() {
		return Constant.WEBDRIVER.findElement(cbbDepartDate);
	}

	protected WebElement getCbbDepartFrom() {
		return Constant.WEBDRIVER.findElement(cbbDepartFrom);
	}

	protected WebElement getCbbAriveAt() {
		return Constant.WEBDRIVER.findElement(cbbAriveAt);
	}

	protected WebElement getCbbSeatTypet() {
		return Constant.WEBDRIVER.findElement(cbbSeatTypet);
	}

	protected WebElement getCbbTicketAmount() {
		return Constant.WEBDRIVER.findElement(cbbTicketAmount);
	}

	protected WebElement getBtnBookTicket() {
		return Constant.WEBDRIVER.findElement(btnBookTicket);
	}

	protected WebElement getLblErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg);
	}

	protected WebElement getVldErrorAmount() {
		return Constant.WEBDRIVER.findElement(vldErrorAmount);
	}

	// Methods

	public BookSuccessfullyPage bookTicketSuccessfully(Ticket ticket) {
		// select deapart stations
		Select selectDepartFrom = new Select(this.getCbbDepartFrom());
		selectDepartFrom.selectByVisibleText(ticket.getDepartFrom());

		// Select depart date
		Select selectDepartDate = new Select(this.getCbbDepartDate());
		selectDepartDate.selectByVisibleText(ticket.getDepartDate());

		// select seat type
		Select selectSeatTypet = new Select(this.getCbbSeatTypet());
		selectSeatTypet.selectByVisibleText(ticket.getSeatType());

		// select amount
		Select selectTicketAmount = new Select(this.getCbbTicketAmount());
		selectTicketAmount.selectByVisibleText(Integer.toString(ticket
				.getAmount()));

		Utilities.waitForElement(cbbAriveAt);
		// selct arrive station
		Select selectAriveAt = new Select(this.getCbbAriveAt());
		selectAriveAt.selectByVisibleText(ticket.getArriveAt());

		this.getBtnBookTicket().click();
		return new BookSuccessfullyPage();

	}

	public BookTicketPage bookTicketExistError(Ticket ticket) {

		Select selectDepartFrom = new Select(this.getCbbDepartFrom());
		selectDepartFrom.selectByVisibleText(ticket.getDepartFrom());

		Select selectDepartDate = new Select(this.getCbbDepartDate());
		selectDepartDate.selectByVisibleText(ticket.getDepartDate());

		Select selectSeatTypet = new Select(this.getCbbSeatTypet());
		selectSeatTypet.selectByVisibleText(ticket.getSeatType());

		Select selectTicketAmount = new Select(this.getCbbTicketAmount());
		selectTicketAmount.selectByVisibleText(Integer.toString(ticket
				.getAmount()));

		Utilities.waitForElement(cbbAriveAt);

		Select selectAriveAt = new Select(this.getCbbAriveAt());
		selectAriveAt.selectByVisibleText(ticket.getArriveAt());

		this.getBtnBookTicket().click();

		return new BookTicketPage();

	}

	public static String getBookDate() {
		return Utilities.getCurrentDate();
	}

	public static String getDepartDate(int instance) {

		SimpleDateFormat formatDate = new SimpleDateFormat("M/dd/yyyy");
		Date date = new Date();

		try {
			date = formatDate.parse(getBookDate());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, instance);
		date = cal.getTime();
		return formatDate.format(date);
	}

	public String getTextLblErrorMsg() {
		return this.getLblErrorMsg().getText();
	}

	public String getTextVldErrorAmount() {
		return this.getVldErrorAmount().getText();
	}

	public String getDepartDate() {
		Select selectDate = new Select(getCbbDepartDate());
		return selectDate.getFirstSelectedOption().getText();
	}

	public String getDepartStation() {
		Select selectDepartStation = new Select(getCbbDepartFrom());
		return selectDepartStation.getFirstSelectedOption().getText();
	}

	public String getArriveStation() {
		Select selectArriveStation = new Select(getCbbAriveAt());
		return selectArriveStation.getFirstSelectedOption().getText();
	}

	public String getSeatType() {
		Select selectSeatType = new Select(getCbbSeatTypet());
		return selectSeatType.getFirstSelectedOption().getText();
	}

	public String getTicketAmount() {
		Select selectTicketAmount = new Select(getCbbTicketAmount());
		return selectTicketAmount.getFirstSelectedOption().getText();
	}

}
