import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class _10_ExtractAllUniqueWords {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		String inputString = input.nextLine();
		inputString = inputString.toLowerCase();
		String[] words = inputString.split("[^a-zA-Z]");

		SortedSet<String> wordsSet = new TreeSet<String>();

		for (String ithem : words) {
			if (!ithem.equals("")) {
				wordsSet.add(ithem);
			}
		}

		for (Object object : wordsSet) {
			System.out.print(object + " ");
		}
	}
}
