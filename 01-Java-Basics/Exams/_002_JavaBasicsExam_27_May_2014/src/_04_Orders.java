import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_Orders {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfOrders = Integer.parseInt(input.nextLine());

		LinkedHashMap<String, TreeMap<String, Integer>> ordersMap = new LinkedHashMap<String, TreeMap<String, Integer>>();

		for (int i = 0; i < numOfOrders; i++) {
			String currOrder = input.nextLine();
			String[] orderArr = currOrder.split(" ");
			String name = orderArr[0];
			Integer amount = Integer.parseInt(orderArr[1]);
			String prodict = orderArr[2];
			
			if (ordersMap.containsKey(prodict)) {
				TreeMap<String, Integer> currTreeMap = ordersMap.get(prodict);
				//dobavqme ime i koli4estvo
				if (currTreeMap.containsKey(name)) {
					Integer currValue = currTreeMap.get(name);
					currTreeMap.put(name, currValue + amount);
				} else {
					currTreeMap.put(name, amount);
				}
			} else {
				TreeMap<String, Integer> currTreeMap = new TreeMap<String, Integer>();
				if (currTreeMap.containsKey(name)) {
					Integer currValue = currTreeMap.get(name);
					currTreeMap.put(name, currValue + amount);
				} else {
					currTreeMap.put(name, amount);
				}
				ordersMap.put(prodict, currTreeMap);
			}
		}
		//System.out.println(ordersMap.toString());
		for (Map.Entry<String, TreeMap<String, Integer>> entry: ordersMap.entrySet()) {
			String product = entry.getKey();
			System.out.printf("%s: ", product);
			TreeMap<String, Integer> currTree = entry.getValue();
			int size = 1;
			for (Map.Entry<String, Integer> entry1: currTree.entrySet()) {
				String key = entry1.getKey();
				Integer value = entry1.getValue();
				System.out.printf("%s %s", key, value);
				if (currTree.size() != size) {
					System.out.print(", ");	
				}
				size++;
			}
			System.out.println();
		}
	}
}
