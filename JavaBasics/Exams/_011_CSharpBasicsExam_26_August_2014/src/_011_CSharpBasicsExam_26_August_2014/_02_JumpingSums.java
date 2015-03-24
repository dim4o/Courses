package _011_CSharpBasicsExam_26_August_2014;
import java.util.Scanner;

//11:46 -- 12:22 условие --14+22 = 36
//+15 мин - разгеле тазбрах условието
//14:08 -- 14:44, 100/100 от първия път
//общо: 36 + 15 + 36 = 77 MINUTES = 1:17 min. Никак не е лошо за тази задача !
public class _02_JumpingSums {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String numString = input.nextLine();
		int numOfJumps = Integer.parseInt(input.nextLine());
		String[] numbersArr = numString.split(" ");
		
		int[] numbers = new int[numbersArr.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numbersArr[i]);
		}
		
		long maxSum = 0;	
		for (int i = 0; i < numbers.length; i++) {
			int curValue = numbers[i];
			int sum = curValue;
			int currIndex = i;
			int nextIndex = 0;
			for (int j = 0; j < numOfJumps; j++) {
				nextIndex = (currIndex + curValue) % numbers.length;
				sum += numbers[nextIndex];
				curValue = numbers[nextIndex];
				currIndex = nextIndex;
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		System.out.printf("max sum = %s", maxSum);
	}
}
