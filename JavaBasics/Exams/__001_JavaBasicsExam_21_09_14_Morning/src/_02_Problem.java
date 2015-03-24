import java.util.ArrayList;
import java.util.Scanner;

public class _02_Problem {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numD = Integer.parseInt(input.nextLine());
		// ArrayList<String> maxSums = new ArrayList<String>();
		boolean exist = false;
		ArrayList<Integer> list = new ArrayList<Integer>();
		while (true) {
			String currNumStr = input.nextLine();
			if (currNumStr.equals("End")) {
				break;
			}
			Integer currNum = Integer.parseInt(currNumStr);
			list.add(currNum);
		}
		int maxSum = Integer.MIN_VALUE;
		String bestString = "";
		// System.out.println(list.toString());
		for (int i1 = 0; i1 < list.size(); i1++) {
			for (int i2 = i1 + 1; i2 < list.size(); i2++) {
				for (int i3 = i2 + 1; i3 < list.size(); i3++) {
					int currSum = list.get(i1) + list.get(i2) + list.get(i3);
					if (currSum % numD == 0 && currSum > maxSum) {
						maxSum = currSum;
						bestString = String.format("(%s + %s + %s) %% %s = 0",
								list.get(i1), list.get(i2), list.get(i3), numD);
						exist = true;
					}
				}
			}
		}
		if (exist == false) {
			System.out.println("No");
		} else {
			System.out.println(bestString);
		}
	}
}
