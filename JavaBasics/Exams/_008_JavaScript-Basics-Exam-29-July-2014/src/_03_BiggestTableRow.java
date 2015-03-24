import java.util.Scanner;
//Много важен извод: Double.MIN_VALUE не работи, както се очаква. 
//По дефиниция е най-малката положителна и стойност(без 0), 
//а не най-малката стойност на double. По-добре ще е да се използва
//Double.NEGATIVE_INFINITY
public class _03_BiggestTableRow {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		input.nextLine();
		input.nextLine();
		String currLine = input.nextLine();
		double maxSum = Double.NEGATIVE_INFINITY;
		String[] sums = new String[3];
		boolean exist = false;
		while (!currLine.equals("</table>")) {
			String[] rowInfo = currLine.split("(<tr><td>)|(</th><th>)|(</td><td>)|(</td><td>)|(</td></tr>)"); 
			//System.out.println(Arrays.toString(rowInfo));
			double currSum = 0;
			for (int i = 2; i < 5; i++) {
				if (!rowInfo[i].equals("-")) {
					currSum += Double.parseDouble(rowInfo[i]); 
					exist = true;
				}
			}
			if (currSum > maxSum) {
				maxSum = currSum;
				for (int i = 0; i < sums.length; i++) {
					//System.out.println("fdfsd");
					sums[i] = rowInfo[i+2];
				}
			}
			//System.out.println(currSum);
			currLine = input.nextLine();
		}
		if (exist) {
			String result = "";
			for (int i = 0; i < sums.length; i++) {
				if (!sums[i].equals("-")) {
					result+=" + " + sums[i];
				}
			}
			result = result.substring(3);
			System.out.printf("%s = %s", Double.toString(maxSum).replaceAll("(\\b\\.0+)|(0+$)", ""), result);
		} else {
			System.out.println("no data");
		}	 
	}
}
