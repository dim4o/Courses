import java.util.Scanner;

public class P01_RectangleArea {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		String values = input.nextLine();
		values = values.trim();
		String[] arrValues = values.split(" ");
		
		int height = Integer.parseInt(arrValues[0]);
		int width = Integer.parseInt(arrValues[1]);
		int rectangleArea = height*width;
		System.out.println(rectangleArea);
	}

}
