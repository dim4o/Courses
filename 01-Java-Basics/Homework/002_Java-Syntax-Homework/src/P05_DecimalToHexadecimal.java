import java.util.Scanner;

public class P05_DecimalToHexadecimal {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		int decNumber = input.nextInt();
		String hexNumber = Integer.toHexString(decNumber);
		System.out.println(hexNumber.toUpperCase());
	}

}
