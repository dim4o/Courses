package _010_CSharpBasicsExam_22_August_2014;
import java.util.Scanner;

public class _03_Car {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		System.out.print(repeated(".", num));
		System.out.print(repeated("*", num));
		System.out.print(repeated(".", num));
		System.out.println();
		for (int i = 0; i < num / 2 - 1; i++) {
			System.out.print(repeated(".", num - 1 - i));
			System.out.print("*");
			System.out.print(repeated(".", num + i*2));
			System.out.print("*");
			System.out.print(repeated(".", num - 1 - i));
			System.out.println();
		}
		System.out.print(repeated("*", num/2 + 1));
		System.out.print(repeated(".", 2*num - 2));
		System.out.print(repeated("*", num/2 + 1));
		System.out.println();
		
		for (int i = 0; i < num/2 - 2; i++) {
			System.out.print("*");
			System.out.print(repeated(".", 3*num - 2));
			System.out.print("*");
			System.out.println();
		}
		System.out.println(repeated("*", 3*num));
		for (int i = 0; i < num/2 - 2; i++) {
			System.out.print(repeated(".", num/2));
			System.out.print("*");
			System.out.print(repeated(".", num/2-1));
			System.out.print("*"); 
			
			System.out.print(repeated(".", num - 2));
						
			System.out.print("*");
			System.out.print(repeated(".", num/2-1));
			System.out.print("*");
			System.out.print(repeated(".", num/2));
			System.out.println();
		}
		System.out.print(repeated(".", num/2));
		System.out.print(repeated("*", num/2+1));
		
		System.out.print(repeated(".", num - 2));
		
		System.out.print(repeated("*", num/2+1));
		System.out.print(repeated(".", num/2));		
		System.out.println();
	}
	//repeats string N times
	public static String repeated(String s, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; i++) {
			sb.append(s);
		}
		return sb.toString();
	}
}
