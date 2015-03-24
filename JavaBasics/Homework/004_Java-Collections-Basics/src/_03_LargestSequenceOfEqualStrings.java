import java.util.Scanner;
import java.util.TreeMap;


public class _03_LargestSequenceOfEqualStrings {

	private static Scanner inputScanner;
	
	public static void main(String[] args) {
		
		inputScanner = new Scanner(System.in);

		String inputString = inputScanner.nextLine();
		String[] arrStrings = inputString.split(" ");

		TreeMap<Integer, String> allEqualSequences = getAllEqualSequence(arrStrings);	
		System.out.println(allEqualSequences.get(allEqualSequences.lastKey()));

	}
	
	public static TreeMap<Integer, String> getAllEqualSequence(String[] arrStrings) {

		TreeMap<Integer, String> allEqualSequences = new TreeMap<Integer, String>();
		String equalSequence = arrStrings[0];
		int count = 1;
		for (int i = 0; i < arrStrings.length - 1; i++) {

			if (arrStrings[i].equals(arrStrings[i + 1])) {
				equalSequence += " " + arrStrings[i + 1];
				count++;
			} else {
				if (!allEqualSequences.containsKey(count)) {
					allEqualSequences.put(count, equalSequence);
				}
				
				equalSequence = arrStrings[i + 1];
				count = 1;
			}
		}
		if (!allEqualSequences.containsKey(count)) {
			allEqualSequences.put(count, equalSequence);
		}
		return allEqualSequences;
	}
}
