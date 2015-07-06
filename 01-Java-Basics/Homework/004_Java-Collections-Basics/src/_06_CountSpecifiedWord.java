import java.util.Scanner;

public class _06_CountSpecifiedWord {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String sentence = input.nextLine();
		String keyWord = input.nextLine();
		String[] words = sentence.split("[^a-zA-Z]+");
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equalsIgnoreCase(keyWord)) {
				count++;
			}
		}
		System.out.println(count);

	}

}
