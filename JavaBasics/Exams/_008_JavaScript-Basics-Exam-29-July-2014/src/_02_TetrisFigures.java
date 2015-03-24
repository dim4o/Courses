import java.util.Scanner;

public class _02_TetrisFigures {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfRows = Integer.parseInt(input.nextLine());
		char[][] matrix = new char[numOfRows][];
		for (int i = 0; i < numOfRows; i++) {
			String currRow = input.nextLine();

			matrix[i] = currRow.toCharArray();

		}
		// for (int i = 0; i < matrix.length; i++) {
		// for (int j = 0; j < matrix[0].length; j++) {
		// System.out.print(matrix[i][j]);
		// }
		// System.out.println();
		// }
		String[] arr_L = { "0 0", "1 0", "2 0", "2 1" };
		String[] arr_J = { "0 0", "1 0", "2 0", "2 -1" };
		String[] arr_O = { "0 0", "0 1", "1 0", "1 1" };
		String[] arr_I = { "0 0", "1 0", "2 0", "3 0" };
		String[] arr_Z = { "0 0", "0 1", "1 1", "1 2" };
		String[] arr_S = { "0 0", "0 1", "-1 1", "-1 2" };
		String[] arr_T = { "0 0", "0 1", "0 2", "1 1" };

		System.out
				.printf("{\"I\":%s,\"L\":%s,\"J\":%s,\"O\":%s,\"Z\":%s,\"S\":%s,\"T\":%s}",
						countFigures(matrix, arr_I),
						countFigures(matrix, arr_L),
						countFigures(matrix, arr_J),
						countFigures(matrix, arr_O),
						countFigures(matrix, arr_Z),
						countFigures(matrix, arr_S),
						countFigures(matrix, arr_T));
	}

	public static int countFigures(char[][] matrix, String[] arr) {
		int count = 0;

		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				boolean exist = false;
				for (int i = 0; i < arr.length; i++) {
					String[] valuesStrings = arr[i].split(" ");
					int x = Integer.parseInt(valuesStrings[0]);
					int y = Integer.parseInt(valuesStrings[1]);
					int currRow = row + x;
					int currCol = col + y;
					if (currRow < matrix.length && currRow >= 0
							&& currCol < matrix[0].length && currCol >= 0
							&& matrix[currRow][currCol] == 'o') {
						exist = true;
					} else {
						exist = false;
						break;
					}
				}
				if (exist) {
					count++;
					// exist = false;
				}
			}
		}
		return count;
	}
}
