import java.util.Scanner;

public class P04_TheSmallestOf3Numbers {

	private static Scanner input;

	public static void main(String[] args) {
		input = new Scanner(System.in);
		double a = input.nextDouble();
		double b = input.nextDouble();
		double c = input.nextDouble();
		
		double smallestNum = a;
		if (b <= a && b <= c) {
			smallestNum = b;
		}
		if (c <= a && c <=b) {
			smallestNum = c;
		}
		String str = Double.toString(smallestNum);
		System.out.println(str.replaceAll("\\.0*$", ""));
	}
}
