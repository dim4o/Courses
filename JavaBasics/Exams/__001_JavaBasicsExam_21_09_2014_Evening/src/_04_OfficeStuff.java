import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_OfficeStuff {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOflines = Integer.parseInt(input.nextLine());
		TreeMap<String, LinkedHashMap<String, Integer>> productMap = new TreeMap<String, LinkedHashMap<String, Integer>>();

		for (int i = 0; i < numOflines; i++) {
			String currLineString = input.nextLine();
			currLineString = currLineString.replaceAll("[|]", "");
			String[] info = currLineString.split("[- ]+");
			//System.out.println(Arrays.toString(info));
			String companyName = info[0];
			Integer amount = Integer.parseInt(info[1]);
			String productName = info[2];
			
			if (productMap.containsKey(companyName)) {
				LinkedHashMap<String, Integer> amountMap = productMap.get(companyName);
				if (amountMap.containsKey(productName)) {
					Integer oldValue = amountMap.get(productName);
					amountMap.put(productName, oldValue + amount);
				} else {
					amountMap.put(productName, amount);
				}
				productMap.put(companyName, amountMap);
				
			} else {
				LinkedHashMap<String, Integer> amountMap = new LinkedHashMap<String, Integer>();
				amountMap.put(productName, amount);
				productMap.put(companyName, amountMap);
			}
		}
		//System.out.println(productMap.toString());
		for (Map.Entry<String, LinkedHashMap<String, Integer>> entry1 : productMap.entrySet()) {
			LinkedHashMap<String, Integer> amountMap = entry1.getValue();
			System.out.printf("%s: ", entry1.getKey());
			String productString = "";
			for (Map.Entry<String, Integer> entry2 : amountMap.entrySet()) {
				productString += String.format("%s-%s, ", entry2.getKey(), entry2.getValue());
			}
			System.out.println(productString.substring(0, productString.length() - 2));
		}
	}
}
