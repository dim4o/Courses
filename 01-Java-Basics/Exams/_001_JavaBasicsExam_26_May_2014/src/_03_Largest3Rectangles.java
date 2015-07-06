import java.util.Scanner;
//14:57 -- 15:38 --> 41 minutes, 100/100 от първия път
public class _03_Largest3Rectangles {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String rectanglesString = input.nextLine();
		rectanglesString = rectanglesString.replaceAll("[ ]+", "");
		rectanglesString = rectanglesString.replaceAll("^\\[", "");
		rectanglesString = rectanglesString.replaceAll("]$", "");
		String[] rectangles = rectanglesString.split("\\]\\[");
		int[] rectangleAreas = new int[rectangles.length];
		
		for (int i = 0; i < rectangles.length; i++) {
			String[] sides = rectangles[i].split("x");
			int a = Integer.parseInt(sides[0]);
			int b = Integer.parseInt(sides[1]);
			rectangleAreas[i] = a*b;
		}
		
		int maxSum = 0;
		for (int i = 0; i < rectangleAreas.length - 2; i++) {
			int currSum = rectangleAreas[i] + rectangleAreas[i+1] + rectangleAreas[i+2];
			if ( currSum > maxSum) {
				maxSum = currSum;
			}
		}
		System.out.println(maxSum);
	}

}
