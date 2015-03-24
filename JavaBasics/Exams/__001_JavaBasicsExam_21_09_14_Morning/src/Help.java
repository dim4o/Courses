import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class Help {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//@SuppressWarnings("resource")
		//Scanner input = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		//splits array and put to HashSet
		String someString = "A, B, C";
		HashSet<String> handSet = new HashSet<String>(Arrays.asList(someString.split("[, ]+")));
		
		//initializing BigDecimal
		BigDecimal number1 = new BigDecimal("6.35");// 6.35
		BigDecimal number2 = new BigDecimal(6.35);// 6.3499999...
		BigDecimal sum = number1.add(new BigDecimal("7"));//13.35
		
		//integer to bin string
		int num = 35;
		String bin = Integer.toBinaryString(num); //100011
		
		//integer to hex string
		String hex = Integer.toHexString(num);
		System.out.println(hex); //23
		
		//int
		//0
		//-2147483648
		//+2147483647
		
		//long
		//0L
		//-9223372036854775808
		//+9223372036854775807

	}
	//rounds float/double number correctly
	public static Float precision(int decimalPlace, Float d) {

		BigDecimal bd = new BigDecimal(Float.toString(d));
		bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		return bd.floatValue();
	}
}
