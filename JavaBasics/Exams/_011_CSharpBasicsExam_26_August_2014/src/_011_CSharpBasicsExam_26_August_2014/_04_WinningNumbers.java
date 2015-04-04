package _011_CSharpBasicsExam_26_August_2014;
import java.util.Scanner;

public class _04_WinningNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String lettersString = input.nextLine();
		lettersString = lettersString.toLowerCase();
		char[] letters = lettersString.toCharArray();
		boolean exist = false;
		int sum = 0;
		for (int i = 0; i < letters.length; i++) {
			sum += (int) letters[i] - 96;
		}
		// System.out.println(sum);
		for (int i1 = 0; i1 < 10; i1++) {
			for (int i2 = 0; i2 < 10; i2++) {
				for (int i3 = 0; i3 < 10; i3++) {
					for (int i4 = 0; i4 < 10; i4++) {
						for (int i5 = 0; i5 < 10; i5++) {
							for (int i6 = 0; i6 < 10; i6++) {
								if (i1 * i2 * i3 == sum && i4 * i5 * i6 == sum) {
									System.out.printf("%s%s%s-%s%s%s\n", i1,
											i2, i3, i4, i5, i6);
									exist = true;
								}
							}
						}
					}
				}
			}
		}
		if (exist == false) {
			System.out.println("No");
		}
	}
}
