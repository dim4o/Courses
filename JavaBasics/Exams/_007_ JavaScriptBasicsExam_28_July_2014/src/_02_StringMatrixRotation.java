import java.util.Scanner;

public class _02_StringMatrixRotation {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		int rows = Integer.parseInt(input.nextLine());
		String inputDegreeString = input.nextLine();
		
		String[] arr = new String[rows];
		for (int i = 0; i < rows; i++) {
			arr[i] = input.nextLine();
		}
		
		inputDegreeString = inputDegreeString.replaceAll("[^0-9]", "");
		int degrees = Integer.parseInt(inputDegreeString);
		//System.out.println(degrees);
		int numOfRotation = degrees / 90;
		for (int i = 0; i < numOfRotation; i++) {
			char[][] arrrr = rotateString(arr, arr.length);
			arr = new String[arrrr.length];
			//String[] bbb = new String[arrrr.length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = new String(arrrr[j]); 
			}
		}
		
		printMatrix(arr);
	}
	private static char[][] rotateString(String[] arr, int rows){

		int cols = 0;
		for (String string : arr) {
			if (string.length() > cols) {
				cols = string.length();
			}
		}
	
		//System.out.println(rows);
		//System.out.println(cols);
		char[][] rotatedMatrix = new char[cols][rows];
		char[][] matrix = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int k = 0; k <cols; k++) {
				if (k < arr[i].length()) {
					matrix[i][k] = arr[i].charAt(k);
				} else {
					matrix[i][k] = ' ';
				}
			}
		}
		
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				rotatedMatrix[col][rows - row - 1] = 
						matrix[row][col];
			}
		}
		
		return rotatedMatrix;
	}
	
	private static void printMatrix(String[] arr){
//		for (char[] cs : rotatedMatrix) {
//			for (char c : cs) {
//				System.out.print(c + "");
//			}
//			System.out.println();
//		}
		for (String string : arr) {
			System.out.println(string);
		}
		
	}

}
