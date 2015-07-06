import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class _07_DaysBetweenTwoDates {

	private static Scanner input;
	static final int MILLISECONDS = 1000;
	static final int SECONDS = 60;
	static final int MINUTES = 60;
	static final int HOURS = 24;

	public static void main(String[] args) throws ParseException {
		//inputs
		input = new Scanner(System.in);
		String startDateString = input.nextLine();
		String endDateString = input.nextLine();
		//parsing and formatting
		DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		Date startDate = dateFormatter.parse(startDateString);
		Date endDate = dateFormatter.parse(endDateString);
		//calculates numbers of days
		long diffrance = endDate.getTime() - startDate.getTime();
		double diffDays = (double) diffrance
				/ (MILLISECONDS * SECONDS * MINUTES * HOURS);
		System.out.printf("%.0f%n", diffDays);
		//System.out.println(TimeUnit.MICROSECONDS.toDays(diffrance));
	}
}
