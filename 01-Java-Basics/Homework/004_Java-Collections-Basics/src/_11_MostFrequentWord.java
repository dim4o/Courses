import java.util.Map;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class _11_MostFrequentWord {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		String inputString = input.nextLine();
		inputString = inputString.toLowerCase();
		String[] words = inputString.split("[^a-zA-Z]");

		int count = 0;
		for (String ithem : words) {
			if (!ithem.equals("")) {
				if (map.containsKey(ithem)) {
					count = map.get(ithem);
					map.put(ithem, count + 1);
				} else {
					map.put(ithem, 1);
				}			
			}
		}

		SortedSet<Integer> mapValueSet = new TreeSet<Integer>(map.values());
		
		int maxCount = mapValueSet.last();
		//System.out.println(mapValueSet.last());
		
		for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
			if (maxCount == mapEntry.getValue()) {
				System.out.printf("%s -> %s times%n", mapEntry.getKey(), mapEntry.getValue());
			}
		}
	}
}
