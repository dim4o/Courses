import java.util.Scanner;

public class P01_VideoDurations {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int hours = 0;
		int minutes = 0;
		while (true) {
			String currString = input.nextLine();
			if (currString.equals("End")) {
				break;
			}
			int currHours = Integer.parseInt(currString.split(":")[0]);
			int currMinutes = Integer.parseInt(currString.split(":")[1]);
			minutes += currMinutes;
			hours += currHours;
		}
		System.out.printf("%s:%02d", hours + minutes/60, minutes%60);
	}
}
