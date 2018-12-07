package RailWay;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.Test;
import Constant.Constant;
import Constant.Messages;
import Objects.Account;
import RailWay.HomePage;
import RailWay.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void TC01() {
		System.out.println("TC01- User can log into Railway with valid username and password");

		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		// 3. Enter valid Email and Password
		// 4. Click on "Login" button

		HomePage homePage = new HomePage();
		homePage.open();

		String actualMsg = homePage.gotoLoginPage().loginSuccessfully(Constant.username, Constant.password)
				.getWelcomeMessage();

		String expectedMsg = "Welcome " + Constant.username;

		Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
	}

	@Test
	public void TC02() {
		System.out.println("TC02- User can't login with blank  'Username' textbox");
		
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		// 3. User doesn't type any words into "Username" textbox but enter valid
		// information into "Password" textbox
		// 4. Click on "Login" button

		HomePage homePage = new HomePage();

		String actualMsg = homePage.open().gotoLoginPage().loginExpectingError("", Constant.password)
				.getErrorMessageForLoginFailed();

		Assert.assertEquals(actualMsg, Messages.errorMsgForLoginFailed, "Error message is not displayed as expected!");
	}

	@Test
	public void TC03() {
		System.out.println("TC03- User cannot log into Railway with invalid password");
		
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		// 3. Enter valid Email and invalid Password
		// 4. Click on "Login" button

		HomePage homePage = new HomePage();

		String actualMsg = homePage.open().gotoLoginPage()
				.loginExpectingError(Constant.username, Constant.password_invalid).getErrorMessageForLoginFailed();

		Assert.assertEquals(actualMsg, Messages.errorMsgForLoginFailed, "Error message is not displayed as expected!");
	}

	@Test
	public void TC05() {
		System.out.println("TC05- System shows message when user enters wrong password several times");
		
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		// 3. Enter valid information into "Username" textbox except "Password" textbox.
		// 4. Click on "Login" button
		// 5. Repeat step 3 three more times.

		HomePage homePage = new HomePage();

		LoginPage loginPage = homePage.open().gotoLoginPage();

		// Enter valid information into "Username" textbox except "Password" textbox.
		for (int i = 0; i < 4; i++) {
			loginPage.loginExpectingError(Constant.username, Constant.password_invalid);
		}

		// Verify Error message is displayed
		Assert.assertEquals(loginPage.getErrorMessageForLoginFailed(), Messages.errorMsgForLoginFailedSeveralTimes,
				"Error message is not displayed as expected!");
	}

	@Test
	public void TC06() {
		System.out.println("TC06- Additional pages display once user logged in");
		
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		// 3. Login with valid account

		HomePage homePage = new HomePage();

		// Login with valid account
		homePage = homePage.open().gotoLoginPage().loginSuccessfully(Constant.username, Constant.password);

		// Verify "My ticket", "Change password" and "Logout" tabs are displayed.
		assertTrue(homePage.isMyChangePasswordTabExists(), "Logout tab is notdisplayed as expected");
		assertTrue(homePage.isMyLogoutTabExists(), "Change password tab is not displayed as expected ");
		assertTrue(homePage.isMyTicketTabExists(), "MyTicket Tab is not displayed as expected ");

		// Click "My ticket" tab, Verify user will be directed to My ticket page
		assertTrue(homePage.gotoMyTicketPage().isMyTicketTabDisplayed(), "User can not redirect to My ticket page");

		// Click "Change password" tab,Verify user will be directed to Change password
		// page
		assertTrue(homePage.gotoChangePasswordPage().isChangePassWordTabDisplayed(),
				"User can not redirect to Change password page");
	}

	@Test
	public void TC08() {
		System.out.println("User can't login with an account hasn't been activated");
		
		// Pre-condition: Create a new account but do not activate it
		// 1. Navigate to QA Railway Website
		// 2. Click on "Login" tab
		// 3. Enter username and password of account hasn't been activated.
		// 4. Click on "Login" button

		Account account = new Account();
		account.initRandomAccount();

		HomePage homePage = new HomePage();

		// Login with an account do not activated
		LoginPage loginPage = homePage.open().gotoRegisterPage().createNewAccount(account).gotoLoginPage()
				.loginExpectingError(account.getEmail(), account.getPassword());

		// Verify User can't login and message "Invalid username or password. Please try
		// again." appears
		assertEquals(loginPage.getErrorMessageForLoginFailed(), Messages.errorMsgForLoginWithInvalidAccount,
				"Error message is not displayed as expected");
	}

}
