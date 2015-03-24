import java.util.Scanner;

public class _07_CountSubstringOccurrences {

	private static Scanner inputScanner;

	public static void main(String[] args) {

		inputScanner = new Scanner(System.in);

		String textString = inputScanner.nextLine();
		String substring = inputScanner.nextLine();
		substring = substring.toLowerCase();
		textString = textString.toLowerCase();

		int index = textString.indexOf(substring);
		int count = 0;
		while (index != -1) {
			index = textString.indexOf(substring, index + 1);
			count++;
		}
		System.out.println(count);
	}
}
