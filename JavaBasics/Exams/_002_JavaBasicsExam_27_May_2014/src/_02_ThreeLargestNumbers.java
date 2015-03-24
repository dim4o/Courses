import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//15 minutes --> 60/100, 5:12 --> 100/100
//16:44 -- 16:11 --> 27 minutes в търсене на грешката
//Тотал: ~15 + 27 = ~42 minutes 
//Изводи:
//1. Вместо прост лист лекомислено бях сложил TreeSet. Но в задачата никъде не е казно, 
//че трябва да се отпечатат само различни елементи. В случая трябва да използам List и после да го сортитрам.
//2. Добре съобразих, че ще трябва да използвам BigDecimal
//3. Не бях предвидил случаите, когато се подават 1 и 2 елемента
//4. Бях останал с впечатление, че BigDecimal не се отпечатва в scientific notation, но изглежда не е така
//наложи се да използвам метода .toPlainString());
//Трябва добре да проуча BigDecimal класа и неговите методи !
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
