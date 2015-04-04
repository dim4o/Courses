package _011_CSharpBasicsExam_26_August_2014;
import java.util.Scanner;

public class _01_TicTacPower {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int indexX = Integer.parseInt(input.nextLine()); 
		int indexY = Integer.parseInt(input.nextLine());
		int firstCellValue = Integer.parseInt(input.nextLine());
		
		int[][] indexMatrix = new int[3][3];
	
		int currCellIndex = 1;
		for (int i = 0; i < indexMatrix.length; i++) {
			for (int j = 0; j < indexMatrix.length; j++) {
				indexMatrix[i][j] = currCellIndex;
				currCellIndex++;
			}
		}
		int cellIndex = indexMatrix[indexY][indexX];
		int cellValue = cellIndex + firstCellValue -1;

		long pow = 1;
		for (int i = 0; i < cellIndex; i++) {
			pow = pow*cellValue;
		}
		System.out.println(pow);
	}
}
