import java.util.Scanner;

public class P08_CountOfEqualBitPairs {

	public static Scanner input;
	
	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		long num = input.nextLong();
		int count = 0;
		
		while (num > 0) {
			if ((3 & num) == 3 || (3 & (~num)) == 3) {
				count++;
			}
			num >>= 1;
		}
		System.out.println(count);
	}
}
