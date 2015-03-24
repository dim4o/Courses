import java.math.BigDecimal;
import java.util.Scanner;
//11:50 -- 3:44

public class _03_SimpleExpression {

	public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String expression = input.nextLine();
		expression = "+" + expression.replace(" ", "");
		
		String positive = expression.replaceAll("[-][0-9.]+", "");
		String negative = expression.replaceAll("[+][0-9.]+", "");
		//System.out.println(expression);
		String[] pos = positive.replaceFirst("[+]", "").split("[+]");
		String[] neg = negative.replaceFirst("[-]", "").split("[-]");
		
		BigDecimal posit = new BigDecimal(0);
		BigDecimal negat = new BigDecimal(0);
		if (pos.length > 0) {
			for (int i = 0; i < pos.length; i++) {
				BigDecimal numToAdd = new BigDecimal(pos[i]);
				//System.out.println(axa);
				posit = posit.add(numToAdd);
			}
		}
		if (neg.length >= 1) {
			for (int i = 0; i < neg.length; i++) {
				if ((neg[i].equals("") == false)) {
					negat = negat.add(new BigDecimal((neg[i])));
				}	
			}
		}
		
        BigDecimal result = posit.subtract(negat);
		System.out.println(result);

	}

}
