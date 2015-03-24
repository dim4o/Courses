import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class _Opiti {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float a = 5.91500f;
		float b = 29.294998f;
		float c = 6f;
		System.out.printf("%.2f%n", a);
		System.out.printf("%.2f%n", b);
		System.out.println(precision(2, a));
		System.out.println(precision(2, c));
		int comp = "C# Basics".compareTo("C#");
		String[] arr = {"\"C#\"", "\"C# Basics\""};
		Arrays.sort(arr);
		System.out.println(comp);
		System.out.println(Arrays.toString(arr));
		Map<String, Integer> map = new TreeMap<String, Integer>();
		map.put("\"C# Basics\"", 1);
		map.put("\"C#\"", 2);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey());
			System.out.println(entry.getKey());
		}
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		@SuppressWarnings("unused")
		String ssString = input.nextLine();
		@SuppressWarnings("unused")
		ArrayList<String> arrayList = new ArrayList<String>();	
	}

	public static Float precision(int decimalPlace, Float d) {

		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
}
