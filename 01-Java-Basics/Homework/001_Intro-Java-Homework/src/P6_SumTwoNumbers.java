import java.util.Scanner;

public class P6_SumTwoNumbers {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		
		int firstNum = input.nextInt();
		int secondNum = input.nextInt();
		int sum = firstNum + secondNum;
		
		System.out.println(sum);
	}
}
