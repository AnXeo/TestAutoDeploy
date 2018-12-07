package Constant;

public class Messages {
	public static final String errorMsgForLoginFailed = "There was a problem with your login and/or errors exist in your form.";
	public static final String errorMsgForLoginFailedSeveralTimes = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";
	public static final String thanksMsgForRegisterSuccessfully = "Thank you for registering your account";
	public static final String errorMsgForLoginWithInvalidAccount = "Invalid username or password. Please try again.";
	public static final String errorMsgForRegisterFailed = "There're errors in the form. Please correct the errors and try again.";

	public static final String errorValidationForTxtPassword = "Invalid password length.";
	public static final String errorValidationForTxtPid = "Invalid ID length.";

	// Change reset password 
	public static final String errorForResetPasswordTokenIncorrect = "The password reset token is incorrect or may be expired. Visit the forgot password page to generate a new one.";
	public static final String errorForResetPasswordFailed =  "Could not reset password. Please correct the errors and try again.";

	//Filter ticket's information
	
	public static final String errorForFilterFailed = "The date format is wrong, date is ignored.Example of a proper date: Today is <mm/dd/yyy>";

}
