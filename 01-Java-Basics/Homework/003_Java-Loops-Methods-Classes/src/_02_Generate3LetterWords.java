import java.util.Scanner;

public class _02_Generate3LetterWords {

	private static Scanner input;
	
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String inputChars = input.nextLine();
		char[] chars = inputChars.toCharArray();
		
		for (int first = 0; first < chars.length; first++) {
			for (int second = 0; second < chars.length; second++) {
				for (int third = 0; third < chars.length; third++) {
					System.out.print("" + chars[first] + chars[second] + chars[third] + " ");
				}
			}
		}

	}
}
