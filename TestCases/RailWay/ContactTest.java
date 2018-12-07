package RailWay;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Constant.Constant;

public class ContactTest extends BaseTest {

	@Test
	public void TC04() {
		System.out.println(
				"TC04- Contact Email contains correct href value which can help to quickly open Outlook Compose Message dialog");

		// 1. Navigate to QA Railway Website
		// 2. Click on "Contact" tab
		// 3. Check the email address

		HomePage homePage = new HomePage();

		assertEquals(homePage.open().gotoContactPage().getAttributeHref(), "mailto:" + Constant.emailContact,
				"Href value is incorrectly.");
	}

}
