import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
//15:40 -- 15:59 --> 19 minutes, 100/100 от първия път
public class _04_CouplesFrequency {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String numberString = input.nextLine();
		String[] nums = numberString.split(" ");
		
		LinkedHashMap< String, Integer> couplesMap = new LinkedHashMap<String, Integer>();
		
		for (int i = 0; i < nums.length - 1; i++) {
			String couple = nums[i] + " " + nums[i+1];
			if (couplesMap.containsKey(couple)) {
				Integer value = couplesMap.get(couple);
				couplesMap.put(couple, value + 1);
			} else {
				couplesMap.put(couple, 1);
			}
		}
		
		for (Map.Entry<String, Integer> ithem: couplesMap.entrySet()) {
			double frequency = (double) ithem.getValue()/(nums.length - 1)*100;;
			System.out.printf("%s -> %.2f%%%n", ithem.getKey(), frequency);
		}
		
	}
}
