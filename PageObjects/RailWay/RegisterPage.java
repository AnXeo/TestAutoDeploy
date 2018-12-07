package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;
import Objects.Account;


public class RegisterPage extends GeneralPage {
	Account account = new Account();

	// Locators

	private final By txtEmail = By.xpath("//input[@id='email']");
	private final By txtPassword = By.xpath("//input[@id='password']");
	private final By txtCfrPassword = By.xpath("//input[@id='confirmPassword']");
	private final By btnRegister = By.xpath("//input[@value='Register']");
	private final By txtPid = By.xpath("//li[@class='pid-number']//input[@id='pid']");
	private final By lbThanksMsg = By.xpath("//div[@id='content']//h1");
	private final By lbVldPass = By.xpath("//li[@class='password']//label[2]");
	private final By lbVldPid = By.xpath("//li[@class='pid-number']//label[2]");
	private final By lbErrorMsg = By.xpath("//div[@id='content']//p[@class='message error']");
	
	private final By lblSuccessfullyMsg = By.xpath("//div[@id='content']/p");

	// Elements

	public WebElement getTxtEmail() {
		return Constant.WEBDRIVER.findElement(txtEmail);
	}

	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(txtPassword);
	}

	public WebElement getTxtCfrPassword() {
		return Constant.WEBDRIVER.findElement(txtCfrPassword);
	}

	public WebElement getBtnRegister() {
		return Constant.WEBDRIVER.findElement(btnRegister);
	}

	public WebElement getTxtPid() {
		return Constant.WEBDRIVER.findElement(txtPid);
	}

	public WebElement getLbThanksMsg() {
		return Constant.WEBDRIVER.findElement(lbThanksMsg);

	}

	public WebElement getLbVldPass() {
		return Constant.WEBDRIVER.findElement(lbVldPass);
	}

	public WebElement getLbVldPid() {
		return Constant.WEBDRIVER.findElement(lbVldPid);
	}

	public WebElement getLbErrorMsg() {
		return Constant.WEBDRIVER.findElement(lbErrorMsg);
	}
	
	public WebElement getLblSuccessfullyMsg() {
		return Constant.WEBDRIVER.findElement(lblSuccessfullyMsg);
	}

	// Methods

	public Account getRandomAccount() {
		account.initRandomAccount();
		return account;
	}

	public RegisterPage createNewAccount(Account account) {
		this.getTxtEmail().sendKeys(account.getEmail());
		this.getTxtPassword().sendKeys(account.getPassword());
		this.getTxtCfrPassword().sendKeys(account.getCfrPassword());
		this.getTxtPid().sendKeys(account.getPid());
		this.getBtnRegister().click();

		return new RegisterPage();
	}

	public String getTextLbThanksMsg() {
		return this.getLbThanksMsg().getText();
	}

	public String getTextLbVldPass() {
		return this.getLbVldPass().getText();
	}

	public String getTextLbVldPid() {
		return this.getLbVldPid().getText();
	}

	public String getTextLbErrorMsg() {
		return this.getLbErrorMsg().getText();
	}
	
	public RegisterPage activateAccount(String prefix , String accountEmail)  {
		String activateURL = Common.CheckingMails.check(prefix, accountEmail);
		Constant.WEBDRIVER.get(activateURL);
		return new RegisterPage();
	}
	
	public String getTextLblSuccessfullyMsg()
	{
		return this.getLblSuccessfullyMsg().getText();
	}

}
