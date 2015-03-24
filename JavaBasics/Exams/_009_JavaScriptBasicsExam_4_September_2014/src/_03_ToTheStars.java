import java.util.Scanner;


public class _03_ToTheStars {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String starSystems1 = input.nextLine();
		String starSystems2 = input.nextLine();
		String starSystems3 = input.nextLine();
		String currLocation = input.nextLine();
		float numOfTurns = Float.parseFloat(input.nextLine());
		float nX = Float.parseFloat(currLocation.split(" ")[0]);
		float nY = Float.parseFloat(currLocation.split(" ")[1]);
		//System.out.println(inRange("Alpha-Centauri 7 5", 7, 7));
		//String[] starSyastems = {starSystems1, starSystems2, starSystems3};
		for (int ii = 0; ii <= numOfTurns; ii++) {
			if (inRange(starSystems1, nX, nY + ii).equals(starSystems1.toLowerCase().split(" ")[0])) {
				System.out.println(inRange(starSystems1, nX, nY + ii));
			} else if (inRange(starSystems2, nX, nY + ii).equals(starSystems2.toLowerCase().split(" ")[0])) {
				System.out.println(inRange(starSystems2, nX, nY + ii));
			} else if (inRange(starSystems3, nX, nY + ii).equals(starSystems3.toLowerCase().split(" ")[0])) {
				System.out.println(inRange(starSystems3, nX, nY + ii));
			} else {
				System.out.println("space");
			}		
		}
	}
	public static String inRange(String starSystem, float nX, float nY){
		
		String name = starSystem.split(" ")[0].toLowerCase();
		float sX = Float.parseFloat(starSystem.split(" ")[1]);
		float sY = Float.parseFloat(starSystem.split(" ")[2]);
		
		if (nX >= sX - 1 && nX <= sX + 1 && nY >= sY - 1 && nY <= sY + 1 ) {
			return name;
		}
		return "space";
	}
}
