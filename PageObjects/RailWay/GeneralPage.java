package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class GeneralPage {

	// Locators

	private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
	private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
	private final By lblWelcomeMessage = By.xpath("//div[@class='account']/strong");
	private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
	private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
	private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']//..");
	private final By tabMyTicket = By.xpath("//a[@href='/Page/ManageTicket.cshtml']//..");
	private final By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
	private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");

	// Elements

	protected WebElement getTabLogin() {
		return Constant.WEBDRIVER.findElement(tabLogin);
	}

	protected WebElement getTabLogout() {
		return Constant.WEBDRIVER.findElement(tabLogout);
	}

	protected WebElement getlblWelcomeMessage() {
		return Constant.WEBDRIVER.findElement(lblWelcomeMessage);
	}

	protected WebElement getTabContact() {
		return Constant.WEBDRIVER.findElement(tabContact);
	}

	protected WebElement getTabRegister() {
		return Constant.WEBDRIVER.findElement(tabRegister);
	}

	protected WebElement getTabChangePassword() {
		return Constant.WEBDRIVER.findElement(tabChangePassword);
	}

	protected WebElement getTabMyTicket() {
		return Constant.WEBDRIVER.findElement(tabMyTicket);
	}

	protected WebElement getTabTicketPrice() {
		return Constant.WEBDRIVER.findElement(tabTicketPrice);
	}

	protected WebElement getTabBookTicket() {
		return Constant.WEBDRIVER.findElement(tabBookTicket);
	}

	// Methods

	public LoginPage gotoLoginPage() {
		this.getTabLogin().click();
		return new LoginPage();
	}

	public ContactPage gotoContactPage() {
		this.getTabContact().click();
		return new ContactPage();
	}

	public ChangePasswordPage gotoChangePasswordPage() {
		this.getTabChangePassword().click();
		return new ChangePasswordPage();
	}

	public RegisterPage gotoRegisterPage() {
		this.getTabRegister().click();
		return new RegisterPage();
	}

	public TicketPricePage gotoTicketPricePage() {
		this.getTabTicketPrice().click();
		return new TicketPricePage();
	}

	public MyTicketPage gotoMyTicketPage() {
		this.getTabMyTicket().click();
		return new MyTicketPage();
	}

	public BookTicketPage gotoBookTicketPage() {
		this.getTabBookTicket().click();
		return new BookTicketPage();
	}

	public String getWelcomeMessage() {
		return this.getlblWelcomeMessage().getText();
	}

	public String getTextLogoutTab() {
		return this.getTabLogout().getText();
	}

	public String getClassOfChangePasswordTab() {
		return this.getTabChangePassword().getAttribute("class");
	}

	public String getClassOfMyTicket() {
		return this.getTabMyTicket().getAttribute("class");
	}

	public String getUrlCurrentPage() {
		return Constant.WEBDRIVER.getCurrentUrl();
	}
	
	public boolean isMyTicketTabExists() {
		return getTabMyTicket().isDisplayed();
	}
	
	public boolean isMyChangePasswordTabExists() {
		return getTabChangePassword().isDisplayed();
	}
	
	public boolean isMyLogoutTabExists() {
		return getTabLogout().isDisplayed();
	}

}
