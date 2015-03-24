import java.util.ArrayList;
import java.util.Scanner;

public class _04_LongestIncreasingSequence {

	private static Scanner inputScanner;

	public static void main(String[] args) {

		inputScanner = new Scanner(System.in);

		String inputString = inputScanner.nextLine();
		String[] arrStrings = inputString.split(" ");

		ArrayList<String> allEqualSequences = getAllEqualSequence(arrStrings);
		printAllSequences(allEqualSequences);
		// Collections.sort(allEqualSequences);

		String longeString = null;
		int maxLength = Integer.MIN_VALUE;
		for (int i = 0; i < allEqualSequences.size(); i++) {
			String[] tempArr = allEqualSequences.get(i).split(" ");
			if (tempArr.length > maxLength) {
				maxLength = tempArr.length;
				longeString = allEqualSequences.get(i);
			}
		}
		System.out.printf("Longest: %s", longeString);
		// System.out.println(allEqualSequences.get(allEqualSequences.lastKey()));
	}

	public static void printAllSequences(ArrayList<String> allEqualSequences) {
		for (String sequence : allEqualSequences) {
			System.out.println(sequence);
		}
	}

	public static ArrayList<String> getAllEqualSequence(String[] arrStrings) {

		ArrayList<String> allEqualSequences = new ArrayList<String>();
		String equalSequence = Integer.parseInt(arrStrings[0]) + "";

		for (int i = 0; i < arrStrings.length - 1; i++) {

			if (Integer.parseInt(arrStrings[i]) < Integer
					.parseInt(arrStrings[i + 1])) {
				equalSequence += " " + arrStrings[i + 1];
			} else {
				allEqualSequences.add(equalSequence);
				equalSequence = Integer.parseInt(arrStrings[i + 1]) + "";
			}
		}
		allEqualSequences.add(equalSequence);
		return allEqualSequences;
	}
}
