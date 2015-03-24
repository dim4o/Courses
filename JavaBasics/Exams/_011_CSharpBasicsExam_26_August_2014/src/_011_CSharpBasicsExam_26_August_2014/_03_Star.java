package _011_CSharpBasicsExam_26_August_2014;

import java.util.Scanner;
//19:03 -- 19:29 --> 26 minutes, 100/100 от първия път
public class _03_Star {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		
		System.out.print(repeated(".", num));
		System.out.print("*");
		System.out.print(repeated(".", num));
		System.out.println();
		
		for (int i = 0; i < num/2 - 1; i++) {
			System.out.print(repeated(".", num - i - 1));
			System.out.print("*");
			System.out.print(repeated(".", i*2 + 1));
			System.out.print("*");
			System.out.print(repeated(".", num - i - 1));
			System.out.println();
		}
		System.out.print(repeated("*", num/2 + 1));
		System.out.print(repeated(".", num - 1));
		System.out.print(repeated("*", num/2 + 1));
		System.out.println();
		
		for (int i = 0; i < num/2 - 1; i++) {
			System.out.print(repeated(".", i + 1));
			System.out.print("*");
			System.out.print(repeated(".", 2*num - 2*(i + 1) - 1));
			System.out.print("*");
			System.out.print(repeated(".", i + 1));
			System.out.println();
		}
		System.out.print(repeated(".", num/2));
		System.out.print("*");
		System.out.print(repeated(".", num/2 - 1));
		System.out.print("*");
		System.out.print(repeated(".", num/2 - 1));
		System.out.print("*");
		System.out.print(repeated(".", num/2));
		System.out.println();
		
		for (int i = 0; i < num/2 - 1; i++) {
			System.out.print(repeated(".", num/2 - i - 1));
			System.out.print("*");
			System.out.print(repeated(".", num/2 - 1));
			System.out.print("*");
			System.out.print(repeated(".", 2*i + 1));
			System.out.print("*");
			System.out.print(repeated(".", num/2 - 1));
			System.out.print("*");
			System.out.print(repeated(".", num/2 - i - 1));
			System.out.println();
		}
		System.out.print(repeated("*", num/2 + 1));
		System.out.print(repeated(".", num - 1));
		System.out.print(repeated("*", num/2 + 1));	
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
