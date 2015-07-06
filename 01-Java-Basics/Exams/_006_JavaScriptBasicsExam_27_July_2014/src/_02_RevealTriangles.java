import java.util.Arrays;
import java.util.Scanner;

public class _02_RevealTriangles {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLines = Integer.parseInt(input.nextLine());
		char[][] chars = new char[numOfLines][];
		//char[][] arr = new char[numOfLines][];
		
		for (int i = 0; i < numOfLines; i++) {
			String currLine = input.nextLine();
			char[] currChars = currLine.toCharArray();
			chars[i] = currChars;
		}
		
		char[][] arr = new char[numOfLines][];
		for (int i = 0; i < numOfLines; i++) {
		  arr[i] = Arrays.copyOf(chars[i], chars[i].length);
		}
				
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (j + 1 < arr[i+1].length &&
						arr[i][j] == arr[i+1][j-1] && 
						arr[i][j] == arr[i+1][j] &&
						arr[i][j] == arr[i+1][j+1] ) {
					chars[i][j] = '*';
					chars[i+1][j-1] = '*';
					chars[i+1][j] = '*';
					chars[i + 1][j + 1] = '*';
				}
				
			}
		}
		for (int i = 0; i < chars.length; i++) {
			for (int j = 0; j < chars[i].length; j++) {
				System.out.print(chars[i][j]);
			}
			System.out.println();
		}
	}
}
