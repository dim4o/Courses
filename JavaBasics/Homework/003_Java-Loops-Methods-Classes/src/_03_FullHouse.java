public class _03_FullHouse {

	public static void main(String[] args) {

		String[] cards = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J",
				"Q", "K", "A" };
		String[] suits = { "♣", "♦", "♥", "♠" };
		int count = 0;
		
		for (int card1 = 0; card1 < cards.length; card1++) {
			
			for (int card2 = card1 + 1; card2 < cards.length; card2++) {

				for (int suit1 = 0; suit1 < suits.length; suit1++) {

					for (int suit2 = suit1 + 1; suit2 < suits.length; suit2++) {
						
						for (int suit3 = suit2 + 1; suit3 < suits.length; suit3++) {
							
							for (int suit4 = 0; suit4 < suits.length; suit4++) {
								
								for (int suit5 = suit4 + 1; suit5 < suits.length; suit5++) {
									
										System.out.printf(
												"(%s%s %s%s %s%s %s%s %s%s) ",
												cards[card1], suits[suit1], cards[card1],
												suits[suit2], cards[card1], suits[suit3],
												cards[card2], suits[suit4], cards[card2],
												suits[suit5]);
										count++;
										System.out.printf(
												"(%s%s %s%s %s%s %s%s %s%s) ",
												cards[card2], suits[suit1], cards[card2],
												suits[suit2], cards[card2], suits[suit3],
												cards[card1], suits[suit4], cards[card1],
												suits[suit5]);
										count++;
										if (count % 8 == 0) {
											System.out.println();
										}
								}
							}
						}
					}
				}
			}
		}
		System.out.printf("%s full houses", count);

	}

}
