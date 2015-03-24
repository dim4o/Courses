import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

//1. Pro4itane na vhoda
//2. za vsqka liniq izvli4am cenata i q slagam kato klu4 v TreeMap, za stojnost slagam celiq red. Trqbav da izvele4em i imeto na produkta
//3. V tree mapa vsyshtnost trqbva stoinostta da e treeMap, koito ima klu4 imeto i stoinost celiq red
//<tr><td>Vitamin B5, 350 mg (new)</td><td>16.50</td><td>+3</td></tr>
//<tr><td>Vitamin B5, 350 mg</td><td>16.50</td><td>+3</td></tr>
//Защо е така> Не трябва ли <tr><td>Vitamin B5, 350 mg</td><td>16.50</td><td>+3</td></tr> да е първо
public class _03_SortTable {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.nextLine();

		TreeMap<Double, TreeMap<String, ArrayList<String>>> priceMap = new TreeMap<Double, TreeMap<String, ArrayList<String>>>();

		String curString = input.nextLine();

		while (!curString.equals("</table>")) {

			String[] inputInfo = curString
					.split("(<tr><td>)|(</td><td>)|(</td></tr>)");
			// System.out.println(Arrays.toString(inputInfo));
			String productName = inputInfo[1];
			Double productPrice = Double.parseDouble(inputInfo[2]);

			if (priceMap.containsKey(productPrice)) {
				TreeMap<String, ArrayList<String>> nameMap = priceMap
						.get(productPrice);
				ArrayList<String> list = nameMap.get(productName);
				if (list != null) {
					list.add(curString);
					nameMap.put(productName, list);
				} else {
					list = new ArrayList<String>();
					list.add(curString);
					nameMap.put(productName, list);
				}

			} else {
				TreeMap<String, ArrayList<String>> nameMap = new TreeMap<String, ArrayList<String>>();
				ArrayList<String> list = new ArrayList<String>();
				list.add(curString);
				nameMap.put(productName, list);
				priceMap.put(productPrice, nameMap);
			}
			curString = input.nextLine();
		}
		System.out.println("<table>");
		System.out
				.println("<tr><th>Product</th><th>Price</th><th>Votes</th></tr>");
		for (Map.Entry<Double, TreeMap<String, ArrayList<String>>> entry1 : priceMap
				.entrySet()) {
			TreeMap<String, ArrayList<String>> nameMap = entry1.getValue();
			for (Map.Entry<String, ArrayList<String>> entry2 : nameMap
					.entrySet()) {
				ArrayList<String> list = entry2.getValue();
				for (String string : list) {
					System.out.println(string);
				}
			}
		}
		System.out.println("</table>");
	}
}
