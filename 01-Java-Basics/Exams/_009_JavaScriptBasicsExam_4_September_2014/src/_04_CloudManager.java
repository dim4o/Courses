import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CloudManager {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLines = Integer.parseInt(input.nextLine());

		Map<String, ArrayList<ArrayList<String>>> cloudMap = new TreeMap<String, ArrayList<ArrayList<String>>>();

		for (int i = 0; i < numOfLines; i++) {
			String currLine = input.nextLine();
			String[] fileInfo = currLine.split(" ");
			String fileName = "\"" + fileInfo[0].trim() + "\"";
			String fileExtention = fileInfo[1].trim();
			String fileSize = fileInfo[2].trim().replaceAll("[A-Z]+", "");

			if (cloudMap.containsKey(fileExtention)) {
				ArrayList<ArrayList<String>> nameAndSize = cloudMap
						.get(fileExtention);
				nameAndSize.get(0).add(fileName);
				nameAndSize.get(1).add(fileSize);
			} else {
				ArrayList<ArrayList<String>> nameAndSize = new ArrayList<ArrayList<String>>();
				ArrayList<String> nameList = new ArrayList<String>();
				ArrayList<String> sizeList = new ArrayList<String>();
				nameList.add(fileName);
				sizeList.add(fileSize);
				nameAndSize.add(nameList);
				nameAndSize.add(sizeList);
				cloudMap.put(fileExtention, nameAndSize);
			}
		}
		String result = "{";
		for (Entry<String, ArrayList<ArrayList<String>>> entrySet : cloudMap
				.entrySet()) {
			Collections.sort(entrySet.getValue().get(0));
			String fileList = entrySet.getValue().get(0).toString()
					.replaceAll(", ", ",");

			result += String.format("\"%s\":{\"files\":", entrySet.getKey());

			result += String.format("%s,\"memory\":\"%.2f\"},", fileList,
					getSum(entrySet.getValue().get(1)));

		}
		result = result.substring(0, result.length() - 1);
		result += "}";
		System.out.println(result);
	}

	public static float getSum(ArrayList<String> list) {
		float sum = 0;
		for (String ithem : list) {
			sum += Float.parseFloat(ithem);
		}
		return sum;
	}
}
