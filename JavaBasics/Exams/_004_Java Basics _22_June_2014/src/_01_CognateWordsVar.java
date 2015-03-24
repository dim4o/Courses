import java.util.HashSet;
import java.util.Scanner;

public class _01_CognateWordsVar {
//15:10 -- 15:30 --> 20 minutes, 100/100 от първия път
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String line = input.nextLine();
		String[] words = line.split("[^a-zA-Z]+");
		boolean exist = false;

		HashSet<String> set = new HashSet<String>();
		for (int i1 = 0; i1 < words.length; i1++) {
			for (int i2 = 0 ; i2 < words.length; i2++) {
				for (int i3 = 0 ; i3 < words.length; i3++) {
					if (words[i1].equals("") || words[i2].equals("") || words[i3].equals("")) {
						continue;
					}
					if ((words[i1] + words[i2]).equals(words[i3])) {
						set.add(words[i1] +"|" + words[i2] + "=" +words[i3]);
						exist = true;
					}
				}
			}
		}
		if (exist == false) {
			System.out.println("No");
		}
		for (String string : set) {
			System.out.println(string);
		}
	}
}
