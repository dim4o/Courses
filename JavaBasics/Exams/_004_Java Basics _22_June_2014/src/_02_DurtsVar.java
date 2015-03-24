import java.lang.String;
import java.util.Scanner;

//16:39 -- 17:20 --> 41 minutes, 100/100 от първия път
public class _02_DurtsVar {

	public static void main(String[] args) {
		//System.out.println(isInside(6,4, 4,4, 6,7));
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String centerCoordString = input.nextLine();
		String[] centerCoord = centerCoordString.split(" ");
		int cenX = Integer.parseInt(centerCoord[0]);
		int cenY = Integer.parseInt(centerCoord[1]);
		int radius = Integer.parseInt(input.nextLine());
		int numOfShoots = Integer.parseInt(input.nextLine());
		String shotsString = input.nextLine();
		String[] shootsArr = shotsString.split("  ");

		for (int i = 0; i < numOfShoots; i++) {
			String[] currShoot = shootsArr[i].trim().split(" ");
			int shootX = Integer.parseInt(currShoot[0]);
			int shootY = Integer.parseInt(currShoot[1]);
			//System.out.println(Arrays.toString(currShoot));
			int recX1 = cenX - radius/2;
			int recY1 = cenY - radius;
			int recX2 = cenX + radius/2;
			int recY2 = cenY + radius;
			
			int recX1a = cenX - radius;
			int recY1a = cenY - radius/2;
			int recX2a = cenX + radius;
			int recY2a = cenY + radius/2;
			 
			if (isInside(shootX, shootY, recX1, recY1, recX2, recY2) || isInside(shootX, shootY, recX1a, recY1a, recX2a, recY2a)) {
				System.out.println("yes");

			} else {
				System.out.println("no");
			} 
		}
	}

	public static boolean isInside(int pointX, int pointY, int recX1, int recY1,
			int recX2, int recY2) {
		if (pointX >= recX1 && pointX <= recX2 && pointY >= recY1
				&& pointY <= recY2) {
			return true;
		}
		return false;
	}
}
