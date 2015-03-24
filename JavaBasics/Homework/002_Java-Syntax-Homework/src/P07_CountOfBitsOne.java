import java.util.Scanner;

public class P07_CountOfBitsOne {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		long num = input.nextLong();
		int count = 0;
		
		while (num > 0) {
			
			if ((1 & num) == 1) {
				count++;
			}
			num >>= 1;
		}
		System.out.println(count);
	}
}
