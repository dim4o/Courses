

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
//Много важни изводи !!!:
//1.
//Примитивните типове Foloat и Double не закръглат, така както се очаква.
//Например 5.915 ако се закръгли до два знака след запетаята става 5.91,
//a ne 5.92, както хората са свикнали да очакват. За целта трябва да се
//използва класа BigDeciaml
//2.
//Сравнението по стрингове има странно поведени, когато стринговете са в
//кавички. Примерно (C# < C# Basics), но ("C#">"C# Basics"). Това е много
//важен момент и винаги трябва да се има впредвид. За да няма нежелателни
//"аномалии" е най-добре кавичките да се сложат допълнително при форматрането
//и/или отпечатването, а не да са част от самия стринг

public class _04_StudentsCoursesGrades {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLines = input.nextInt();
		Map<String, ArrayList<ArrayList<Float>>> visitsAndGrades = new TreeMap<String, ArrayList<ArrayList<Float>>>();
		Map<String, TreeSet<String>> studentsMap = new TreeMap<String, TreeSet<String>>();

		for (int i = 0; i <= numOfLines; i++) {
			String lineString = input.nextLine();
			String[] coursesInfo = lineString.split("\\|");
			if (i == 0) {
				continue;
			}
			//System.out.println(Arrays.toString(coursesInfo));
			String studentName = "\"" + coursesInfo[0].trim() + "\"";
			String courseName = coursesInfo[1].trim();
			Float grade = Float.parseFloat(coursesInfo[2].trim());
			Float visits = Float.parseFloat(coursesInfo[3].trim());

			if (visitsAndGrades.containsKey(courseName)) {
				ArrayList<ArrayList<Float>> visitsAndGradesList = visitsAndGrades
						.get(courseName);
				ArrayList<Float> gradesList = visitsAndGradesList.get(0);
				ArrayList<Float> visitsList = visitsAndGradesList.get(1);
				gradesList.add(grade);
				visitsList.add(visits);
				visitsAndGrades.put(courseName, visitsAndGradesList);
			} else {
				ArrayList<Float> gradesList = new ArrayList<Float>();
				ArrayList<Float> visitsList = new ArrayList<Float>();
				ArrayList<ArrayList<Float>> visitsAndGradesList = new ArrayList<ArrayList<Float>>();
				gradesList.add(grade);
				visitsList.add(visits);
				visitsAndGradesList.add(gradesList);
				visitsAndGradesList.add(visitsList);
				visitsAndGrades.put(courseName, visitsAndGradesList);
			}
			
			if (studentsMap.containsKey(courseName)) {
				TreeSet<String> nameSet = studentsMap.get(courseName);
				nameSet.add(studentName);
				studentsMap.put(courseName, nameSet);
			} else {
				TreeSet<String> nameSet = new TreeSet<String>();
				nameSet.add(studentName);
				studentsMap.put(courseName, nameSet);
			}
		}
		//System.out.println(visitsAndGrades.toString());
		String result = "";
		result+="{";
		for (Map.Entry<String, ArrayList<ArrayList<Float>>> visitsAndGradesitsAndGradesEntry : visitsAndGrades
				.entrySet()) {
			float avgGrade = getAvg(visitsAndGradesitsAndGradesEntry.getValue()
					.get(0));
			float avgVisits = getAvg(visitsAndGradesitsAndGradesEntry
					.getValue().get(1));
			avgGrade = precision(2, avgGrade);
			avgVisits = precision(2, avgVisits);
			String avgGradeString = String.format("%s", avgGrade).replaceAll(
					"\\.?0*$", "");
			String avgVisitsString = String.format("%s", avgVisits)
					.replaceAll("\\.?0*$", "");
			String visitsAndGradesString = String.format(
					"\"%s\":{\"avgGrade\":%s,\"avgVisits\":%s,\"students\":",
					visitsAndGradesitsAndGradesEntry.getKey(), avgGradeString,
					avgVisitsString);

			String studentString = studentsMap
					.get(visitsAndGradesitsAndGradesEntry.getKey()).toString()
.replaceAll(", ", ",") + "},";
			result += visitsAndGradesString + studentString;
		}
		result = result.substring(0, result.length() - 1);
		result+="}";
		System.out.println(result);
	}

	public static float getAvg(ArrayList<Float> list) {
		float sum = 0;
		for (Float ithem : list) {
			sum += ithem;
		}
		return sum / list.size();
	}

	public static Float precision(int decimalPlace, Float d) {

		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}

}
