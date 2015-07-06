import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class _12_CardsFrequencies {

	private static Scanner input;

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		input = new Scanner(System.in);

		String cardsString = input.nextLine();// 8♥ 2♣ 4♦ 10♦ J♥ A♠ K♦ 10♥ K♠ K♦
		cardsString = cardsString.replaceAll("[^a-zA-z_0-9]", " ");
		cardsString = cardsString.trim();
		String[] cards = cardsString.split("[ ]+");
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();

		for (String card : cards) {

			if (map.containsKey(card)) {
				int count = map.get(card);
				map.put(card, count + 1);
			} else {
				map.put(card, 1);
			}
		}

		for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
			double frequency = (mapEntry.getValue() / (double) cards.length) * 100.00d;
			System.out.printf("%s -> %.2f%%%n", mapEntry.getKey(), frequency);
		}

	}

}
