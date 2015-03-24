import java.util.Scanner;


public class P02_TriangleArea {

	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		
	    String pointA = input.nextLine();
	    String pointB = input.nextLine();
	    String pointC = input.nextLine();
	    
	    String[] pointAarr = pointA.split(" ");
	    String[] pointBarr = pointB.split(" ");	
	    String[] pointCarr = pointC.split(" ");	
	    
	    int Ax = Integer.parseInt(pointAarr[0]);
	    int Ay = Integer.parseInt(pointAarr[1]);
	    int Bx = Integer.parseInt(pointBarr[0]);
	    int By = Integer.parseInt(pointBarr[1]);
	    int Cx = Integer.parseInt(pointCarr[0]);
	    int Cy = Integer.parseInt(pointCarr[1]);
	    
	    double triangleArea = Math.abs((Ax*(By - Cy) + Bx*(Cy - Ay) + Cx*(Ay - By))/2d);
	    if (triangleArea == 0) {
			System.out.println("0");
		} else {
			System.out.println((int) triangleArea);
		}
	}

}
