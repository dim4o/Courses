//import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Problem {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		TreeMap<String, LinkedHashMap<String, Integer>> nutMap  = new TreeMap<String, LinkedHashMap<String, Integer>>();
		for (int i = 0; i < num; i++) {
			String currLine = input.nextLine();
			String[] currInfo = currLine.split("[ ]+");
			//System.out.println(Arrays.toString(currInfo));
			String companyName = currInfo[0];
			String nutName = currInfo[1];
			//System.out.println(Arrays.toString(currInfo));
			currInfo[2] = currInfo[2].replaceAll("[^0-9]+", "");
			Integer nutsAmount = Integer.parseInt(currInfo[2]);
			
			if (nutMap.containsKey(companyName)) {
				LinkedHashMap<String, Integer> amountMap = nutMap.get(companyName);
				if (amountMap.containsKey(nutName)) {
					Integer currAm = amountMap.get(nutName);
					amountMap.put(nutName, nutsAmount + currAm);
				} else {
					amountMap.put(nutName, nutsAmount);
				}
				nutMap.put(companyName, amountMap);
				
			} else {
				LinkedHashMap<String, Integer> amountMap = new LinkedHashMap<String, Integer>();
				amountMap.put(nutName, nutsAmount);
				nutMap.put(companyName, amountMap);
			}
		}
		//System.out.println(nutMap.toString());
		
		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry1 : nutMap.entrySet()) {
			LinkedHashMap<String, Integer> amountMap = entry1.getValue();
			System.out.printf("%s: ", entry1.getKey());
			String amounts = "";
			for (Map.Entry<String, Integer> entry2 : amountMap.entrySet()) {
				amounts += String.format("%s-%skg, ", entry2.getKey(), entry2.getValue());
			}
			System.out.println(amounts.substring(0, amounts.length() - 2));
		}
	}
}
