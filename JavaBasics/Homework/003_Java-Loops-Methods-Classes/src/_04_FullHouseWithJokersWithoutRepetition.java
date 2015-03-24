import java.util.Arrays;
import java.util.LinkedHashSet;

public class _04_FullHouseWithJokersWithoutRepetition {

	public static void main(String[] args) {

		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };
		String[] suits = { "♣", "♦", "♥", "♠" };
		LinkedHashSet<String> fullHouseSet = new LinkedHashSet<String>();
		for (int card1 = 0; card1 < cards.length; card1++) {
			for (int card2 = card1 + 1; card2 < cards.length; card2++) {
				for (int suit1 = 0; suit1 < suits.length; suit1++) {
					for (int suit2 = suit1 + 1; suit2 < suits.length; suit2++) {
						for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
							for (int suit4 = 0; suit4 < suits.length; suit4++) {
								for (int suit5 = suit4 + 1; suit5 < suits.length; suit5++) {

									for (int bit = 0; bit < 32; bit++) {

										String[] fullHouse1 = {
												cards[card1] + suits[suit1],
												cards[card1] + suits[suit2],
												cards[card1] + suits[suit3],
												cards[card2] + suits[suit4],
												cards[card2] + suits[suit5] };
										String[] fullHouse2 = {
												cards[card2] + suits[suit1],
												cards[card2] + suits[suit2],
												cards[card2] + suits[suit3],
												cards[card1] + suits[suit4],
												cards[card1] + suits[suit5] };
										for (int num = 0; num < 5; num++) {
											if ((bit & (16 >> num)) == 16 >> num) {
												fullHouse1[num] = "*";
												fullHouse2[num] = "*";
											}
										}
										Arrays.sort(fullHouse1);
										Arrays.sort(fullHouse2);
										String fullHouse1String = Arrays
												.toString(fullHouse1);
										String fullHouse2String = Arrays
												.toString(fullHouse2);
										fullHouseSet.add(fullHouse1String
												.replaceAll("[\\[\\],]", ""));
										fullHouseSet.add(fullHouse2String
												.replaceAll("[\\[\\],]", ""));
									}
								}
							}
						}
					}
				}
			}
		}
		for (String ithem : fullHouseSet) {
			System.out.printf("(%s)%n", ithem);
		}
		System.out.printf("%s full houses", fullHouseSet.size());
	}
}
