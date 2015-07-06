import java.util.Scanner;

public class _05_CountAllWords {

	private static Scanner input;
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);	
		String sentence = input.nextLine();
		String[] wordsStrings = sentence.split("[^a-zA-Z]+");
		System.out.println(wordsStrings.length);
		//System.out.println(Arrays.toString(wordsStrings));
	}
}
