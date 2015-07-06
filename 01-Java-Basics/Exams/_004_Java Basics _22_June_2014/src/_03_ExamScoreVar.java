import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
 
public class _03_ExamScoreVar {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.nextLine();
		input.nextLine();
		String currLine = input.nextLine();
		TreeMap<Integer, TreeMap<String, Double>> examMap = new TreeMap<Integer, TreeMap<String, Double>>();
		while (!currLine.contains("---")) {

			String[] studentInfo = currLine.split("[| ][ |]+");
			//System.out.println(Arrays.toString(studentInfo));
			String studentName = studentInfo[1].trim();
			Integer examScore = Integer.parseInt(studentInfo[2].trim());
			Double grade = Double.parseDouble(studentInfo[3].trim());

			if (examMap.containsKey(examScore)) {
				TreeMap<String, Double> gradeMap = examMap.get(examScore);
				gradeMap.put(studentName, grade);
				examMap.put(examScore, gradeMap);
			} else {
				TreeMap<String, Double> gradeMap = new TreeMap<String, Double>();
				gradeMap.put(studentName, grade);
				examMap.put(examScore, gradeMap);
			}
			currLine = input.nextLine();
		}

		for (Map.Entry<Integer, TreeMap<String, Double>> entry1 : examMap
				.entrySet()) {
			TreeMap<String, Double> gradeMap = entry1.getValue();
			ArrayList<String> studentList = new ArrayList<String>();
			Double avg = 0.0d;
			for (Map.Entry<String, Double> entry2 : gradeMap.entrySet()) {
				studentList.add(entry2.getKey());
				avg += entry2.getValue();
			}
			Collections.sort(studentList);
			String studentListString = studentList.toString();
			avg /= (double)studentList.size();
			System.out.printf("%s -> %s; avg=%.2f\n", entry1.getKey(), studentListString, avg);
		}
	}

}
