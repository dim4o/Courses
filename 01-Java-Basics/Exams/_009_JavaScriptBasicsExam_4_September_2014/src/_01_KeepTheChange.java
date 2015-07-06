import java.util.Scanner;

public class _01_KeepTheChange {

	public static void main(String[] args) {
		//System.out.println((int) '0');
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		double bill = Double.parseDouble(input.nextLine());
		String mood = input.nextLine();
		double tip = 0;
		if (mood.equals("happy")) {
			tip = bill/10;
		} else if (mood.equals("married")) {
			tip = bill*(0.05d/100.0d);
		} else if (mood.equals("drunk")) {
			tip = (bill/100.0d)*(15.0d);
			int pow =  Double.toString(tip).charAt(0)-48;
			tip = Math.pow(tip, pow);
		} else {
			tip = bill/20;
		}
		System.out.printf("%.2f", tip);
	}
}
