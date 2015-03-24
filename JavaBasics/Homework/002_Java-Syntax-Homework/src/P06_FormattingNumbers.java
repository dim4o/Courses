import java.util.Scanner;

public class P06_FormattingNumbers {

	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
		int a = input.nextInt();
		float b = input.nextFloat();
		float c = input.nextFloat();
		
		String hexNum = Integer.toHexString(a).toUpperCase();
		String binNum = Integer.toBinaryString(a);
		
		System.out.print("|" + String.format("%1$-" + 10 + "s", hexNum));
		String formattedBin = ("0000000000" + binNum).substring(binNum.length());
		System.out.print("|" + formattedBin);
		String formatedB = String.format("%.2f", b);
		System.out.print("|" + String.format("%1$" + 10 + "s", formatedB));
		String formatedC = String.format("%.3f", c);
		System.out.print("|" + String.format("%1$-" + 10 + "s", formatedC) + "|");
	}

}
