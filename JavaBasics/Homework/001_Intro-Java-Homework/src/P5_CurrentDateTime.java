import java.util.Date;

public class P5_CurrentDateTime {

	public static void main(String[] args) {
		Date currDateTime = new Date();
		System.out.printf("%1$tA, %1$td-%1$tm-%1$tY, %1$tH:%1$tM:%1$tS",currDateTime);
	}
}
