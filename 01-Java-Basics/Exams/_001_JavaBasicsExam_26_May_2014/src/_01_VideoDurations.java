import java.util.Scanner;

public class _01_VideoDurations {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int hours = 0;
		int minutes = 0;
		while (true) {
			String durationInfo = input.nextLine();
			if (durationInfo.equals("End")) {
				break;
			} else {
				String[] duration = durationInfo.split(":");
				hours += Integer.parseInt(duration[0]);
				minutes += Integer.parseInt(duration[1]);
			}
		}
		hours += minutes / 60;
		minutes %= 60;
		System.out.printf("%s:%02d", hours, minutes);
	}
}
