package RailWay;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import Common.AccountHelper;
import Objects.Account;
import Objects.Ticket;
import Constant.Messages;

public class FinalTest extends BaseTest {

	@Test
	public void FTTC01() {
		System.out.println("User can filter 'Manager ticket' table with Depart Station");

		// 1. Pre-conditon: Create and active a new a account
		// 2. navigate to QA RailWay Website
		// 3.Book more than 6 tickets with diffrent Depart Stations
		// 4. Clik on "My Ticket" Tab
		// 5. Select one of booked Depart Station in "Depart stations" dropdown
		// list
		// 6.Click on "Apply Filter" button

		HomePage homePage = new HomePage();
		Ticket ticket = new Ticket();
		ticket.initRandomTicket();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account then Login with valid account
		homePage = AccountHelper.activateAccount(account.getEmail()).gotoLoginPage()
				.loginSuccessfully(account.getEmail(), account.getPassword());

		BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

		// Book more than 6 tickets
		for (int i = 1; i < 8; i++) {
			ticket.initRandomTicket();
			ticket.setAmount(1);
			bookTicketPage.bookTicketSuccessfully(ticket).gotoBookTicketPage();
		}

		// Go to My Ticket Tab

		MyTicketPage myTicketPage = bookTicketPage.gotoMyTicketPage();

		myTicketPage.filter(myTicketPage.getDepartStationForFilter());

		// verify "Manager table" shows correct ticket(s)
		assertTrue(myTicketPage.isValueOfDepartStationsCorrect(myTicketPage.getDepartStationForFilter()),
				"Manager ticket show incorrect ticket(s)");
	}

	@Test
	public void FTTC02() {

		System.out.println(
				"Error displays when user applies filter with invalid format for 'Dapert Date' in Managet Ticket Table);");

		// 1. Pre-conditon: Create and active a new a account
		// 2. navigate to QA RailWay Website
		// 3.Book more than 6 tickets with diffrent Depart Stations
		// 4. Clik on "My Ticket" Tab
		// 5. Enter invalid Depart date into "depart Date"
		// 6.Click on "Apply Filter" button

		HomePage homePage = new HomePage();
		Ticket ticket = new Ticket();
		ticket.initRandomTicket();
		Account account = new Account();
		account.initRandomAccount();

		// Create new account
		homePage.open().gotoRegisterPage().createNewAccount(account);

		// Active account then Login with valid account
		homePage = AccountHelper.activateAccount(account.getEmail()).gotoLoginPage()
				.loginSuccessfully(account.getEmail(), account.getPassword());

		BookTicketPage bookTicketPage = homePage.gotoBookTicketPage();

		// Book more than 6 tickets
		for (int i = 1; i < 8; i++) {
			ticket.initRandomTicket();
			ticket.setAmount(1);
			bookTicketPage.bookTicketSuccessfully(ticket).gotoBookTicketPage();
		}

		// Go to My Ticket Tab

		ticket.setDepartDate("10/12/96");
		MyTicketPage myTicketPage = bookTicketPage.gotoMyTicketPage().filterFollowDepartDate(ticket.getDepartDate());
		// Verify error message is display
		assertEquals(myTicketPage.getTextLblErrorMsg(), Messages.errorForFilterFailed,
				" Error message is not display as expected");

	}
}