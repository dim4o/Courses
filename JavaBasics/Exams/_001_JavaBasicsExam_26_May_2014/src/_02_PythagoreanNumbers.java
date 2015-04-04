import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_PythagoreanNumbers {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		int[] numbers = new int[num];
		Set<String> pytagoreanMap = new HashSet<String>();
		boolean exist = false;
		for (int i = 0; i < num; i++) {
			int currNum = Integer.parseInt(input.nextLine());
			numbers[i] = currNum;
		}
		for (int i1 = 0; i1 < numbers.length; i1++) {
			for (int i2 = 0; i2 < numbers.length; i2++) {
				for (int i3 = 0; i3 < numbers.length; i3++) {
					int a = numbers[i1];
					int b = numbers[i2];
					int c = numbers[i3];
					if (a <= b && a * a + b * b == c * c) {
						String pytagorean = a + "*" + a + " + " + b + "*" + b
								+ " = " + c + "*" + c;
						pytagoreanMap.add(pytagorean);
						exist = true;
					}
				}
			}
		}
		if (!exist) {
			System.out.println("No");
		}
		for (String string : pytagoreanMap) {
			System.out.println(string);
		}

	}

}
