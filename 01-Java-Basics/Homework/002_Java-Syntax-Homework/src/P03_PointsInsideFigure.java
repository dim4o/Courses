import java.util.Scanner;

public class P03_PointsInsideFigure {

	private static Scanner input;
	public static void main(String[] args) {
		input = new Scanner(System.in);
		String points = input.nextLine();
		String[] pointsArr = points.split(" ");
		float x = Float.parseFloat(pointsArr[0]);
		float y = Float.parseFloat(pointsArr[1]);
		
		if (isInsideFigure(x,y)) {
			System.out.println("Inside");
		} else {
			System.out.println("Outside");
		}
		
	}
    public static boolean isInsideFigure(float x, float y){
    	if (insideRectangle(x,y, 12.5f, 13.5f, 17.5f, 8.5f) ||
    			insideRectangle(x,y, 20f, 13.5f, 22.5f, 8.5f)||
    			insideRectangle(x,y, 12.5f, 8.5f, 22.5f, 6f)) {
    		return true;
		}
    	return false;
    }
	public static boolean insideRectangle(float x, float y, float x1, float y1,
			float x2, float y2) {
		if (x >= x1 && x <= x2 && y >= y2 && y <= y1) {
			return true;
		}
		return false;
	}
}

