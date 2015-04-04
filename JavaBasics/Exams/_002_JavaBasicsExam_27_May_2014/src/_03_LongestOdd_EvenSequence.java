import java.util.Scanner;


public class _03_LongestOdd_EvenSequence {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner inputScanner = new Scanner(System.in);
		String numsString = inputScanner.nextLine();//"(3) (22) (-18) (55) (44) (3) (21)"
		numsString = numsString.replaceAll("[ ]+", "");
		numsString = numsString.replaceAll("^\\(", "");
		numsString = numsString.replaceAll("\\)$", "");
		numsString = numsString.replaceAll("[-]", "");
		String[] numsArr = numsString.split("\\)\\(");
		int[] nums = new int[numsArr.length];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(numsArr[i]);
			if (nums[0] == 0) {
				nums[0] = 2;
			}
		}
		
		int maxLen = 1;
		int len = 1;
		//String val = "odd";
		for (int i = 1; i < nums.length; i++) {
//			if (nums[i] == 0 && nums[i - 1]) {
//				
//			}
			if (isOdd(nums[i]) != isOdd(nums[i-1]) || (nums[i] == 0 || nums[i-1] == 0)) {
				len++;
			}
			else {
				if (len > maxLen) {
					maxLen = len;
				}
				len = 1;
			}
		}
		if (len > maxLen) {
			maxLen = len;
		}
		System.out.println(maxLen);
	}
	static boolean isOdd(int num){
		if (num % 2 != 0) {
			return true;
		}
		return false;
	}

}
