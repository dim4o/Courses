
public class Test {

	public static void main(String[] args) {
		String[] latters = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		String[] suit = {"♣", "♦", "♥", "♠"};
		int counter = 0;
		
		for (int firstThree = 0; firstThree < latters.length; firstThree++) {
			for (int secondTwo = 0; secondTwo < latters.length; secondTwo++) {
				if (firstThree!=secondTwo) {
					for (int i1 = 0; i1 < suit.length; i1++) {
						for (int i2 = i1+1; i2 < suit.length; i2++) {
							for (int i3 = i2+1; i3 < suit.length; i3++) {
								for (int i4 = 0; i4 < suit.length; i4++) {
									for (int i5 = i4+1; i5 < suit.length; i5++) {
										System.out.print("" + latters[firstThree] + suit[i1] + latters[firstThree] + suit[i2] +latters[firstThree] + suit[i3] + latters[secondTwo] + suit[i4]+ latters[secondTwo] + suit[i5] + '\n');
										counter++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(counter + " full houses");

	}

}
