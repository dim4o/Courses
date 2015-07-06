import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class _04_StraightFlushVar {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String hend = input.nextLine();
		String[] cardsStrings = hend.split("[, ]+");
		HashSet<String> set = new HashSet<String>();
		//System.out.println(Arrays.toString(cardsStrings));
		for (int i = 0; i < cardsStrings.length; i++) {
			set.add(cardsStrings[i]);
		}
		String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
		String[] suits = {"S", "H", "D" ,"C"}; 
		boolean exist = false;
		String[] allCards = new String[13];
		
		for (int suit = 0; suit < suits.length; suit++) {
			for (int card = 0; card < cards.length; card++) {
				allCards[card] = cards[card] + suits[suit];
			}
			
			for (int i = 0; i <= 8; i++) {
				ArrayList<String> cardList = new ArrayList<String>();
				for (int k = i; k < i + 5; k++) {
					if (set.contains(allCards[k])) {
						cardList.add(allCards[k]);
					}
					if (cardList.size() == 5) {
						System.out.println(cardList.toString());
						exist = true;
					}
				}
			}
		}
		if (exist == false) {
			System.out.println("No Straight Flushes");
		}
		

	}

}
