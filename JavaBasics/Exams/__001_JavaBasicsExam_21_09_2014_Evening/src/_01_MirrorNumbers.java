import java.util.Scanner;

public class _01_MirrorNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		String nums = input.nextLine();
		String[] numsStrings = nums.split(" ");
		boolean exist = false;
		for (int i1 = 0; i1 < num; i1++) {
			for (int i2 = i1 + 1; i2 < num; i2++) {
				if (!numsStrings[i1].equals(numsStrings[i2])) {
					String reverse = new StringBuffer(numsStrings[i2]).reverse().toString();
					if ( numsStrings[i1].equals(reverse)) {
						System.out.printf("%s<!>%s\n", reverse, numsStrings[i2]);
						exist = true;
					}
				}
			}
		}
		if (!exist) {
			System.out.println("No");
		}
	}
}
