package hackerhank;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Solution_calendar {
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
	        String month = in.next();
	        String day = in.next();
	        String year = in.next();
	        
	        System.out.println(getDay(day, month, year));
	}
	
	public static String getDay(String day, String month, String year) {
		LocalDate dt = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		return dt.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.US).toUpperCase();          
    }
}
