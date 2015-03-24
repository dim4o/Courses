import java.util.Scanner;

public class _01_SymmetricNumbersInRange {

	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		String inputLine = input.nextLine();
		String[] inputValues = inputLine.split(" ");
		int start = Integer.parseInt(inputValues[0]);
		int end = Integer.parseInt(inputValues[1]);
		
		for (int i = start; i <= end; i++) {
			if (isSymmetric(i)) {
				System.out.print(i +" ");
			}
		}
	}

	private static boolean isSymmetric(int number) {
		String reversedNumber = new StringBuffer(Integer.toString(number)).reverse().toString();
		if (Integer.toString(number).equals(reversedNumber)) {
			return true;
		}
		return false;
	}

}
