import java.util.Scanner;

public class _02_PossibleTriangles {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		boolean exist = false;
		while (true) {
			String line = input.nextLine();
			if (line.equals("End")) {
				break;
			}
			String[] sidesStrings = line.split(" ");
			double a = Double.parseDouble(sidesStrings[0]);
			double b = Double.parseDouble(sidesStrings[1]);
			double c = Double.parseDouble(sidesStrings[2]);
			double[] sides = { a, b, c };
			for (int i1 = 0; i1 < 3; i1++) {
				for (int i2 = 0; i2 < sides.length; i2++) {
					for (int i3 = 0; i3 < sides.length; i3++) {
						if (i1 != i2 && i1 != i3 && i2 != i3) {
							if (sides[i1] + sides[i2] > sides[i3]
									&& sides[i1] <= sides[i3]
									&& sides[i2] <= sides[i3]
									&& sides[i1] < sides[i2]) {
								System.out.printf("%.2f+%.2f>%.2f\n",
										sides[i1], sides[i2], sides[i3]);
								exist = true;
							}
						}
					}
				}
			}
		}
		if (!exist) {
			System.out.println("No");
		}
	}
}
