import java.util.Scanner;
//9:45 -- 10:15 --> 30 min, 100/100, 4-ти път: 2 грешни форматирания на изхода 
//После дава time limit и накрая без да поменям кода ми даде 100/100
public class _01_StuckNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int number = Integer.parseInt(input.nextLine());
		String line = input.nextLine();
		String[] numString = line.split(" ");
		boolean exist = false;
		
		for (int i1 = 0; i1 < number; i1++) {
			for (int i2 = 0; i2 < number; i2++) {
				for (int i3 = 0; i3 < number; i3++) {
					for (int i4 = 0; i4 < number; i4++) {
						if (i1 != i2 && i1 != i3 && i1 != i4 && 
							i2 != i3 && i2 != i4 && i3 != i4 && 
								(numString[i1] + numString[i2]).equals(numString[i3] + numString[i4])) {
							System.out.printf("%s|%s==%s|%s%n", 
									numString[i1], numString[i2], numString[i3], numString[i4]);
							exist = true;
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