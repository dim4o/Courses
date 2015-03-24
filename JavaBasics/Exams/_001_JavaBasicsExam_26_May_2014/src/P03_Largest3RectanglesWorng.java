import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P03_Largest3RectanglesWorng {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String inputStr = input.nextLine();
		String[] recsStrings = inputStr.split("\\]\\[");
		ArrayList<Rectangle> rectangles = new ArrayList<Rectangle>();
		//Rectangle[] rectangles = new Rectangle[recsStrings.length];
		for (int i = 0; i < recsStrings.length; i++) {
			recsStrings[i] = recsStrings[i].replaceAll("[^A-Za-z_0-9]", "");
			int a = Integer.parseInt(recsStrings[i].split("x")[0]);
			int b = Integer.parseInt(recsStrings[i].split("x")[1]);
			rectangles.add(new Rectangle(a, b));
		}
		Collections.sort(rectangles);

		System.out.println(rectangles.get(rectangles.size() - 1).getArea());
		System.out.println(rectangles.get(rectangles.size() - 2).getArea());
		System.out.println(rectangles.get(rectangles.size() - 3).getArea());
	}
}

class Rectangle implements Comparable<Rectangle> {
	public int a;
	public int b;
	public int area;

	public Rectangle(int a, int b) {
		this.a = a;
		this.b = b;
		this.area = a * b;
	}

	public int getArea() {
		int area = a * b;
		return area;
	}

	@Override
	public int compareTo(Rectangle rec) {
		if (this.getArea() - rec.getArea() > 0) {
			return 1;
		}
		if (this.getArea() - rec.getArea() < 0) {
			return -1;
		}
		return 0;
	}
}
