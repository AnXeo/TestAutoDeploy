package Common;

import Constant.Constant;
import RailWay.ConfirmPage;
import RailWay.PasswordResetPage;

public class AccountHelper {

	public static PasswordResetPage activeResetPassLink(String accountEmail) {
		String prefix = "Please reset your password ";
		String activateURL = Common.CheckingMails.check(prefix, accountEmail);
		Constant.WEBDRIVER.get(activateURL);
		return new PasswordResetPage();
	}

	public static ConfirmPage activateAccount(String accountEmail) {
		String prefix = "Please confirm your account ";
		String activateURL = Common.CheckingMails.check(prefix, accountEmail);
		Constant.WEBDRIVER.get(activateURL);
		return new ConfirmPage();
	}

}
