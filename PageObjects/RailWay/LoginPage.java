package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Constant.Constant;

public class LoginPage extends GeneralPage {

	// Locators

	private final By _txtUsername = By.xpath("//input[@id='username']");
	private final By _txtPassword = By.xpath("//input[@id='password']");
	private final By _btnLogin = By.xpath("//input[@value='login']");
	private final By _lblLoginSuccessfullyMsg = By.xpath("//div[@class='account']");
	private final By lblErrorMessage = By.xpath("//div[@id='content']/p[@class='message error LoginForm']");
	private final By linkChangePassword = By.xpath("//a[@href='/Account/ForgotPassword.cshtml']");
	private final By txtEmailChangePassword = By.xpath("//li[@class='email']//input[@id='email']");
	private final By btnSenIntructions = By.xpath("//p[@class='form-actions']//input[@type='submit']");
	

	// Elements

	public WebElement getTxtUsername() {
		return Constant.WEBDRIVER.findElement(_txtUsername);
	}

	public WebElement getTxtPassword() {
		return Constant.WEBDRIVER.findElement(_txtPassword);
	}

	public WebElement getBtnLogin() {
		return Constant.WEBDRIVER.findElement(_btnLogin);
	}

	public WebElement getLblLoginSuccessfullyMsg() {
		return Constant.WEBDRIVER.findElement(_lblLoginSuccessfullyMsg);
	}

	protected WebElement getlblErrorMessage() {
		return Constant.WEBDRIVER.findElement(lblErrorMessage);
	}

	protected WebElement getLinkChangePassword() {
		return Constant.WEBDRIVER.findElement(linkChangePassword);
	}

	protected WebElement getTxtEmailChangePassword() {
		return Constant.WEBDRIVER.findElement(txtEmailChangePassword);
	}

	protected WebElement getBtnSenIntructions() {
		return Constant.WEBDRIVER.findElement(btnSenIntructions);
	}
	
	

	// Methods

	public HomePage loginSuccessfully(String username, String password) {
		// Submit login credentials
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		// Land on Home page
		return new HomePage();
	}

	public LoginPage loginExpectingError(String username, String password) {
		// Submit login credentials
		this.getTxtUsername().sendKeys(username);
		this.getTxtPassword().sendKeys(password);
		this.getBtnLogin().click();
		// Land on Home page
		return this;
	}

	public String getErrorMessageForLoginFailed() {
		return this.getlblErrorMessage().getText();
	}
	
	public PasswordResetPage getLinkResetPassword(String email) {
		
		this.getLinkChangePassword().click();
		this.getTxtEmailChangePassword().sendKeys(email);
		this.getBtnSenIntructions().click();
		return new PasswordResetPage();
	}
	
	

}
