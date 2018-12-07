package Common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Constant.Constant;

public class Utilities {

	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}

	public static int randBetween(int start, int end) {
		return start + (int) Math.round(Math.random() * (end - start));
	}

	public static String getCurrentUrl() {
		try {
			return Constant.WEBDRIVER.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e);
			return "";
		}
	}

	public static String randomPassword() {
		return Integer.toString(randBetween(100000000, 900000000));
	}

	public static String getCurrentDate() {
		return new SimpleDateFormat("m/d/yyyy").format(new Date());
	}

	public static String getDepartDate() {
		Date dt = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dt);
		c.add(Calendar.DATE, 3);
		dt = c.getTime();

		SimpleDateFormat formatter = new SimpleDateFormat("M/d/yyyy");
		String s = formatter.format(dt);
		return s;
	}
	public static void waitFor(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static int getRandomAmount() {
		return randBetween(1, 10);
	}

	public static void waitForElement(By ele) {
		WebDriverWait wait = new WebDriverWait(Constant.WEBDRIVER, 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
	}

	public static void confirmMessage() {
		Constant.WEBDRIVER.switchTo().alert().accept();
	}

}
