import java.util.Scanner;

public class _01_Problem {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String start = input.nextLine();
		String end = input.nextLine();
		String[] startArr = start.split(":");
		String[] endArr = end.split(":");
		
		//System.out.println(Arrays.toString(startArr));
		//System.out.println(Arrays.toString(endArr));
		Long startHours = Long.parseLong(startArr[0]);
		Long startMin = Long.parseLong(startArr[1]);
		Long startSec = Long.parseLong(startArr[2]);
		
		Long endHours = Long.parseLong(endArr[0]);
		Long endMin = Long.parseLong(endArr[1]);
		Long endSec = Long.parseLong(endArr[2]);
		
		long startInSec = startSec + startMin*60 + startHours*60*60;
		long endInSec = endSec + endMin*60 + endHours*60*60;
		
		long timeDiff = Math.abs(startInSec - endInSec);
		//System.out.println(timeDiff);
		long seconds = timeDiff % 60;
		//System.out.println(seconds);
		long minutes = (timeDiff % 3600)/60;
		long hours = timeDiff / 3600;
		//System.out.println(minutes);
		//System.out.println(hours);
		System.out.printf("%s:%02d:%02d", hours, minutes, seconds);		
	}
}
