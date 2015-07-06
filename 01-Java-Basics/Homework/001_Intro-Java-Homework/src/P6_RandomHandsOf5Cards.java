import java.util.Random;
import java.util.Scanner;

public class P6_RandomHandsOf5Cards {

	static final String[] CARDS = { "2", "3", "4", "5", "6", "7", "8", "9",
			"10", "J", "Q", "K", "A" };
	static final String[] SUITS = { "♣", "♦", "♥", "♠" };
	static Random rand = new Random();
	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		int numberOfHends = input.nextInt();
		for (int i = 0; i < numberOfHends; i++) {
			generateRandomHand();
			System.out.println();
		}
	}

	public static void generateRandomHand() {
		String[] allCards = generateAllCards();
		for (int i = 0; i < 5; i++) {
			int randIndex = rand.nextInt(allCards.length);
			while (allCards[randIndex].equals("*")) {
				randIndex = rand.nextInt(allCards.length);
				;
			}
			System.out.print(allCards[randIndex] + " ");
			allCards[randIndex] = "*";
		}
	}

	public static String[] generateAllCards() {
		String[] allCards = new String[52];
		int count = 0;
		for (int i = 0; i < CARDS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				allCards[count] = "" + CARDS[i] + SUITS[j];
				count++;
			}
		}
		return allCards;
	}
}
