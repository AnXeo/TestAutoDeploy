package RailWay;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.AccountHelper;
import Objects.Account;
import Objects.Ticket;

public class BookTicketTest extends BaseTest {

	@Test
	public void TC14() {

		System.out.println("User can't book more than 10 tickets");

		// Pre-condition: Create and activate a new account
		// 1. Navigate to QA Railway Website
		// 2. Login with a valid account
		// 3. Click on "Book ticket" tab
		// 4. Book 10 tickets
		// 5. Click on "Book ticket" tab again
		// 6. Book one more ticket

		HomePage homePage = new HomePage();
		Ticket ticket = new Ticket();
		ticket.initRandomTicket();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account
		ConfirmPage confirmPage = AccountHelper.activateAccount(account.getEmail());

		// Login with valid account
		homePage = confirmPage.gotoLoginPage().loginSuccessfully(account.getEmail(), account.getPassword());

		// Book 10 tickets
		ticket.setAmount(10);

		BookSuccessfullyPage bookSuccessfullyPage = homePage.gotoBookTicketPage().bookTicketSuccessfully(ticket);

		// Book one more ticket
		ticket.setAmount(1);
		BookTicketPage bookTicketPage = bookSuccessfullyPage.gotoBookTicketPage().bookTicketExistError(ticket);

		// Verify Error message "There're errors in the form. Please correct the errors
		// and try again." displays above the form.
		assertEquals(bookTicketPage.getTextLblErrorMsg(),
				"There're errors in the form. Please correct the errors and try again.");

		// Verify Error message "You have booked 10 tickets. You can book no more."
		// displays next to Ticket amount field.
		assertEquals(bookTicketPage.getTextVldErrorAmount(), "You have booked 10 tickets. You can book no more.");
	}

	@Test
	public void TC15() {
		System.out.println("User can open Book ticketpage by click on Book ticketlink in Ticket price");

		// Pre-condition: Create and activate a new account
		// 1. Navigate to QA Railway Website
		// 2. Login with a valid account
		// 3. Click on "Ticket price" tab
		// 4. Click on any ticket from the list
		// 5. Click on "Book ticket" for any seat type

		HomePage homePage = new HomePage();
		Ticket ticket = new Ticket();
		ticket.initRandomTicket();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account
		ConfirmPage confirmPage = AccountHelper.activateAccount(account.getEmail());

		// Login with valid account then go to "Ticket price " page
		TicketPricePage ticketPricePage = confirmPage.gotoLoginPage()
				.loginSuccessfully(account.getEmail(), account.getPassword()).gotoTicketPricePage();
		// Book any ticket ( any seat type)
		BookTicketPage bookTicketPage = ticketPricePage.checkPrice(ticket.getDepartStation(), ticket.getArriveAt())
				.bookTicket(ticket.getSeatType());

		// Verify depart station value
		Assert.assertEquals(bookTicketPage.getDepartStation(), ticket.getDepartStation(),
				"Depart station is not display correct value which user selected");

		// Verify arrive station value
		Assert.assertEquals(bookTicketPage.getArriveStation(), ticket.getArriveAt(),
				"Arrive station is not display correct value which user selected");

		// Verify seat type value
		Assert.assertEquals(bookTicketPage.getSeatType(), ticket.getSeatType(),
				"Seat type isn't display correct value which user selected");

	}

	@Test
	public void TC16() {
		System.out.println("User can cancel a ticket");

		// Pre-condition: Create and activate a new account
		// 1. Navigate to QA Railway Website
		// 2. Login with a valid account
		// 3. Book a ticket
		// 4. Click on "My ticket" tab
		// 5. Click on "Cancel" button of ticket which user want to cancel.
		// 6. Click on "OK" button on Confirmation message "Are you sure?"

		HomePage homePage = new HomePage();
		Ticket ticket = new Ticket();
		ticket.initRandomTicket();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account
		ConfirmPage confirmPage = AccountHelper.activateAccount(account.getEmail());

		// Login with valid account
		homePage = confirmPage.gotoLoginPage().loginSuccessfully(account.getEmail(), account.getPassword());

		// Book a ticket then go to My Ticket Page
		ticket.setAmount(1);

		MyTicketPage myTicketPage = homePage.gotoBookTicketPage().bookTicketSuccessfully(ticket).gotoMyTicketPage();

		// Cancel ticket
		myTicketPage.cancelTicket();
	
		// Verify if the canceled ticket is disappeared
		assertFalse(myTicketPage.isCancelTicketDisappeared(ticket), "The canceled ticket isn't disappeared");
	}
}
