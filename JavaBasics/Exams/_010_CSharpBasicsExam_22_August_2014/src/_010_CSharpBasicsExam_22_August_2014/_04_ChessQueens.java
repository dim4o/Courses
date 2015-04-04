package _010_CSharpBasicsExam_22_August_2014;

import java.util.Scanner;

public class _04_ChessQueens {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int n = Integer.parseInt(input.nextLine());
		int d = Integer.parseInt(input.nextLine());
		boolean exist = false;
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				//rows
				if (row + d + 1 <= n) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96 + d + 1), col);
					exist = true;
				}
				if (row - d - 1 >= 1) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96 - d - 1), col);
					exist = true;
				}
				//cols
				if (col + d + 1 <= n) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96), col + d + 1);
					exist = true;
				}
				if (col - d - 1 >= 1) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96), col - d - 1);
					exist = true;
				}
				//down-right
				if (row + d + 1 <= n && col + d + 1 <= n) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96 + d + 1), col + d + 1);
					exist = true;
				}
				//up-left
				if (row - d - 1 >=1 && col - d - 1 >=1) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96 - d - 1), col - d - 1);
					exist = true;
				}
				//up-right
				if (row - d - 1 >= 1 && col + d + 1 <= n) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96 - d - 1), col + d + 1);
					exist = true;
				}
				//down-left
				if (row + d + 1 <= n && col - d - 1 >= 1) {
					System.out.printf("%s%s - %s%s\n", (char)(row + 96), col, (char)(row + 96 + d + 1), col - d - 1);
					exist = true;
				}
			}
		}
		if (exist == false) {
			System.out.println("No valid positions");
		}
	}

}
