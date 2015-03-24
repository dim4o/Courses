import java.util.ArrayList;
import java.util.Scanner;

public class _02_SequencesOfEqualStrings {

	private static Scanner inputScanner;

	public static void main(String[] args) {

		inputScanner = new Scanner(System.in);

		String inputString = inputScanner.nextLine();
		String[] arrStrings = inputString.split(" ");

		ArrayList<String> allEqualSequences = getAllEqualSequence(arrStrings);
		printAllSequences(allEqualSequences);
	}

	public static void printAllSequences(ArrayList<String> allEqualSequences) {
		for (String sequence : allEqualSequences) {
			System.out.println(sequence);
		}
	}

	public static ArrayList<String> getAllEqualSequence(String[] arrStrings) {

		ArrayList<String> allEqualSequences = new ArrayList<String>();
		String equalSequence = arrStrings[0];

		for (int i = 0; i < arrStrings.length - 1; i++) {

			if (arrStrings[i].equals(arrStrings[i + 1])) {
				equalSequence += " " + arrStrings[i + 1];
			} else {
				allEqualSequences.add(equalSequence);
				equalSequence = arrStrings[i + 1];
			}
		}
		allEqualSequences.add(equalSequence);
		return allEqualSequences;
	}
}
