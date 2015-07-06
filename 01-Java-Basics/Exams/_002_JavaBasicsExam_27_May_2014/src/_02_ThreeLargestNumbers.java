import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class _02_ThreeLargestNumbers {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());
		
		ArrayList<BigDecimal> list = new ArrayList<BigDecimal>();
		
		for (int i = 0; i < count; i++) {
			BigDecimal currValue = input.nextBigDecimal();
			list.add(currValue);
		}
		Collections.sort(list);
		
		if (list.size() < 3) {
			if (list.size() == 2) {
				System.out.println((list.get(list.size() - 1)).toPlainString());
				System.out.println((list.get(list.size() - 2)).toPlainString());
		
			}else if (list.size() == 1) {
				System.out.println((list.get(list.size() - 1)).toPlainString());
			}
			
		} else {
			System.out.println((list.get(list.size() - 1)).toPlainString());
			System.out.println((list.get(list.size() - 2)).toPlainString());
			System.out.println((list.get(list.size() - 3)).toPlainString());
		}		
	}
}
