import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//11:11 -- 11--29 --> 18 minutes
public class _01_CognateWords {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		String[] words = inputString.split("[^A-Za-z]+");
		boolean exist = false;

		Set<String> set = new HashSet<String>();
		for (int i1 = 0; i1 < words.length; i1++) {
			for (int i2 = 0; i2 < words.length; i2++) {
				for (int i3 = 0; i3 < words.length; i3++) {
					if ((words[i1] + words[i2]).equals(words[i3])) {
						String foundWord = words[i1] + "|" + words[i2] + "="
								+ words[i3];
						exist = true;
						set.add(foundWord);
					}
				}
			}
		}

		for (String string : set) {
			System.out.println(string);
		}
		if (exist == false) {
			System.out.println("No");
		}

	}
}
