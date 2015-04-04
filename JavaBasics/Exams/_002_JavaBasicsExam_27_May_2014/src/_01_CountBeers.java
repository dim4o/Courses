import java.util.Scanner;

public class _01_CountBeers {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int stacks = 0;
		int beers = 0;
		while (true) {
			String inputString = input.nextLine();
			if (inputString.equals("End")) {
				break;
			}
			String[] str = inputString.split(" ");
			if (str[1].equals("stacks")) {
				stacks += Integer.parseInt(str[0]);
			} else {
				beers += Integer.parseInt(str[0]);
			}
		}
		stacks += beers / 20;
		beers %= 20;
		System.out.printf("%s stacks + %s beers", stacks, beers);
	}

}
