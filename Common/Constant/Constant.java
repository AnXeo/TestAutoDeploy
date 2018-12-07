package Constant;

import org.openqa.selenium.WebDriver;

public class Constant {

	public static WebDriver WEBDRIVER;
	//public static final String RAILWAY_URL = "ec2-34-222-10-103.us-west-2.compute.amazonaws.com:8082";
	 public static final String RAILWAY_URL = "http://192.168.171.127:8081";
	public static final String MyTicketTab_URL = "http://192.168.171.127:8081/Page/ManageTicket.cshtml";
	public static final String LogoutTab_URL = "http://192.168.171.127:8081/Page/HomePage.cshtml";
	public static final String ChangePasswordTab_URL = "http://192.168.171.127:8081/Account/ChangePassword.cshtml";

	public static final String username = "thanh.viet.le@logigear.com";
	public static final String password = "12345678";
	public static final String password_invalid = "0128755655";

	public static final String emailContact = "thanh.viet.le@logigear.com";

	public static final String emailAccount = "thanhletraining01@gmail.com";
	public static final String passAccount = "logigear123";

}
