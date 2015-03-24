import java.util.Arrays;
import java.util.Scanner;

public class _01_SortArrayOfNumbers {

	private static Scanner inputScanner;

	public static void main(String[] args) {

		inputScanner = new Scanner(System.in);
		int numbersLength = Integer.parseInt(inputScanner.nextLine());

		String numbersString = inputScanner.nextLine();
		String[] numbersArr = numbersString.split(" ");
		int[] numbers = new int[numbersLength];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(numbersArr[i]);
		}
		Arrays.sort(numbers);
		for (int i = 0; i < numbers.length; i++) {
			System.out.printf("%s ", numbers[i]);
		}
	}
}
