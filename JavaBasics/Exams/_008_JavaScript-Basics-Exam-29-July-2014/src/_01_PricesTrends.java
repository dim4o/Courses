import java.util.Scanner;

public class _01_PricesTrends {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int numOfLines = Integer.parseInt(input.nextLine());
		double currNum = 0;
		double prevNum = 0;
		String[] result = new String[numOfLines];
		
		for (int i = 0; i < numOfLines; i++) {
			currNum = Double.parseDouble(input.nextLine());
			currNum = round(currNum, 2);
			if (currNum == prevNum | i == 0) {
				result[i] = String.format("<tr><td>%.2f</td><td><img src=\"fixed.png\"/></td></tr>", currNum);
			} else if (currNum < prevNum) {
				result[i] = String.format("<tr><td>%.2f</td><td><img src=\"down.png\"/></td></tr>", currNum);
			} else {
				result[i] = String.format("<tr><td>%.2f</td><td><img src=\"up.png\"/></td></tr>", currNum);
			}
			prevNum = currNum;	
		}
		System.out.println("<table>");
		System.out.println("<tr><th>Price</th><th>Trend</th></tr>");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		System.out.println("</table>");
	}
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

}
