import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_ActivityTrackerVar {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLines = Integer.parseInt(input.nextLine());

		Map<Integer, Map<String, Integer>> activityMap = new TreeMap<Integer, Map<String, Integer>>();
		for (int i = 0; i < numOfLines; i++) {
			String currLineString = input.nextLine();
			String[] infoStrings = currLineString.split("[/ ]");
			Integer month = Integer.parseInt(infoStrings[1]);
			String userName = infoStrings[3];
			Integer distance = Integer.parseInt(infoStrings[4]);
			Map<String, Integer> currNameMap = activityMap.get(month);

			if (currNameMap != null) {
				Integer oldDist = currNameMap.get(userName);
				if (oldDist != null) {
					currNameMap.put(userName, oldDist + distance);
				} else {
					currNameMap.put(userName, distance);
				}
			} else {
				currNameMap = new TreeMap<String, Integer>();
				currNameMap.put(userName, distance);
				activityMap.put(month, currNameMap);
			}
		}

		for (Map.Entry<Integer, Map<String, Integer>> entrySetActivity : activityMap.entrySet()) {
			Map<String, Integer> nameMap = entrySetActivity.getValue();
			ArrayList<String> nameAndDist = new ArrayList<String>();
			for (Map.Entry<String, Integer> entrySetNames : nameMap.entrySet()) {
				String nameAndDistString = entrySetNames.getKey() +"("+entrySetNames.getValue()+")";
				nameAndDist.add(nameAndDistString);
			}
			String allNamesAndDists = nameAndDist.toString().replaceAll("[\\[\\]]", "");
			System.out.printf("%s: %s%n", entrySetActivity.getKey(), allNamesAndDists);
		}
	}
}
