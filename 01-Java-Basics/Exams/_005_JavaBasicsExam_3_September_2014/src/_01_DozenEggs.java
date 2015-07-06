import java.util.Scanner;


public class _01_DozenEggs {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int eggs = 0;
		int dozens = 0;
		for (int i = 0; i < 7; i++) {
			String currLine = input.nextLine();
			String[] currArr = currLine.split(" ");
			if (currArr[1].equals("eggs")) {
				eggs+=Integer.parseInt(currArr[0]);
			} else {
				dozens+=Integer.parseInt(currArr[0]);
			}
		}
		
		dozens += eggs / 12;
		eggs %= 12;
		
		System.out.printf("%s dozens + %s eggs", dozens, eggs);		
	}
}
