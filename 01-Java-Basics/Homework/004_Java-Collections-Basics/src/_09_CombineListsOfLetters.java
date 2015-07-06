import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _09_CombineListsOfLetters {

	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		String firstString = input.nextLine();
		String secondString = input.nextLine();
		
		List<String> firstList = Arrays.asList(firstString.split(" "));
		List<String> secondList = Arrays.asList(secondString.split(" "));
		
		List<String> unionList = union(firstList, secondList);
		printList(unionList);

	}
	
	public static List<String> union(List<String> firstList, List<String> secondList){
		List<String> union = new ArrayList<String>();
		union.addAll(firstList);
		
		for (String ithem : secondList) {
			if (!union.contains(ithem)) {
				union.add(ithem);
			}
		}	
		return union;
	}
	
	public static void printList(List<String> list){
		for (String ithem : list) {
			System.out.print(ithem + " ");
		}
	}
}
