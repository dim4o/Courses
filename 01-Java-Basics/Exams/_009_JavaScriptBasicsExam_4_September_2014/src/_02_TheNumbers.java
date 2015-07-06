import java.util.Scanner;

public class _02_TheNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String lineString = input.nextLine();
		String[] digitString = lineString.split("[^0-9]+");

		for (int i = 0; i < digitString.length; i++) {
			if (!digitString[i].equals("")) {
				digitString[i] = Integer.toHexString(Integer.parseInt(digitString[i]));
				digitString[i] = digitString[i].toUpperCase();
			}
		}
		String result = "";
		for (String ithem : digitString) {
			if (!ithem.equals("")) {
				result += "0x"+("0000" + ithem).substring(ithem.length())+"-";
			}
		}
		System.out.println(result.substring(0, result.length()-1));
	}

}
