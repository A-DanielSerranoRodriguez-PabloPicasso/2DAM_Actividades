package utils;

import java.time.LocalDateTime;

public class DateWorker {
	public static String getTimestamp() {
		String date = LocalDateTime.now().toString();
		date = date.substring(0, date.lastIndexOf('.')).replace('T', ' ');
		return date;
	}
}
