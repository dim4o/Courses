import java.util.Scanner;

public class _01_DoubleRakiyaNumbers {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int start = Integer.parseInt(input.nextLine());
		int end = Integer.parseInt(input.nextLine());
		System.out.println("<ul>");
		for (int i = start; i <= end; i++) {
			if (IsDoubleRakiyaNumbers(new Integer(i).toString())) {
				System.out.printf("<li><span class='rakiya'>%s</span><a href=\"view.php?id=%s\">View</a></li>\n", i,i);
			} else {
				System.out.printf("<li><span class='num'>%s</span></li>\n", i);
			}
		}
		System.out.println("</ul>");
	}

	private static boolean IsDoubleRakiyaNumbers(String number) {
		char[] nums = number.toCharArray();
		if (nums.length < 4) {
			return false;
		}
		
		for (int i = 0; i <= nums.length - 4; i++) {
			String curr1 = "" + nums[i] + nums[i + 1];
			for (int k = i + 2; k <= nums.length - 2; k++) {
				String curr2 = "" + nums[k] + nums[k + 1];
				if (curr1.equals(curr2)) {
					return true;
				}
			}
		}
		return false;
	}
}
