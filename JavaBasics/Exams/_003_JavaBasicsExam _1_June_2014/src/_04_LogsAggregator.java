import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

//15:51 -- 16:56 - 1:05h 
public class _04_LogsAggregator {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int num = Integer.parseInt(input.nextLine());
		Map<String, Map<String, Integer>> allLogs = new TreeMap<String, Map<String, Integer>>();
		for (int i = 0; i < num; i++) {
			String curLine = input.nextLine();
			//System.out.println(curLine);
			String[] currLog = curLine.split(" ");
			//System.out.println(Arrays.toString(currLog));
			String name = currLog[1];
			Integer duration = Integer.parseInt(currLog[2]);
			String ip = currLog[0];
			if (allLogs.containsKey(name)) {
				Map<String, Integer> value = allLogs.get(name);
				
			    if (value.containsKey(ip)) {
			    	Integer durValue = value.get(ip);
					value.put(ip, duration + durValue);
				} else {
					value.put(ip, duration);
				}
			    allLogs.put(name, value);
			} else {
				Map<String, Integer> value = new TreeMap<String, Integer>();
				value.put(ip, duration);
				allLogs.put(name, value);
			}
		}
		//System.out.println(allLogs.toString());
		
		for (Map.Entry<String, Map<String, Integer>> entry: allLogs.entrySet()) {
			
			System.out.print(entry.getKey() + ": ");
			Map<String, Integer> value = entry.getValue();
			Integer finalDuration = 0;
			ArrayList<String> finalIP = new ArrayList<String>();
			for (Entry<String, Integer> entry1: value.entrySet()) {
				finalDuration += entry1.getValue();
				finalIP.add(entry1.getKey());
			}
			System.out.print(finalDuration + " ");
			System.out.print(finalIP.toString());
			System.out.println();
		}
	}

}
