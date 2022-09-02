package studentmanagement.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Time {
	public static String showLocalTime() {
		return new SimpleDateFormat("yyyy.MM.dd").format(Calendar.getInstance().getTime());

}
}
