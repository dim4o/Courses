import java.util.Scanner;

public class _05_AngleUnitConverter {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);

		int numberOfQueries = Integer.parseInt(input.nextLine());

		for (int i = 0; i < numberOfQueries; i++) {
			String query = input.nextLine();
			String[] queryes = query.split(" ");

			double value = Double.parseDouble(queryes[0]);
			String measure = queryes[1];

			if (measure.equals("rad")) {
				double deg = convertRadToDeg(value);
				System.out.printf("%.6f deg%n", deg);
			} else {
				double rad = convertDegToRad(value);
				System.out.printf("%.6f rad%n", rad);
			}
		}
	}
	
    //converts degrees to radians
	private static double convertDegToRad(double deg) {
		double rad = deg * (Math.PI/180);
		return rad;
	}
	//converts radians to degrees
	private static double convertRadToDeg(double rad) {
		double deg = rad * (180 / Math.PI);
		return deg;
	}

}