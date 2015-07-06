import java.util.Scanner;

public class P8_SortArrayOfStrings {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		String[] arrayOfStrings = new String[num];

		for (int i = 0; i < num; i++) {
			arrayOfStrings[i] = input.nextLine();
		}
		
		for (int i = 0; i < arrayOfStrings.length - 1; i++) {
			for (int j = i + 1; j < arrayOfStrings.length; j++) {
				if (arrayOfStrings[j].toLowerCase()
						.compareTo(arrayOfStrings[i].toLowerCase()) <= 0) {
					String temp = arrayOfStrings[i];
					arrayOfStrings[i] = arrayOfStrings[j];
					arrayOfStrings[j] = temp;
				}
			}		
		}
		
		for (int i = 0; i < arrayOfStrings.length; i++) {
			System.out.println(arrayOfStrings[i]);
		}
	}
}
