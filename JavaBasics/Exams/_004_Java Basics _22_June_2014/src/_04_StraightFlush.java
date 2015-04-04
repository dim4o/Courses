import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class _04_StraightFlush {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String handString = input.nextLine();
		HashSet<String> handSet = new HashSet<String>(Arrays.asList(handString.split("[, ]+")));
		boolean exist = false;
		String[] faceStrings = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suitStrings = {"S", "H", "D", "C"};
		String[] cards = new String[13];
		
		for (int i = 0; i < suitStrings.length; i++) {
			for (int k = 0; k < cards.length; k++) {
				cards[k] = faceStrings[k] + suitStrings[i];
			}
			for (int start = 0; start <= 8; start++) {
				ArrayList<String> list = new ArrayList<String>();
				for (int w = start; w < start + 5; w++) {
					if (handSet.contains(cards[w])) {
						list.add(cards[w]);
						if (list.size() == 5 ) {
							System.out.println(list.toString());
							exist = true;
							break;
						}
					}
				}
			}
		}
		if (exist == false) {
			System.out.println("No Straight Flushes");
		}
	}
}
