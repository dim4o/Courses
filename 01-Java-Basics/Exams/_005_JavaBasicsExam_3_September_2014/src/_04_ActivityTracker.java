import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;

import java.util.TreeMap;

public class _04_ActivityTracker {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int nums = Integer.parseInt(input.nextLine());
		TreeMap<Integer, TreeMap<String, Double>> activityMap = new TreeMap<Integer, TreeMap<String, Double>>();
		for (int i = 0; i < nums; i++) {
			String currLine = input.nextLine();
			String[] inputStrings = currLine.split(" ");
			String date = inputStrings[0];
			String[] dateArr = date.split("[/]");
			Integer month = Integer.parseInt(dateArr[1]);
			String user = inputStrings[1];
			Double distance = Double.parseDouble(inputStrings[2]);
			// System.out.printf("%s %s %s%n", month, user, distance);
			if (activityMap.containsKey(month)) {
				TreeMap<String, Double> currMap = activityMap.get(month);
				if (currMap.containsKey(user)) {
					Double value = currMap.get(user);
					currMap.put(user, value + distance);
				} else {
					currMap.put(user, distance);
				}
			} else {
				TreeMap<String, Double> currMap = new TreeMap<String, Double>();
				if (currMap.containsKey(user)) {
					Double value = currMap.get(user);
					currMap.put(user, value + distance);
				} else {
					currMap.put(user, distance);
				}
				activityMap.put(month, currMap);
			}
		}
		// System.out.println(act?ivityMap.toString());
		for (Map.Entry<Integer, TreeMap<String, Double>> entry : activityMap
				.entrySet()) {
			Integer month = entry.getKey();
			TreeMap<String, Double> treeValue = entry.getValue();
			System.out.printf("%s: ", month);
			ArrayList<Double> list = new ArrayList<Double>(treeValue.values());
			Collections.sort(list);
			int count = 0;
			// for (int i = list.size() - 1 ; i >= 0; i--) {
			for (Map.Entry<String, Double> entry1 : treeValue.entrySet()) {
				// if (list.get(i).equals(entry1.getValue())) {
				String user = entry1.getKey();
				Double distance = entry1.getValue();

				String dist = Double.toString(distance);
				// System.out.println();
				System.out
						.printf("%s(%s)", user, dist.replaceAll("\\.0*$", ""));
				if (count < treeValue.size() - 1) {
					System.out.print(", ");
					//count = 0;
				}
				count++;
			}
			System.out.println();
		}
	}

}
