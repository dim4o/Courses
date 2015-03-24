import java.util.Scanner;

public class P09_PointsInsideTheHouse {

	private static Scanner input;
	private static P09_PointsInsideTheHouse inHouse = new P09_PointsInsideTheHouse();

	public static void main(String[] args) {
		input = new Scanner(System.in);
		String coordinates = input.nextLine();
		String[] arrCoord = coordinates.split(" ");
		
		Point point = inHouse.new Point(Float.parseFloat(arrCoord[0]),
				Float.parseFloat(arrCoord[1]));

		if (isInsideRoof(point)
				|| isInsideRectangle(inHouse.new Point(12.5f, 13.5f),
						inHouse.new Point(17.5f, 8.5f), point)
				|| isInsideRectangle(inHouse.new Point(20.5f, 13.5f),
						inHouse.new Point(22.5f, 8.5f), point)) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}

	}
	//inside or outside roof(triangle)
	public static boolean isInsideRoof(Point point) {
		int sign1 = getSign(inHouse.new Point(12.5f, 8.5f), inHouse.new Point(
				17.5f, 3.5f), point);
		int sign2 = getSign(inHouse.new Point(17.5f, 3.5f), inHouse.new Point(
				22.5f, 8.5f), point);
		int sign3 = getSign(inHouse.new Point(22.5f, 8.5f), inHouse.new Point(
				12.5f, 8.5f), point);
		if (sign1 == 0 || sign2 == 0 || sign3 == 0) {
			return true;
		} else if (sign1 == sign2 && sign2 == sign3) {
			return true;
		}
		return false;
	}
	//inside or outside rectangle
	public static boolean isInsideRectangle(Point firstPoint,
			Point secondPoint, Point pointM) {
		if (pointM.x >= firstPoint.x && pointM.x <= secondPoint.x
				&& pointM.y <= firstPoint.y && pointM.y >= secondPoint.y) {
			return true;
		}
		return false;
	}

	
	public static int getSign(Point pointA, Point pointB, Point pointM) {
		float expression = (pointB.x - pointA.x) * (pointM.y - pointA.y)
				- (pointB.y - pointA.y) * (pointM.x - pointA.x);
		if (expression > 0) {
			return 1;
		} else if (expression < 0) {
			return -1;
		} else {
			return 0;
		}
	}
	//inner class for define Point object
	private class Point {
		private float x;
		private float y;

		public Point(float x, float y) {
			this.x = x;
			this.y = y;
		}
	}
}
