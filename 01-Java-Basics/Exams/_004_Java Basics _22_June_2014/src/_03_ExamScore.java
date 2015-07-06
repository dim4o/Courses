import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class _03_ExamScore {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.nextLine();
		input.nextLine();
		
		Map<Integer, ArrayList<String>> examScoresMap = new TreeMap<Integer, ArrayList<String>>();
		HashMap<String, Double> gradesMap = new HashMap<String, Double>();
		
		while (true) {
			
			String currRow = input.nextLine();
			currRow = currRow.replaceFirst("[| ]+", "");
			String[] curRowArr = currRow.split("[| ][ |]+");
			
			if (curRowArr.length > 1) {
				String nameString = curRowArr[0];
				int examScore = Integer.parseInt(curRowArr[1]);
				double grade = Double.parseDouble(curRowArr[2]);
				gradesMap.put(nameString, grade);
				
				if (examScoresMap.containsKey(examScore)) {	
					examScoresMap.get(examScore).add(nameString);
				} else {
					ArrayList<String> newList = new ArrayList<String>();
					newList.add(nameString);
					examScoresMap.put(examScore, newList);
				}
			}
			else {
				break;
			}
		}
		
		for (Map.Entry<Integer, ArrayList<String>> entry: examScoresMap.entrySet()) {
			System.out.print(entry.getKey() + " -> ");
			ArrayList<String> sorted = examScoresMap.get(entry.getKey());
			Collections.sort(sorted);
			double avg = 0;
			for (String ithem : sorted) {
				avg += gradesMap.get(ithem);
			}
			System.out.print(sorted.toString());
			System.out.printf("; avg=%.2f", avg/sorted.size());
			System.out.println();
		}
	}

}
