//import java.util.Arrays;
import java.util.Scanner;

//import javax.swing.InputVerifier;

public class _03_Problem {

	public static void main(String[] args) {
		//System.out.println(getValue("adfa"));
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String inputString = input.nextLine();
		
		inputString = inputString.replaceAll("[\\\\/()| ]+", "");
		//System.out.println(inputString);
		String[] lineStrings = inputString.split("[^a-zA-Z]+");
		//System.out.println(Arrays.toString(lineStrings));
		int[] values = new int[lineStrings.length];
		for (int i = 0; i < values.length; i++) {
			values[i] = getValue(lineStrings[i]);
		}
		
		int bestIndex = 0;
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < values.length - 1; i++) {
			int currSum = getValue(lineStrings[i]) + getValue(lineStrings[i + 1]);
			if (currSum >= maxSum ) {
				maxSum = currSum;
				bestIndex = i;
			}
		}
		System.out.println(lineStrings[bestIndex]);
		System.out.println(lineStrings[bestIndex  + 1]);
	}
	public static int getValue (String word){
		word = word.toLowerCase();
		int value = 0;
		for (int i = 0; i < word.length(); i++) {
			value+=(int)(word.charAt(i)-96);
		}
		return value;
	}
}
