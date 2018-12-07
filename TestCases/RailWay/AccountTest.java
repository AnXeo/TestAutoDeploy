package RailWay;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Common.AccountHelper;
import Common.Utilities;
import Constant.Messages;
import Objects.Account;

public class AccountTest extends BaseTest {

	@Test
	public void TC07() {
		System.out.println("User can create new account");

		// 1. Navigate to QA Railway Website
		// 2. Click on "Register" tab
		// 3. Enter valid information into all fields
		// 4. Click on "Register" button

		Account account = new Account();
		account.initRandomAccount();
		HomePage homePage = new HomePage();
		RegisterPage registerPage = new RegisterPage();

		// Create new account
		registerPage = homePage.open().gotoRegisterPage().createNewAccount(account);

		// Verify message "Thank you for registering your account" is displayed.
		assertEquals(registerPage.getTextLbThanksMsg(), Messages.thanksMsgForRegisterSuccessfully,
				" Thanks you message is not displayed as expected");
	}

	@Test
	public void TC09() {
		System.out.println("User can reset password successfully");

		// Pre-condition: Create and activate a new account
		// 1. Navigate to QA Railway Website
		// 2. Click on "Forgot Password page" link
		// 3. Enter the email address of the created account in Pre-condition
		// 4. Click on "Send Instructions" button
		// 5. Navigate to mailbox and open the Please reset your password email
		// 6. Click on the reset password link
		// 7. Enter a new password for both password fields
		// 8. Click "Reset Password" button
		// 9. Login with new password

		HomePage homePage = new HomePage();
		ConfirmPage confirmPage = new ConfirmPage();
		PasswordResetPage passwordResetPage = new PasswordResetPage();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account
		AccountHelper.activateAccount(account.getEmail());

		// Get link reset password
		passwordResetPage = confirmPage.gotoLoginPage().getLinkResetPassword(account.getEmail());

		// Verify Message successfully is displayed .
		assertEquals(passwordResetPage.getTextLblSuccessMsg(),
				"Instructions to reset your password have been sent to\"lgtrainrailway@gmail.com\".",
				"Message is not displayed as expected");

		// Open mailbox and click on reset password link
		AccountHelper.activeResetPassLink(account.getEmail());

		String newPass = Utilities.randomPassword();
		String token = passwordResetPage.getTextToken();

		passwordResetPage.changePassword(newPass, newPass, token);

		// Verify Message "Password changed! Click here to login." displays.
		assertEquals(passwordResetPage.getTextLblSuccessMsg(), "Password changed! Click here to login.",
				"Message is not displayed as expected ");

		// Login with new password
		homePage = passwordResetPage.gotoLoginPage().loginSuccessfully(account.getEmail(), newPass);

		// Verify Welcome user message is displayed.
		assertEquals(homePage.getWelcomeMessage(), "Welcome " + account.getEmail(),
				"Message is not displayed as expected ");
	}

	@Test
	public void TC10() {
		System.out.println("User can't reset password if enter incorrect email address");

		// 1. Navigate to QA Railway Website
		// 2. Click on "Forgot Password page" link
		// 3. Enter an un-existing email address
		// 4. Click on "Send Instructions" button

		Account account = new Account();
		account.initRandomAccount();
		HomePage homePage = new HomePage();
		PasswordResetPage passwordResetPage = new PasswordResetPage();

		// Enter an un-existing email address then click on "Send Instructions" button
		passwordResetPage = homePage.open().gotoLoginPage().getLinkResetPassword(account.getEmail());

		// Verify Error message "This email address doesn't exist." displays.
		assertEquals(passwordResetPage.getTextErrorMsg(), "This email address doesn't exist.",
				"Message is not displayed as expected ");
	}

	@Test
	public void TC11() {

		System.out.println("User can't create account while password and PID fields are empty");

		// 1. Navigate to QA Railway Website
		// 2. Click on "Register" tab
		// 3. Enter valid email address and leave other fields empty
		// 4. Click on "Register" button

		HomePage homePage = new HomePage();
		RegisterPage registerPage = new RegisterPage();
		Account account = new Account();
		account.initRandomAccount();
		account.setPassword("");
		account.setCfrPassword("");
		account.setPid("");

		// Enter valid email address and leave other fields empty then click on
		// "Register" button
		registerPage = homePage.open().gotoRegisterPage().createNewAccount(account);

		// Verify Message "There're errors in the form. Please correct the errors and
		// try again." appears above the form.
		assertEquals(registerPage.getTextLbErrorMsg(), Messages.errorMsgForRegisterFailed,
				"Error message is not displayed as expected");

		// Next to password fields, error message "Invalid password length." displays
		assertEquals(registerPage.getTextLbVldPass(), Messages.errorValidationForTxtPassword,
				"Validation is not displayed as expected");

		// verify : Next to PID field, error message "Invalid ID length." displays
		assertEquals(registerPage.getTextLbVldPid(), Messages.errorValidationForTxtPid,
				"Validation is not displayed as expected");

	}

	@Test
	public void TC12() {

		System.out.println("Errors display when password reset token is blank");

		// Pre-condition: Create and activate a new account
		// 1. Navigate to QA Railway Login page
		// 2. Click on "Forgot Password page" link
		// 3. Enter the email address of the created account in Pre-condition
		// 4. Click on "Send Instructions" button
		// 5. Open mailbox and click on reset password link
		// 6. Enter new passwords and remove the Password Reset Token
		// 7. Click "Reset Password" button

		HomePage homePage = new HomePage();
		ConfirmPage confirmPage = new ConfirmPage();
		PasswordResetPage passwordResetPage = new PasswordResetPage();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account
		AccountHelper.activateAccount(account.getEmail());

		// Get link reset password
		passwordResetPage = confirmPage.gotoLoginPage().getLinkResetPassword(account.getEmail());

		// Open mailbox and click on reset password link
		AccountHelper.activeResetPassLink(account.getEmail());

		String newPass = Utilities.randomPassword();
		// Enter new passwords and remove the Password Reset Token
		passwordResetPage.changePassword(newPass, newPass, "");

		// Verify error message is displays above the form.
		assertEquals(passwordResetPage.getLblErrorMsg(), Messages.errorForResetPasswordTokenIncorrect);

		// Verify Error message "The password reset token is invalid." displays next to
		// the "Password Reset Token" field.
		//

	}

	@Test
	public void TC13() {
		System.out.println("Errors display if password and confirm password don't match when resetting password");
		
//		Pre-condition: Create and activate a new account
//		1. Navigate to QA Railway Login page
//		2. Click on "Forgot Password page" link
//		3. Enter the email address of the created account in Pre-condition
//		4. Click on "Send Instructions" button
//		5. Open mailbox and click on reset password link
//		6. Enter different values for password fields
//		7. Click "Reset Password" button


		HomePage homePage = new HomePage();
		ConfirmPage confirmPage = new ConfirmPage();
		PasswordResetPage passwordResetPage = new PasswordResetPage();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account
		AccountHelper.activateAccount(account.getEmail());

		// Get link reset password
		passwordResetPage = confirmPage.gotoLoginPage().getLinkResetPassword(account.getEmail());

		// Open mailbox and click on reset password link
		AccountHelper.activeResetPassLink(account.getEmail());

		// Verify "Password Change Form" page displays
		assertTrue(passwordResetPage.isChangePassFormDisplayed("Please reset your password ", account.getEmail()),
				"Password Change Form  is not displays as expected.");

		// In "Password Change form page : Enter different values for password fields

		String newPass = Utilities.randomPassword();
		String token = passwordResetPage.getTextToken();
		passwordResetPage.changePassword(newPass, newPass + "12", token);

		// Verify error message "Could not reset password. Please correct the errors and
		// try again." displays above the form.
		assertEquals(passwordResetPage.getLblErrorMsg(), Messages.errorForResetPasswordFailed,
				"Error message is not displayed as expected");

		// Error message "The password confirmation did not match the new password."
		// displays next to the confirm password field.
		assertEquals(passwordResetPage.getTextLblErrorValidationCfrPass(),
				"The password confirmation did not match the new password.",
				"Error message is not displayed as expected");

	}
}
