import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
//2:16 -- 2:35 --> 19 minutes, 100/100 от 4-тия път. 
//Първия път бях сложил само индексите вместо елементите на масива. 
//Усетих се веднага. Другите 2 опита бяха с неточно форматиране на изхода
//Друг извод е, че е по-добре когато имам по-дълги изрази с индекси да ги 
//запазя предварително в отсвлни променливи. Пример с 
//"int a = numbers[i1]" работя после само с "a", Което е много по-ясно.

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
