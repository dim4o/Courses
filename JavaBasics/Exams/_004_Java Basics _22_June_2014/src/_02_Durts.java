import java.util.Scanner;

public class _02_Durts {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String centerCoord = input.nextLine();
		int a = Integer.parseInt(centerCoord.split(" ")[0]); 
		int b = Integer.parseInt(centerCoord.split(" ")[1]); 
		int radius = Integer.parseInt(input.nextLine());
		int numOfArrows = Integer.parseInt(input.nextLine());
		String arrowString = input.nextLine();
		String[] arrows = arrowString.split("  ");
		
		for (int i = 0; i < numOfArrows; i++) {
			String[] arrowsCoord = arrows[i].split(" ");
			int sX = Integer.parseInt(arrowsCoord[0]);
			int sY = Integer.parseInt(arrowsCoord[1]);

			if (isInside(a, b, radius, sX, sY)) {	
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}	
		}			
	}
	public static boolean isInside(int a, int b, int radius, int sX, int sY ){
		boolean inside = false;
		int x1 = a - radius/2;
		int y1 = b - radius;
		int x2 = a + radius/2;
		int y2 = b + radius;
		if (sX >=x1 && sX <= x2 && sY >= y1 && sY <= y2) {
			inside = true;
		}
		x1 = a - radius;
		y1 = b - radius/2;
		x2 = a + radius;
		y2 = b + radius/2;
		if (sX >= x1 && sX <= x2 && sY >= y1 && sY <= y2) {
			inside = true;
		}
		return inside;
	}
}
