package RailWay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Common.Utilities;
import Constant.Constant;

public class PasswordResetPage extends GeneralPage {
	
	//Locators
	private final By txtNewPassword = By.xpath("//input[@id='newPassword']");
	private final By txtCfrPassword = By.xpath("//li[@class='confirm-password']//input[@id='confirmPassword']");
	private final By txtResetToken = By.xpath("//li[@class='reset-token']//input[@id='resetToken']");
	private final By btnResetPassword = By.xpath("//p[@class='form-actions']//input[@type='submit']");
	private final By lblSuccessMsg = By.xpath("//div[@id='content']//p[@class='message success']");
	private final By lblErrorMsg = By.xpath("//div[@id='content']//p[@class='message error']");
	private final By lblTitleForm = By.xpath("//form[@method='post']//legend");
	private final By lblErrorValidationCfrPass = By.xpath("//li[@class='confirm-password']//label[@class='validation-error']");
	
	
	
	//Elements
	protected WebElement getTxtNewPassword() {
		return Constant.WEBDRIVER.findElement(txtNewPassword);
	}
	
	protected WebElement getTxtCfrPassword() {
		return Constant.WEBDRIVER.findElement(txtCfrPassword);
	}
	
	protected WebElement getBtnCfrPassword() {
		return Constant.WEBDRIVER.findElement(btnResetPassword);
	}
	
	protected WebElement getLblSuccessMsg() {
		return Constant.WEBDRIVER.findElement(lblSuccessMsg);
	}

	protected WebElement getLblErrorMsg() {
		return Constant.WEBDRIVER.findElement(lblErrorMsg);
	}
	
	protected WebElement getLblTitleForm() {
		return Constant.WEBDRIVER.findElement(lblTitleForm);
	}
	
	protected WebElement getTxtResetToken() {
		return Constant.WEBDRIVER.findElement(txtResetToken);
	}
	
	protected WebElement getLblErrorValidationCfrPass() {
		return Constant.WEBDRIVER.findElement(lblErrorValidationCfrPass);
	}
	
	
	//Methods 
	
	public PasswordResetPage changePassword(String newPass, String cfrPass ,String token) {
		this.getTxtNewPassword().sendKeys(newPass);
		this.getTxtCfrPassword().sendKeys(cfrPass);		
		this.getTxtResetToken().clear();
		this.getTxtResetToken().sendKeys(token);
		this.getBtnCfrPassword().click();
		return  this;
	}
	
	public PasswordResetPage activeResetPassLink(String prefix , String accountEmail) {
//		prefix = "Please reset your password ";
		String activateURL = Common.CheckingMails.check(prefix, accountEmail);
		Constant.WEBDRIVER.get(activateURL);
		return this;
	}
	
	public String getTextToken() {
		return this.getTxtResetToken().getText();
	}
	
	public String getTextLblSuccessMsg() {
		return this.getLblSuccessMsg().getText();
	}
	
	public String getTextErrorMsg() {
		return this.getLblErrorMsg().getText();
	}
	
	public boolean isChangePassFormDisplayed(String prefix , String accountEmail) {
		String url = "http://"+Utilities.getCurrentUrl();
		boolean isTitleDisplayCorrectly = getLblTitleForm().getText().equalsIgnoreCase("Password Change Form");
		boolean isUrlDisplayedCorrectly = url.equalsIgnoreCase(Common.CheckingMails.check(prefix, accountEmail));
		return (isTitleDisplayCorrectly == true && isUrlDisplayedCorrectly == true);
	}
	
	public String getTextLblErrorValidationCfrPass() {
		return this.getLblErrorValidationCfrPass().getText();
	}
	

}
