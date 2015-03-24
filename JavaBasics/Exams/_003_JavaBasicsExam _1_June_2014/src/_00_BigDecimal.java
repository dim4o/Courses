import java.math.BigDecimal;

public class _00_BigDecimal {

	public static void main(String[] args) {
		BigDecimal posit = new BigDecimal(0);
		//for (int i = 0; i < 3; i++) {
			BigDecimal numToAdd = new BigDecimal(3);
			// System.out.println(axa);
			posit = posit.add(numToAdd);
		//}
		System.out.println(posit);
		// BigDecimal bd1 = new BigDecimal(0);
		// BigDecimal bd2 = new BigDecimal(2);
		// BigDecimal res = bd1.add(bd2);
		// res = res.add(bd2);
		// System.out.println(res);
	}

}
